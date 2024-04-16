package com.example.testprogect.test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll(){
        System.out.println("## BeforeAll Annotation 호출 ##\n");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("## afterAll Annotation 호출 ##\n");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("## beforeEach Annotation 호출 ##\n");
    }

    @AfterEach
    void afterEach(){
        System.out.println("## afterEach Annotation 호출 ##\n");
    }

    @Test
    void test1(){
        System.out.println("## test1 시작 ##\n");
    }
    @Test
    @DisplayName("Test Case 2!!!")
    void test2(){
        System.out.println("## test2 시작 ##\n");
    }
    @Test
    @Disabled
    // Disabled Annotation : 테스트를 실행하지 않게 설정하는 애너테이션
    void test3(){
        System.out.println("## test3 시작 ##\n");
    }
}
