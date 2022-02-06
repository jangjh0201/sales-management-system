package com.drtrue.domain.authority;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.drtrue.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 권한 정보 Entity 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Authority extends BaseEntity{

    @Id
    private String authorityName;

    private String authorityDesc;
}
