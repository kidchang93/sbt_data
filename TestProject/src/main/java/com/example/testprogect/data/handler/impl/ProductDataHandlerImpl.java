package com.example.testprogect.data.handler.impl;

import com.example.testprogect.data.dao.ProductDAO;
import com.example.testprogect.data.entity.ProductEntity;
import com.example.testprogect.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public ProductEntity getProductEntity(String productId) {

        return productDAO.getProduct(productId);
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = new ProductEntity(productId,productName,productPrice,productStock);

        return productDAO.saveProduct(productEntity);
    }

}


