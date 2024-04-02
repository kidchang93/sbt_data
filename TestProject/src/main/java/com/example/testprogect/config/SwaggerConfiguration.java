package com.example.testprogect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfiguration {

    private static final String API_NAME = "CK Spring Boot Application";
    private static final String API_VERSION = "1.0.0";
    private static final String API_DESCRIPTION = "CK 스프링부트 어플리케이션입니다.";
    @Bean
    public Docket api(){
        Parameter parameterBuilder = new ParameterBuilder()
                .name(HttpHeaders.AUTHORIZATION)
                .description("Access Tocken")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        List<Parameter> globalParameters = new ArrayList<>();
        globalParameters.add(parameterBuilder);


        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(globalParameters)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.testprogect"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(API_NAME)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .build();
    }
}
