package com.alon.ficticiusclean.resource.dto.converter;

/**
 * 
 * @param <D> Data to be converted
 * @param <O> Ouput resulting from conversion
 */
public interface OutputDtoConverter<D, O> {
    
    public O convert(D data);
    
}
