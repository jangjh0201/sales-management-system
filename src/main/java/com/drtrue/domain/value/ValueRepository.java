package com.drtrue.domain.value;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 입력값 관련 Repository
 * 
 * @author 장준호
 * @since 1.0
 */
public interface ValueRepository extends JpaRepository<Value, Integer> {

}