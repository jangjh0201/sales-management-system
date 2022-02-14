package com.drtrue.domain.data.value;

import java.util.Date;

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
    Value createValue(int valueId, Date orderDate, BusinessType businessType, int prodId, int storeId, int count);

    /**
     * value data 조회
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    void readValue();

    void readValue(Value value);

    /**
     * value data 갱신
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    Value updateValue(int valueId, Value value);

    /**
     * value data 삭제
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    void deleteValue(int valueId);
}
