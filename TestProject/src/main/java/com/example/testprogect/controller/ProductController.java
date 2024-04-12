package com.example.testprogect.controller;

import com.example.testprogect.common.Constants;
import com.example.testprogect.common.exception.CKHubException;
import com.example.testprogect.data.dto.ProductDTO;
import com.example.testprogect.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDTO getProduct(@PathVariable String productId){

        long startTime = System.currentTimeMillis();
        LOGGER.info("[getProduct] perform {} of Around Hub API.", "getProduct");

        ProductDTO productDTO = productService.getProduct(productId);
        LOGGER.info("[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getProductPrice(),
                productDTO.getProductStock(),
                (System.currentTimeMillis() - startTime));

        return productDTO;

    }

    @PostMapping(value = "/product")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){

        // 애너테이션 없이 하드코딩을 사용한 데이터 검증 방식
        // if (productDTO.getProductId().equals("") || productDTO.getProductId().isEmpty()){
        //    LOGGER.error("[createProduct] failed Response :: productId is Empty");
        //    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDTO);
        // }
        // 위 방법은 가독성도 떨어지고 데이터 검증이 필요한 메서드에는 항상 추가가 되어야 하므로
        // 올바르지 않다. 가급적이면 애너테이션으로 끝낼 수 있는 코드면 애너테이션으로만 하는게 좋다.

        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        ProductDTO response = productService.saveProduct(productId,productName,productPrice,productStock);

        LOGGER.info("[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(),
                response.getProductName(),
                response.getProductPrice(),
                response.getProductStock());
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping(value = "/product/{productId}")
    public ProductDTO deleteProduct(@PathVariable String productId){
        return null;
    }

    @PostMapping(value = "/product/exception")
    public void exceptionTest() throws CKHubException {
        throw new CKHubException(Constants.ExceptionClass.PRODUCT , HttpStatus.BAD_REQUEST, "의도한 에러가 발생하였습니다."  );

    }
}
