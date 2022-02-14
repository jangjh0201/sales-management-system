package com.drtrue.domain.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.drtrue.domain.BaseEntity;

import lombok.EqualsAndHashCode;

/**
 * 판매처 정보 Entity 정의
 * 
 * @author 장준호
 * @since 1.0
 */
@Entity
@EqualsAndHashCode(callSuper = false)
public class Store extends BaseEntity {

    @Id
    @GeneratedValue
    private String storeName;
}