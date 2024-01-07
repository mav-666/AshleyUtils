package com.mav6.ashleyUtils.buildingUtils.FieldInitializers;

import java.lang.reflect.ParameterizedType;

/**
 * The type Field initializer.
 *
 * @param <T> the type parameter
 * @param <P> the type parameter
 */
public abstract class FieldInitializer<T, P> {

    private final Class<T> fieldType;

    private final Class<P> configType;

    /**
     * Instantiates a new Field initializer.
     */
    @SuppressWarnings("unchecked")
    public FieldInitializer() {
        fieldType = (Class<T>) ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        configType = ((Class<P>) ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments()[1]);

    }

    /**
     * Gets init by.
     *
     * @param config the config
     * @return the init by
     */
    public abstract T getInitBy(P config);

    /**
     * Gets field type.
     *
     * @return the field type
     */
    public Class<T> getFieldType() {
        return fieldType;
    }

    /**
     * Gets config type.
     *
     * @return the config type
     */
    public Class<P> getConfigType() {
        return configType;
    }
}
