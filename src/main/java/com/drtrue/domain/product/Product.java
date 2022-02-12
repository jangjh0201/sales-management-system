package com.drtrue.domain.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.drtrue.domain.BaseEntity;

import lombok.EqualsAndHashCode;

/**
 * 상품 정보 Entity 정의
 * 
 * @author 장준호
 * @since 1.0
 */
@Entity
@Table(name = "PRODUCTS", uniqueConstraints = {
        @UniqueConstraint(name = "PRODUCT_TYPE", columnNames = { "highLevel", "midLevel", "lowLevel" }) })
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue
    private int prodNum;

    private String highLevel;

    private String midLevel;

    private String lowLevel;
}