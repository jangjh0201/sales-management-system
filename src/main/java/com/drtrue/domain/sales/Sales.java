package com.drtrue.domain.sales;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.drtrue.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 영업 정보 Entity 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Sales extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private String title;

    private Long count;

    private Long price;
}
