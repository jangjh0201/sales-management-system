package com.drtrue.global.schedule;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * sample schedule 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
@Component
@Slf4j
public class SampleSchedule {

    /**
     * sample schedule 메소드 정의
     * 
     * @author 이충욱
     * @since 1.0
     */
    // @Scheduled(fixedDelay = 1000)
    public void task_1() {
        log.info("=============================");
        log.info("SampleSchedule");
        log.info("=============================");
    }

}
