package com.drtrue.domain.data.discount;

import java.util.List;

/**
 * 할인 관련 Service
 * 
 * @author 장준호
 * @since 1.0
 */
public interface DiscountService {

    /**
     * 할인율 생성
     * 
     * @param priceId
     * @return Product
     * @since 1.0
     */
    Discount createDcRate(Discount discount);

    /**
     * 할인율 조회
     * 
     * @param priceId
     * @return Value
     * @since 1.0
     */
    List<Discount> retrieveDcRateAll();

    /**
     * 할인율 갱신
     * 
     * @param priceId
     * @return Value
     * @since 1.0
     */
    Discount updateDcRate(Discount discount);

    /**
     * 할인율 삭제
     * 
     * @param priceId
     * @return Value
     * @since 1.0
     */
    void deleteDcRate(int discountId);
}
