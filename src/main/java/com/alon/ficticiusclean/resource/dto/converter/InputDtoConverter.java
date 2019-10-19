package com.alon.ficticiusclean.resource.dto.converter;

import com.alon.ficticiusclean.resource.dto.InputDto;

/**
 * 
 * @param <I> Input to be converted
 * @param <R> Result of conversion
 */
public interface InputDtoConverter<I extends InputDto, R> {
    
    public R convert(I input);
    
}
