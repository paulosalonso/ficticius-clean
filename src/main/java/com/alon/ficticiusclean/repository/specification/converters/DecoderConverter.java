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
public interface DecoderConverter<T> {
    
    public T convert(String value) throws Throwable;
    
}
