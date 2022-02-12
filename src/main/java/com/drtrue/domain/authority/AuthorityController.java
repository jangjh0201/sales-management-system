package com.drtrue.domain.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 권한 관련 Controller
 * 
 * @author 이충욱
 * @since 1.0
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    @Autowired
    AuthorityRepository authorityRepository;

    /**
     * 권한 생성 웹서비스
     * 
     * @param authorityName
     * @return Authority
     * @since 1.0
     */
    @PostMapping("/authority/create")
    @ResponseBody
    @Transactional
    public Authority CreateAuthority(@RequestBody Authority authority) {
        return authorityService.CreateAuthority(authority);
    }
}