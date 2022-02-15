package com.drtrue.domain.data.value;

import java.util.Date;
import java.util.List;

import com.drtrue.domain.data.product.Product;
import com.drtrue.domain.data.store.Store;

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
    Value createValue(int valueId, Date orderDate, BusinessType businessType, Product product, Store store, int count);

    /**
     * value data 조회
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    List<Value> readValue();

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
