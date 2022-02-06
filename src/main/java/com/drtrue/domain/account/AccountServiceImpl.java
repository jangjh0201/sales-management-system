package com.drtrue.domain.account;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.drtrue.domain.authority.Authority;
import com.drtrue.domain.authority.AuthorityRepository;
import com.drtrue.global.exception.CustomException;
import com.drtrue.global.exception.ExceptionEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 계정 관련 Service
 * 
 * @author 이충욱
 * @since 1.0
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRrpository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

     /**
     * 계정 존재 여부 확인
     * 
     * @param userName
     * @return boolean
     * @since 1.0
     */
    @Override
    public void isExistAccount(String email)
    {
        Optional<Account> result = accountRrpository.findByEmailIgnoreCase(email);
        if(result.isPresent())
            throw new CustomException(ExceptionEnum.CONFLICT);
    }

    /**
     * 계정 생성
     * 
     * @param userName, password
     * @return Account
     * @since 1.0
     */
    @Override
    public Account createAccount(Account account) {

        // 기본 권한 부여
        Optional<Authority> result1 = authorityRepository.findByAuthorityNameIgnoreCase("USER");

        // 기본 권한 관리 여부 확인
        if (result1.isEmpty())
            throw new CustomException(ExceptionEnum.INTERNAL_SERVER_ERROR);

        // 계정 정보 중복 여부 확인
        Optional<Account> result2 = accountRrpository.findByEmailIgnoreCase(account.getEmail());
        if (result2.isPresent())
            throw new CustomException(ExceptionEnum.CONFLICT);

        // 계정 생성
        account.setAuthority(result1.get());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRrpository.save(account);
    }

    /**
     * userName 계정 탐색
     * 
     * @param userName
     * @return UserDetails
     * @since 1.0
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // 계정 존재 여부 확인
        Optional<Account> result = accountRrpository.findByEmailIgnoreCase(email);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException(email);
        } else {
            Account account = result.get();

            // 계정 권한 셋업
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(account.getAuthority().getAuthorityName()));

            return new User(account.getEmail(), account.getPassword(), grantedAuthorities);
        }
    }

      /**
     * 계정 비밀번호 변경
     * 
     * @param email, newPassword
     * @return Account
     * @since 1.0
     */
    @Override
    public Account updateAccountPasswd(String email, String newPassword){
        Optional<Account> result = accountRrpository.findByEmailIgnoreCase(email);
        if(result.isEmpty())
            throw new UsernameNotFoundException(email);

        Account account = result.get();
        account.setPassword(passwordEncoder.encode(newPassword));
        return accountRrpository.save(account);
    }

    /**
     * 계정 정보 수정
     * 
     * @param account
     * @return Account
     * @since 1.0
     */
    @Override
    public Account updateAccount(String email, Account newAccount){
        Optional<Account> result = accountRrpository.findByEmailIgnoreCase(email);
        if(result.isEmpty())
            throw new UsernameNotFoundException(email);

        Account account = result.get();
        account.setName(newAccount.getName());
        account.setPhoneNumber(newAccount.getPhoneNumber());
        
        return accountRrpository.save(account);
    }

     /**
     * 계정 정보 수정
     * 
     * @param email
     * @return Account
     * @since 1.0
     */
    @Override
    public Account retrieveAccount(String email){
        Optional<Account> result = accountRrpository.findByEmailIgnoreCase(email);
        if(result.isEmpty())
            throw new UsernameNotFoundException(email);
        return accountRrpository.save(result.get());
    }

       /**
     * 계정 정보 수정
     * 
     * @param email
     * @return Account
     * @since 1.0
     */
    @Override
    public List<Account> retrieveAccountAll(){
        List<Account> result = accountRrpository.findAll();
        return result;
    }
}
