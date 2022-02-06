package com.drtrue.domain.account;

import com.drtrue.global.aop.annotations.PerformanceAOPAnnotation;
import com.drtrue.global.jwt.JwtUtil;
import com.drtrue.global.properties.SampleProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    JwtUtil jwtUtil;

    @Autowired
    AccountService accountService;

    @Autowired
    SampleProperties sampleProperties;

    /**
     * 계정 존재 여부 확인 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/account/isExistAccount/{userName}")
    @ResponseBody
    public ResponseEntity<String> isExistAccount(@PathVariable String userName) {
        accountService.isExistAccount(userName);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

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

        String initPassword = account.getPassword();

        account = accountService.createAccount(account);
        accountUtil.authenticate(account.getEmail(), initPassword);
        UserDetails userDetails = accountService.loadUserByUsername(account.getEmail());
        return new ResponseEntity<>(jwtUtil.generateToken(userDetails), HttpStatus.OK);
    }

    /**
     * 계정 생성 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @PostMapping("/account/update")
    @ResponseBody
    public ResponseEntity<Account> updateAccount(@RequestBody Account account,
            @RequestHeader("Authorization") String authorizationHeader){
        // header 정보 추출
        String token = null;
        String email = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            email = jwtUtil.extractUsername(token);
        }
        account = accountService.updateAccount(email, account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    /**
     * 계정 생성 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @PostMapping("/account/updatePasswd")
    @ResponseBody
    public ResponseEntity<String> updateAccountPasswd(@RequestHeader("Authorization") String authorizationHeader,
            @RequestBody Account account){
        // header 정보 추출
        String token = null;
        String email = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            email = jwtUtil.extractUsername(token);
        }
        accountUtil.authenticate(email, account.getPassword());
        accountService.updateAccountPasswd(email, account.getNewPassword());
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    /**
     * 계정 조회 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @PostMapping("/account/retrieve")
    @ResponseBody
    public ResponseEntity<Account> retrieveAccount(@RequestHeader("Authorization") String authorizationHeader){

        // header 정보 추출
        String token = null;
        String email = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            email = jwtUtil.extractUsername(token);
        }
        return new ResponseEntity<>(accountService.retrieveAccount(email), HttpStatus.OK);
    }

    /**
     * 로그인 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PostMapping("/account/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody Account account) {
        accountUtil.authenticate(account.getEmail(), account.getPassword());
        UserDetails userDetails = accountService.loadUserByUsername(account.getEmail());
        return new ResponseEntity<>(jwtUtil.generateToken(userDetails), HttpStatus.OK);
    }

     /**
     * 로그인 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PostMapping("/account/checkPassword")
    @ResponseBody
    public ResponseEntity<String> checkPassword(@RequestHeader("Authorization") String authorizationHeader, @RequestBody Account account) {

        // header 정보 추출
        String token = null;
        String email = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            email = jwtUtil.extractUsername(token);
        }
        accountUtil.authenticate(email, account.getPassword());
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
