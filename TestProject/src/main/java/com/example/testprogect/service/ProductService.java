package com.example.testprogect.service;

import com.example.testprogect.data.dto.ProductDTO;

public interface ProductService {
    ProductDTO getProduct(String productId);

    ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock);
}
