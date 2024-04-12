package com.example.testprogect.controller;

import com.example.testprogect.data.dto.ProductDTO;
import com.example.testprogect.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){

        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        return productService.saveProduct(productId,productName,productPrice,productStock);

    }

    @DeleteMapping(value = "/product/{productId}")
    public ProductDTO deleteProduct(@PathVariable String productId){
        return null;
    }
}
