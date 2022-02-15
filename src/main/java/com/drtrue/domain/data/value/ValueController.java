package com.drtrue.domain.data.value;

import java.util.Date;
import java.util.List;

import com.drtrue.domain.data.product.Product;
import com.drtrue.domain.data.store.Store;
import com.drtrue.global.aop.annotations.PerformanceAOPAnnotation;
import com.drtrue.global.properties.SampleProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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
 * @author 장준호
 * @since 1.0
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ValueController {

    @Autowired
    ValueService valueService;

    @Autowired
    ValueRepository valueRepository;

    /**
     * 계정 생성 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @PostMapping("/value/create")
    @ResponseBody
    public ResponseEntity<List<Value>> createValue(@RequestBody int valueId, Date orderDate, BusinessType businessType,
            Product product, Store store, int count) {
        valueService.createValue(valueId, orderDate, businessType, product, store, count);
        return new ResponseEntity<>(valueService.readValue(), HttpStatus.OK);
    }

    /**
     * 계정 조회 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/value/read")
    @ResponseBody
    public ResponseEntity<List<Value>> readValue(@RequestBody List<Value> value) {
        return new ResponseEntity<>(valueService.readValue(), HttpStatus.OK);
    }

    /**
     * 계정 갱신 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/value/delete")
    @ResponseBody
    public ResponseEntity<List<Value>> deleteValue(int valueId) {
        valueService.deleteValue(valueId);
        return new ResponseEntity<>(valueService.readValue(), HttpStatus.OK);
    }

    // /**
    // * 계정 조회 웹서비스
    // *
    // * @return ResponseEntity
    // * @since 1.0
    // */
    // @PerformanceAOPAnnotation
    // @GetMapping("/test")
    // public String test(Authentication authentication) {
    // return "/sample/sample";
    // }
}
