package com.example.testprogect.data.handler;

import com.example.testprogect.data.entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity getProductEntity(String productId);
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);
}
