package com.mav6.ashleyUtils.buildingUtils.Json;

import com.badlogic.gdx.utils.JsonValue;

import java.util.Optional;

/**
 * The interface Json loader.
 */
public interface JsonLoader {

    /**
     * Load json.
     *
     * @param name the name
     */
    void loadJson(String name);

    /**
     * Find json optional.
     *
     * @param name the name
     * @return optional
     */
    Optional<JsonValue> findJson(String name);
}
