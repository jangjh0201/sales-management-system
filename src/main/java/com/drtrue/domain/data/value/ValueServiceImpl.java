package com.drtrue.domain.data.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**
     * value data 생성
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    @Override
    public Value createValue(Value value) {

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
    public List<Value> retrieveValueAll() {
        List<Value> result = valueRepository.findAll();
        return result;
    };

    /**
     * value data 갱신
     * 
     * @param valueId
     * @return Value
     * @since 1.0
     */
    @Override
    public Value updateValue(Value newValue) {
        Optional<Value> result = valueRepository.findById(newValue.getValueId());
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
