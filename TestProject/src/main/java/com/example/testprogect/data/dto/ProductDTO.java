package com.example.testprogect.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDTO {
    private String productId;
    private String productName;
    private int productPrice;
    private int productStock;

//    public ProductEntity toEntity(){
//        return ProductEntity.builder()
//                .productId(productId)
//                .productName(productName)
//                .pruductPrice(productPrice)
//                .productStock(productStock)
//                .build();
//    }
}
