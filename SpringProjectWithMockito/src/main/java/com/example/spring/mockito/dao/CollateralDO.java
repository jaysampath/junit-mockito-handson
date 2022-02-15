package com.example.spring.mockito.dao;

import com.example.spring.mockito.models.*;

import java.util.List;



/**
 * Data Object for the Client entity.
 */
public interface CollateralDO {

    /**
     * Retrieve collaterals for the client.
     * 
     * @param clientId client id.
     */
    List<Collateral> getAllCollaterals(long clientId);
}
