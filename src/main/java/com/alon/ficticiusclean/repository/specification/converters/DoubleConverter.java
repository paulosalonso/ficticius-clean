/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alon.ficticiusclean.repository.specification.converters;

/**
 *
 * @author paulo
 */
public class DoubleConverter implements DecoderConverter<Double> {
    
    private static DoubleConverter INSTANCE;
    
    private DoubleConverter() {}

    @Override
    public Double convert(String value) throws Throwable {
        return Double.valueOf(value);
    }
    
    public static DoubleConverter getInstance() {
        if (INSTANCE == null)
            INSTANCE = new DoubleConverter();
        
        return INSTANCE;
    }
    
}
