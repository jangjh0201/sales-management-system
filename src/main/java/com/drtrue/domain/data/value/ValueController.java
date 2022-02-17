package com.drtrue.domain.data.value;

import java.util.List;

import com.drtrue.domain.data.BaseConrtoller;
import com.drtrue.global.aop.annotations.PerformanceAOPAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 입력값 관련 Controller
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
     * 입력값 생성 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @PostMapping("/value/create")
    @ResponseBody
    public ResponseEntity<List<Value>> createValue(@RequestBody Value value) {
        valueService.createValue(value);
        return new ResponseEntity<>(valueService.retrieveValueAll(), HttpStatus.OK);
    }

    /**
     * 입력값 조회 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/value/retrieve")
    @ResponseBody
    public ResponseEntity<List<Value>> retrieveValue() {
        return new ResponseEntity<>(valueService.retrieveValueAll(), HttpStatus.OK);
    }

    /**
     * 입력값 갱신 웹서비스
     * 
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/value/delete")
    @ResponseBody
    public ResponseEntity<List<Value>> deleteValue(int valueId) {
        valueService.deleteValue(valueId);
        return new ResponseEntity<>(valueService.retrieveValueAll(), HttpStatus.OK);
    }

    /**
     * 입력값 조회 웹서비스
     *
     * @return ResponseEntity
     * @since 1.0
     */
    @PerformanceAOPAnnotation
    @GetMapping("/t")
    public String test() {
        return "/sample/sample";
    }
}
