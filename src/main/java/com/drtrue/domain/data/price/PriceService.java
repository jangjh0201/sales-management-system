package com.drtrue.domain.data.price;

import java.util.List;

/**
 * 가격 정보 관련 Service
 * 
 * @author 장준호
 * @since 1.0
 */
public interface PriceService {

    /**
     * price 생성
     * 
     * @param priceId
     * @return Product
     * @since 1.0
     */
    Price createPrice(Price price);

    /**
     * price 조회
     * 
     * @param priceId
     * @return Value
     * @since 1.0
     */
    List<Price> retrievePriceAll();

    /**
     * price data 갱신
     * 
     * @param priceId
     * @return Value
     * @since 1.0
     */
    Price updatePrice(Price price);

    /**
     * price data 삭제
     * 
     * @param priceId
     * @return Value
     * @since 1.0
     */
    void deletePrice(int priceId);

}
