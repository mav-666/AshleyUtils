package com.mav6.ashleyUtils.buildingUtils.FieldInitializers;

import java.lang.reflect.ParameterizedType;

/**
 * The type Array field initializer.
 *
 * @param <T> the type parameter
 * @param <P> the type parameter
 */
public abstract class ArrayFieldInitializer<T,P> extends FieldInitializer<T, P[]> {

    private final Class<P> elementType;

    /**
     * Instantiates a new Array field initializer.
     */
    @SuppressWarnings("unchecked")
    ArrayFieldInitializer() {
        elementType = ((Class<P>) ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<P[]> getConfigType() {
        return (Class<P[]>) super.getConfigType().arrayType();
    }

    /**
     * Gets element type.
     *
     * @return the element type
     */
    public Class<P> getElementType() {
        return elementType;
    }
}
