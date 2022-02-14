package com.drtrue.domain.data.value;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.drtrue.domain.BaseEntity;
import com.drtrue.domain.data.product.*;
import com.drtrue.domain.data.store.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 입력값 Entity 정의
 * 
 * @author 이충욱
 * @author 장준호
 * @since 1.0
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Value extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int valueId;

    // 주문일
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    // 상품 분류
    @OneToOne
    @JoinColumn(name = "prodId")
    private int product;

    // 판매처
    @OneToOne
    @JoinColumn(name = "storeId")
    private int store;

    // 수량
    @Column
    private int count;
}

enum BusinessType {
    B2B, B2C
}

class B2B extends Value {

    // 매출액
    @Column
    private long sales;

    // 거래명세서
    private boolean tradeDetails;

    // 세금계산서
    private boolean taxInvoice;

    // 성적서
    private boolean report;

    // 도착일
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
}

class B2C extends Value {

    // 반품 및 취소
    private boolean cancel;

    // 환불
    private boolean refund;

    // 교환
    private boolean swap;
}