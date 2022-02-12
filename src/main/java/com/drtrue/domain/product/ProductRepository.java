package com.drtrue.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 상품 정보 관련 Repository
 * 
 * @author 장준호
 * @since 1.0
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
