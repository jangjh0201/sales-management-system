package com.drtrue.global.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * sample runner 정의
 * 
 * @author 이충욱
 * @since 1.0
 */
public class SampleRunner implements ApplicationRunner {

    /**
     * sample runner 메소드 정의
     * 
     * @param ApplicationArguments
     * @author 이충욱
     * @since 1.0
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========================================");
        System.out.println("SampleRunner Test");
        System.out.println("========================================");
    }

}
