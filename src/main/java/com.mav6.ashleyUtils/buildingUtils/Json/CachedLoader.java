package com.mav6.ashleyUtils.buildingUtils.Json;

import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;

import java.util.Optional;

/**
 * The type Cached loader.
 */
public abstract class CachedLoader implements JsonLoader {

    private final ObjectMap<String, JsonValue> loadedJsons = new ObjectMap<>();

    @Override
    public void loadJson(String name) {
        loadedJsons.put(name, loadFromSource(name));
    }

    /**
     * Load from source json value.
     *
     * @param name the name
     * @return the json value
     */
    protected abstract JsonValue loadFromSource(String name);

    @Override
    public Optional<JsonValue> findJson(String name) {
        if(name.equals("")) return Optional.empty();

        if(!loadedJsons.containsKey(name)) loadJson(name);

        return Optional.of(loadedJsons.get(name));
    }
}
