package com.drtrue.domain.price;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 가격 정보 관련 Service
 * 
 * @author 장준호
 * @since 1.0
 */
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    /**
     * 가격 정보 생성
     * 
     * @param valueId
     * @return Price
     * @since 1.0
     */
    @Override
    public Price createPrice(Price price) {
        return null;
    }

    /**
     * 가격 정보 조회
     * 
     * @param priceId
     * @return Price
     * @since 1.0
     */
    @Override
    public List<Price> retrievePriceAll() {
        return null;
    }

    /**
     * 가격 정보 갱신
     * 
     * @param priceId
     * @return Price
     * @since 1.0
     */
    @Override
    public Price updatePrice(Price price) {
        return null;
    }

    /**
     * 가격 정보 삭제
     * 
     * @param priceId
     * @since 1.0
     */
    @Override
    public void deletePrice(int priceId) {

    }

    /**
     * 최종 가격 계산
     * 
     * @param priceId
     * @return Value
     * @since 1.0
     */
    public void calcurateFinalPrice(Price price) {
        int result = price.getPrice() * price.getDiscount().getDiscountRate();
        price.setPrice(result);
    }
}