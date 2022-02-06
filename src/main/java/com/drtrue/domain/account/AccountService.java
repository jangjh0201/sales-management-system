package com.drtrue.domain.account;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 계정 관련 Service
 * 
 * @author 이충욱
 * @since 1.0
 */
public interface AccountService extends UserDetailsService {

    /**
     * 계정 존재 여부 확인
     * 
     * @param userName
     * @return boolean
     * @since 1.0
     */
    void isExistAccount(String email);

    /**
     * 계정 생성
     * 
     * @param userName, password
     * @return Account
     * @since 1.0
     */
    Account createAccount(Account account);

    /**
     * 계정 정보 수정
     * 
     * @param account
     * @return Account
     * @since 1.0
     */
    Account updateAccount(String email, Account newAccount);


    /**
     * 계정 비밀번호 변경
     * 
     * @param email, newPassword
     * @return Account
     * @since 1.0
     */
    Account updateAccountPasswd(String email, String newPassword);

    /**
     * 계정 정보 조회
     * 
     * @param account
     * @return Account
     * @since 1.0
     */
    Account retrieveAccount(String email);

    /**
     * userName 계정 탐색
     * 
     * @param userName
     * @return UserDetails
     * @since 1.0
     */
    @Override
    UserDetails loadUserByUsername(String email);
}
