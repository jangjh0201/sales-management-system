package com.drtrue.domain.authority;

/**
 * 계정 관련 Service
 * 
 * @author 이충욱
 * @since 1.0
 */
public interface AuthorityService {

    /**
     * authorityName 기반 권한 탐색
     * 
     * @param authorityName
     * @return Authority
     * @since 1.0
     */
    Authority CreateAuthority(Authority authority);
}
