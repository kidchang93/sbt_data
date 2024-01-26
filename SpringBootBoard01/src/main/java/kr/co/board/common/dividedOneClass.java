package kr.co.board.common;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.springframework.http.codec.multipart.MultipartUtils.deleteFile;

public class dividedOneClass {

   /** @apiNote content multi download
   * @author KJE
   * @request ContentMultiDownloadRequest
   * @since 2023-06-16
   */
    @ResponseBody
    @PostMapping(value = "/multiDownload")
    public void multiDownload(@ModelAttribute ContentMultiDownloadRequest request, HttpServletResponse response) throws Exception {
        contentService.multiDownload(request, response);
    }


    /**
     * @apiNote content multi download, add log
     * @author KJE
     * @request ContentMultiDownloadRequest
     * @since 2023-06-16
     */
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
            //S3Util START//
            s3Util.multiDownload(fileNameList, filePathList, response);
            // S3Util END//
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

  //===================== s3Util ==========================

    /**
     * @apiNote DOWNLOAD FILE ON ZIP
     * @author KJE
     * @request fileNameList, filePathList
     * @since 2023-06-16
     * try - with - resources
     */
    public void multiDownload(List<String> fileNameList, List<String> filePathList, HttpServletResponse response) throws IOException {
        List<S3ObjectInputStream> inputList = new ArrayList<>();
        LocalDateTime nowDate = LocalDateTime.now();
        String formatDate = nowDate.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String zipFileName = "MYZIP_" + formatDate;

        for (String filePath : filePathList) {
            S3Object fullObject = s3Client.getObject(bucketName, filePath);
            S3ObjectInputStream objectInputStream = fullObject.getObjectContent();
            inputList.add(objectInputStream);
        }

        List<File> fileList = convertListS3ObjectInputStreamToFile(fileNameList, inputList);
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
    }


    /**
     * @return file List
     * @apiNote convert list S3Object to File
     * @author KJE
     * @request S3ObjectInputStream
     * @since 2023-06-16
     */
    private List<File> convertListS3ObjectInputStreamToFile(List<String> fileNameList, List<S3ObjectInputStream> inputStream) throws IOException {
        List<File> files = new ArrayList<>();
        int count = 0;
        for (S3ObjectInputStream stream : inputStream) {
            String path = stream.getHttpRequest().getURI().getPath();
            String[] split = path.split("/");
            String fileName = fileNameList.get(count);
            count++;
            File file = convertS3ObjectInputStreamToFile(stream, createFileName(fileName, count));
            stream.close();
            files.add(file);
        }
        return files;
    }

    /**
     * @return name of file
     * @apiNote deduplicate name - 파일 이름 중복 방지
     * @author KJE
     * @request original file name and count
     * @since 2023-11-21
     */
    private String createFileName(String fileName, int count) {
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        String filename = fileName.substring(0, fileName.lastIndexOf("."));
        return filename + count + "." + extension;
    }


    /**
     * @return file
     * @apiNote convert S3Object to File
     * @author KJE
     * @request S3ObjectInputStream, file name
     * @since 2023-06-16
     * try - with - resources
     */
    private File convertS3ObjectInputStreamToFile(S3ObjectInputStream inputStream, String fileName) throws IOException {
        File file = new File(fileName);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
        return file;
    }


}
