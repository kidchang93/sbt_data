package com.example.testprogect.data.dao.impl;

import com.example.testprogect.data.dao.ProductDAO;
import com.example.testprogect.data.entity.ProductEntity;
import com.example.testprogect.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        // jpa 를 상속받은 productRepo 는 따로 명시하지 않아도 기본적으로 save 같은 메서드는 사용 가능.
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getReferenceById(productId);
        return productEntity;
    }
}
