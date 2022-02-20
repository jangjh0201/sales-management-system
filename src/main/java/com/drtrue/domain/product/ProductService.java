package com.drtrue.domain.product;

/**
 * 상품 정보 관련 Service
 * 
 * @author 장준호
 * @since 1.0
 */
public interface ProductService {

    /**
     * product 생성
     * 
     * @param prodId
     * @return Product
     * @since 1.0
     */
    Product CreateProduct(Product product);
}
