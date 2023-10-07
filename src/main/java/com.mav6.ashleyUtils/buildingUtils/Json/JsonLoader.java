package com.mav6.ashleyUtils.buildingUtils.Json;

import com.badlogic.gdx.utils.JsonValue;

import java.util.Optional;

public interface JsonLoader {

    void loadJson(String name);

    Optional<JsonValue> findJson(String name);
}
