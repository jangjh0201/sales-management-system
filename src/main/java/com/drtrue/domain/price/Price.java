package com.drtrue.domain.price;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.drtrue.domain.BaseEntity;
import com.drtrue.domain.discount.Discount;
import com.drtrue.domain.product.Product;
import com.drtrue.domain.store.Store;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 가격 정보 Entity 정의
 * 
 * @author 장준호
 * @since 1.0
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Price extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int priceId;

    // 판매가
    private int price;

    @ManyToOne
    @JoinColumn(name = "discountId")
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "prodId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;
}
