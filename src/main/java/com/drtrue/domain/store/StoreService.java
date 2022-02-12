package com.drtrue.domain.store;

/**
 * 판매처 관련 Service
 * 
 * @author 장준호
 * @since 1.0
 */
public interface StoreService {

    /**
     * storeNum 기반 탐색
     * 
     * @param storeNum
     * @return Store
     * @since 1.0
     */
    Store CreateStore(Store store);
}