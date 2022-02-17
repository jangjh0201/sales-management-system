package com.drtrue.domain.data.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.drtrue.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 상품 정보 Entity 정의
 * 
 * @author 장준호
 * @since 1.0
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue
    private int prodId;

    // 대분류
    private String highLevel;

    // 중분류
    private String midLevel;

    // 소분류
    private String lowLevel;
}