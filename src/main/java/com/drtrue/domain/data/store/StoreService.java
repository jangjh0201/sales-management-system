package com.drtrue.domain.data.store;

/**
 * 판매처 관련 Service
 * 
 * @author 장준호
 * @since 1.0
 */
public interface StoreService {

    /**
     * store 생성
     * 
     * @param storeId
     * @return Store
     * @since 1.0
     */
    Store CreateStore(Store store);
}