package com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Config;

/**
 * The interface Config factory.
 *
 * @param <T> the type parameter
 */
public interface ConfigFactory<T extends Config> {

    /**
     * Get t.
     *
     * @param configName the config name
     * @return the t
     */
    T get(String configName);

    /**
     * Cache config factory.
     *
     * @param <T>           the type parameter
     * @param configFactory the config factory
     * @return the config factory
     */
    static <T extends Config> ConfigFactory<T> cache(ConfigFactory<T> configFactory) {
        return new CachedConfigFactory<>(configFactory);
    }
}
