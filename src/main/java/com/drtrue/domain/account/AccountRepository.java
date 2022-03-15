package com.drtrue.domain.account;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 계정 관련 Repository
 * 
 * @author 이충욱
 * @since 1.0
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * emailAddress 기반 계정 탐색
     *
     * @param emailAddress
     * @return Optional<Account>
     * @since 1.0
     */

    Optional<Account> findByEmailIgnoreCase(String email);

    Page<Account> findAll(Pageable pageable);

}
