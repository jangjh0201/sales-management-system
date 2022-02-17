package com.drtrue.domain.data.discount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.drtrue.domain.data.product.Product;
import com.drtrue.domain.data.store.Store;

import groovy.transform.Generated;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 할인 정보 Entity 정의
 * 
 * @author 장준호
 * @since 1.0
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Discount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int discountId;

    // 할인 이름
    private String discountName;

    // 할인율
    private int discountRate;
    
    @ManyToOne
    @JoinColumn(name = "prodId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;
}
