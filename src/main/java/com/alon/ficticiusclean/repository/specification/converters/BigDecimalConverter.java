/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alon.ficticiusclean.repository.specification.converters;

import java.math.BigDecimal;

/**
 *
 * @author paulo
 */
public class BigDecimalConverter implements DecoderConverter<BigDecimal> {
    
    private static BigDecimalConverter INSTANCE;
    
    private BigDecimalConverter() {}

    @Override
    public BigDecimal convert(String value) throws Throwable {
        return new BigDecimal(value);
    }
    
    public static BigDecimalConverter getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BigDecimalConverter();
        
        return INSTANCE;
    }
    
}
