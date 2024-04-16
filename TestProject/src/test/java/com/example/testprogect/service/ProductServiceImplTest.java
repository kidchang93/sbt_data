package com.example.testprogect.service;

import com.example.testprogect.data.dto.ProductDTO;
import com.example.testprogect.data.entity.ProductEntity;
import com.example.testprogect.data.handler.impl.ProductDataHandlerImpl;
import com.example.testprogect.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

    @MockBean
    ProductDataHandlerImpl productDataHandler;

    @Autowired
    ProductServiceImpl productService;

    @Test
    public void getProductTest(){
        // given
        Mockito.when(productDataHandler.getProductEntity("123"))
                .thenReturn(new ProductEntity("123","pen",2000,3000));

        ProductDTO productDTO = productService.getProduct("123");

        Assertions.assertEquals(productDTO.getProductId(),"123");
        Assertions.assertEquals(productDTO.getProductName(),"pen");
        Assertions.assertEquals(productDTO.getProductPrice(),2000);
        Assertions.assertEquals(productDTO.getProductStock(),3000);

        verify(productDataHandler).getProductEntity("123");
    }

    @Test
    public void saveProductTest(){
        // given
        Mockito.when(productDataHandler.saveProductEntity("123","pen",2000,3000))
                .thenReturn(new ProductEntity("123","pen",2000,3000));

        ProductDTO productDTO = productService.saveProduct("123","pen",2000,3000);

        Assertions.assertEquals(productDTO.getProductId(),"123");
        Assertions.assertEquals(productDTO.getProductName(),"pen");
        Assertions.assertEquals(productDTO.getProductPrice(),2000);
        Assertions.assertEquals(productDTO.getProductStock(),3000);

        verify(productDataHandler).saveProductEntity("123","pen",2000,3000);
    }

}
