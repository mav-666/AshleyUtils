package com.mav6.ashleyUtils.buildingUtils.Json;

import com.badlogic.gdx.utils.JsonValue;
import com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Config.Config;
import com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Config.ConfigFactory;

/**
 * The type Json config factory.
 *
 * @param <T> the type parameter
 */
public abstract class JsonConfigFactory<T extends Config> implements ConfigFactory<T> {

    private final JsonLoader jsonLoader;

    /**
     * Instantiates a new Json config factory.
     *
     * @param jsonLoader the json loader
     */
    public JsonConfigFactory(JsonLoader jsonLoader) {
        this.jsonLoader = jsonLoader;
    }

    @Override
    public T get(String configName) {
        var json =  jsonLoader.findJson(configName);

        if(json.isEmpty())
            return parseJson(new JsonValue(0));

        return parseJson(json.get());
    }

    /**
     * Parse json t.
     *
     * @param jsonValue the json value
     * @return the t
     */
    protected abstract T parseJson(JsonValue jsonValue);


}
