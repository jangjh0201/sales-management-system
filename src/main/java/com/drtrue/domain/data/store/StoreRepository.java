package com.drtrue.domain.data.store;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 판매처 관련 Repository
 * 
 * @author 장준호
 * @since 1.0
 */
public interface StoreRepository extends JpaRepository<Store, Integer> {

}