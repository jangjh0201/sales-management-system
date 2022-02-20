package com.drtrue.domain.account;

import java.util.List;

import com.drtrue.global.aop.annotations.PerformanceAOPAnnotation;
import com.drtrue.global.properties.SampleProperties;
import com.drtrue.privacyspringbootstarter.aop.annotations.PrivacyAOPAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 계정 관련 Controller
 * 
 * @author 이충욱
 * @since 1.0
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

    @Autowired
    AccountUtil accountUtil;

    @Autowired
    AccountService accountService;

    @Autowired
    SampleProperties sampleProperties;

    /**
     * 계정 생성 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @PostMapping("/account/create")
    @ResponseBody
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        account = accountService.createAccount(account);
        return new ResponseEntity<>(account.getEmail(), HttpStatus.OK);
    }

    /**
     * 계정 조회 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/account/retrieve")
    @ResponseBody
    public ResponseEntity<UserDetails> retrieveAccount(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    /**
     * 계정 조회 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/account/retrieveAll")
    @ResponseBody
    public ResponseEntity<List<Account>> retrieveAccountAll() {
        return new ResponseEntity<>(accountService.retrieveAccountAll(), HttpStatus.OK);
    }

    /**
     * 계정 조회 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/test")
    public String test(Authentication authentication) {
        return "/sample/sample";
    }

    /**
     * 계정 조회 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/postValue")
    public void postValue() {
        System.out.println("/board/postValue");
    }
}
