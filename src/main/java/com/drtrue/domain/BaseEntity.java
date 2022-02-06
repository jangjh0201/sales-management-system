package com.drtrue.domain;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * BaseEntity 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    private Date createdDate;

    @CreatedBy
    private String createBy;

    @LastModifiedDate
    private Date lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy;
}
