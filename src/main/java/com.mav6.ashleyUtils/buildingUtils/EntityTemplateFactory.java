package com.mav6.ashleyUtils.buildingUtils;

import com.badlogic.ashley.core.Entity;

public interface EntityTemplateFactory {
    Entity createTemplateBy(String entityName);
}
