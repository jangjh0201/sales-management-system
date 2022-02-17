package com.drtrue.domain.data.price;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.drtrue.domain.BaseEntity;
import com.drtrue.domain.data.discout.Discount;
import com.drtrue.domain.data.product.Product;
import com.drtrue.domain.data.store.Store;

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
    @GeneratedValue
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
