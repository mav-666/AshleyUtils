package com.mav6.ashleyUtils.buildingUtils;

import com.badlogic.ashley.core.Entity;

/**
 * The interface Entity template factory.
 */
public interface EntityTemplateFactory {
    /**
     * Create template by entity name.
     *
     * @param entityName the entity name
     * @return entity
     */
    Entity createTemplateBy(String entityName);
}
