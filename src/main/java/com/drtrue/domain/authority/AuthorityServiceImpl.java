package com.drtrue.domain.authority;

import java.util.Optional;

import com.drtrue.global.exception.CustomException;
import com.drtrue.global.exception.ExceptionEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 계정 관련 Service
 * 
 * @author 이충욱
 * @since 1.0
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    /**
     * authorityName 기반 권한 탐색
     * 
     * @param authorityName
     * @return Authority
     * @since 1.0
     */
    public Authority CreateAuthority(Authority authority) {

        //권한 중복 여부 확인
        Optional<Authority> result = authorityRepository.findByAuthorityNameIgnoreCase(authority.getAuthorityName());
        if(result.isPresent())
            throw new CustomException(ExceptionEnum.CONFLICT);
            
        return authorityRepository.save(authority);
    }
}
