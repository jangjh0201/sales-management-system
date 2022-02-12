package com.drtrue.domain.value;

/**
 * 입력값 관련 Service
 * 
 * @author 장준호
 * @since 1.0
 */
public interface ValueService {

    /**
     * valueNum 기반 탐색
     * 
     * @param valueNum
     * @return Value
     * @since 1.0
     */
    Value CreateValue(Value value);
}
