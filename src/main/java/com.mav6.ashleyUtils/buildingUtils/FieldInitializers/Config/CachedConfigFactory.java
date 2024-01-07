package com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Config;

import java.util.HashMap;

/**
 * The type Cached config factory.
 *
 * @param <T> the type parameter
 */
public class CachedConfigFactory<T extends Config> implements ConfigFactory<T> {

    private final HashMap<String, T> cache;

    private final ConfigFactory<T> configFactory;

    /**
     * Instantiates a new Cached config factory.
     *
     * @param configFactory the config factory
     */
    CachedConfigFactory(ConfigFactory<T> configFactory) {
        this.configFactory = configFactory;

        cache = new HashMap<>();
    }

    @Override
    public T get(String configName) {
        if(!cache.containsKey(configName))
            cache.put(configName, configFactory.get(configName));

        return cache.get(configName);
    }
}
