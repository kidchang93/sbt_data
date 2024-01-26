package kr.co.board.common;

import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class inOneClass {


    @Transactional
    public void multiDownload(ContentMultiDownloadRequest request, HttpServletResponse response) throws Exception {
        List<String> idList = request.getContentIdList();
        List<String> filePathList = new ArrayList<>();
        List<String> fileNameList = new ArrayList<>();
        for (String id : idList) {
            Map<String, Object> map = contentMapper.getContentFileById(id);
            String filePath = String.valueOf(map.get("file_path"));
            String fileOrgName = String.valueOf(map.get("file_org_name"));
            filePathList.add(filePath);
            fileNameList.add(fileOrgName);
        }
        try {
            List<S3ObjectInputStream> inputList = new ArrayList<>();
            LocalDateTime nowDate = LocalDateTime.now();
            String formatDate = nowDate.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String zipFileName = "MYZIP_" + formatDate;

            for (String filePath : filePathList) {
                S3Object fullObject = s3Client.getObject(bucketName, filePath);
                S3ObjectInputStream objectInputStream = fullObject.getObjectContent();
                inputList.add(objectInputStream);
            }

            //convertListS3ObjectInputStreamToFile START
            List<File> fileList = new ArrayList<>();
            int count = 0;
            for (S3ObjectInputStream stream : inputStream) {
                String path = stream.getHttpRequest().getURI().getPath();
                String[] split = path.split("/");
                String fileName = fileNameList.get(count);
                count++;

                //createFileName START
                String extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
                String filename = fileName.substring(0, fileName.lastIndexOf("."));
                String finalName = count + "." + extension;
                //createFileName END

                //convertS3ObjectInputStreamToFile START
                File file = new File(fileName);
                try (OutputStream outputStream = new FileOutputStream(file)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    //convertS3ObjectInputStreamToFile END
                }
                stream.close();
                files.add(file);
            }
            //convertListS3ObjectInputStreamToFile END

            File zipFile = File.createTempFile(zipFileName, ".zip");
            zipFile.deleteOnExit();
            try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile))) {
                byte[] buf = new byte[1024];
                for (File file : fileList) {
                    if (file.exists()) {
                        try (FileInputStream fis = new FileInputStream(file)) {
                            ZipEntry zipEntry = new ZipEntry(file.getName());
                            out.putNextEntry(zipEntry);
                            int len;
                            while ((len = fis.read(buf)) > 0) {
                                out.write(buf, 0, len);
                            }
                            out.closeEntry();
                        }
                    }
                }
                for (File file : fileList) {
                    deleteFile(file);
                }
            }
            byte[] bytes = FileCopyUtils.copyToByteArray(zipFile);
            response.setContentType("application/zip;");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + zipFileName + ".zip" + "\";");
            FileCopyUtils.copy(bytes, response.getOutputStream());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        request.setUserId(SessionUtil.getLoginedUserId());
        request.setScrapId(null);
        request.setScrapDownYn('N');
        //Insert Log
        int insert = contentMapper.addContentMultiDownloadLog(request);
        if (insert < 1) {
            throw new Exception("로그 저장에 실패했습니다.");
        }
    }
}