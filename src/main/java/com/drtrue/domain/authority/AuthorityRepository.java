package com.drtrue.domain.authority;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 계정 관련 Repository
 * 
 * @author 이충욱
 * @since 1.0
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    /**
     * authorityName 기반 권한 탐색
     * 
     * @param authorityName
     * @return Optional<Authority>
     * @since 1.0
     */
    Optional<Authority> findByAuthorityNameIgnoreCase(String authorityName);

}
