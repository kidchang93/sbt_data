package com.example.testprogect.controller;

import com.example.testprogect.data.dto.ProductDTO;
import com.example.testprogect.service.impl.ProductServiceImpl;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
// @AutoConfigureWebMvc // 이 어노테이션을 통해 MockMvc를 Builder 없이 주입받을 수 있음
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ProductController 에서 잡고있는 Bean 객체에 대한 Mock 형태의 객체를 생성해줌.
    @MockBean
    ProductServiceImpl productService;

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @Test
    @DisplayName("Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception {

        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메서드
        given(productService.getProduct("12315"))
                .willReturn(new ProductDTO("15871", "pen", 5000, 2000));

        String productId = "12315";

        // [mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product-api/product" + productId)).andDo(print()));]
        // get은 많은 라이브러리에서 쓰기 때문에 Import가 힘들 수 있어 위와 같이 해당 패키지까지 적어서 주는 것도 방법이며
        // 직접 Import 라인에 static 으로 달아줘도 무방하다. 나는 직접 Import를 선호.

        // andExpect : 기대하는 값이 나왔는지 체크해볼 수 있는 메서드
        mockMvc
                .perform(get("/api/v1/product-api/product/" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").exists()) // jsonPath의 depth가 깊어지면 .을 추가하여 탐색할 수 있음 (ex : $.productId.productIdName)
                .andExpect(jsonPath("$.productName").exists())
                .andExpect(jsonPath("$.productPrice").exists())
                .andExpect(jsonPath("$.productStock").exists())
                .andDo(print());

        // verify : 해당 객체의 메서드가 실행되었는지 체크해줌
        verify(productService).getProduct("12315");
    }

    // http://localhost:8080/api/v1/product-api/product
    @Test
    @DisplayName("Product 데이터 생성 테스트")
    void createProductTest() throws Exception {
        // Mock 객체에서 특정 메서드가 실행되는 경우
        // 실제 return을 줄 수 없기 때문에 아래와 같이 가정 사항을 만들어 줌

        given(productService.saveProduct("15871","pen",5000,2000))
                .willReturn(new ProductDTO("15871","pen",5000,2000));

        ProductDTO productDTO = ProductDTO.builder()
                .productId("15871")
                .productName("pen")
                .productPrice(5000)
                .productStock(2000)
                .build();

        Gson gson = new Gson();
        String content = gson.toJson(productDTO);

        // 아래 코드로 json 형태 변경 작업을 대체할 수 있음
        // String json = new ObjectMapper().writeValueAsString(productDTO);

        mockMvc
                .perform(post("/api/v1/product-api/product/")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productName").exists())
                .andExpect(jsonPath("$.productPrice").exists())
                .andExpect(jsonPath("$.productStock").exists())
                .andDo(print());

        verify(productService).saveProduct("15871","pen",5000,2000);


    }
}
