//package com.ckcloud.commons;
//
//import jakarta.servlet.MultipartConfigElement;
//import org.springframework.boot.web.servlet.MultipartConfigFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.util.unit.DataSize;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.support.StandardServletMultipartResolver;
//
//public class MultipartConfig {
//    @Bean
//    public MultipartResolver multipartResolver() {
//        return new StandardServletMultipartResolver();
//    }
//
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation("E:\\upload\\temp\\bootS3");
//        factory.setMaxRequestSize(DataSize.ofMegabytes(100L));
//        factory.setMaxFileSize(DataSize.ofMegabytes(100L));
//
//        return factory.createMultipartConfig();
//    }
//}
