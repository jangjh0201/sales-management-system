package com.drtrue.domain.data.value;

import java.util.Optional;

import com.drtrue.domain.data.product.Product;
import com.drtrue.domain.data.store.Store;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 입력값 관련 Repository
 * 
 * @author 장준호
 * @since 1.0
 */
public interface ValueRepository extends JpaRepository<Value, Integer> {

}