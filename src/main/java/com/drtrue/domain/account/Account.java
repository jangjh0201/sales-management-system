package com.drtrue.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.drtrue.domain.BaseEntity;
import com.drtrue.domain.authority.Authority;
import com.drtrue.privacyspringbootstarter.annotaion.Email;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 계정 정보 Entity 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Account extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String name;

    private String phoneNumber;

    @Transient
    private String newPassword;

    @Column(nullable = false)
    private Boolean locked = false;

    @ManyToOne
    private Authority authority;
}
