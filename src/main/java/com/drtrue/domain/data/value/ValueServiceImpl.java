package com.drtrue.domain.data.value;

import com.drtrue.domain.data.product.ProductRepository;
import com.drtrue.domain.data.store.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * 입력값 관련 Service
 * 
 * @author 장준호
 * @since 1.0
 */
@Service
public class ValueServiceImpl implements ValueService {

    @Autowired
    private ValueRepository valueRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    /**
     * value data 생성
     * 
     * @param <Date>
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    @Override
    public Value createValue(int valueId, Date orderDate, BusinessType businessType, int prodId, int storeId,
            int count) {

        Value value = new Value(valueId, orderDate, businessType, prodId, storeId, count);
        return valueRepository.save(value);
    };

    /**
     * value data 조회
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    @Override
    public void readValue() {
        valueRepository.findAll();
    };

    @Override
    public void readValue(Value value) {
        Optional<Value> v = valueRepository.findById(value.getValueId());
        System.out.println(v);
    };

    /**
     * value data 갱신
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    @Override
    public Value updateValue(int valueId, Value newValue) {
        Optional<Value> result = valueRepository.findById(valueId);
        Value value = result.get();
        value = newValue;

        return valueRepository.save(value);
    };

    /**
     * value data 삭제
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    @Override
    public void deleteValue(int valueId) {
        valueRepository.deleteById(valueId);
    };
}
