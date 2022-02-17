package com.drtrue.domain.data.value;

import java.util.List;

/**
 * 입력값 관련 Service
 * 
 * @author 장준호
 * @since 1.0
 */
public interface ValueService {

    /**
     * value data 생성
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    Value createValue(Value value);

    /**
     * value data 조회
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    List<Value> retrieveValueAll();

    /**
     * value data 갱신
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    Value updateValue(Value value);

    /**
     * value data 삭제
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    void deleteValue(int valueId);
}
