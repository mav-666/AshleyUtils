package com.mav6.ashleyUtils.buildingUtils;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.mav6.ashleyUtils.componentUtils.Mappers;

public abstract class EntityTemplateFactoryBy<T> implements EntityTemplateFactory {
    private final String componentPath;
    private final Engine engine;

    protected Entity entityTemplate;

    public EntityTemplateFactoryBy(Engine engine, String componentPath) {
        this.engine = engine;
        this.componentPath = componentPath;

    }

    @Override
    public Entity createTemplateBy(String entityName) {
        return entityTemplate = engine.createEntity();
    }

    protected Component parseComponent(String componentName) {
        return Mappers.getOrCreate(createComponentClass(componentName), entityTemplate);
    }

    protected Class<? extends Component> createComponentClass(String componentName) {
        Class<? extends Component> component;
        try {
            String className =  componentPath + "." + componentName;
            component = Class.forName(className).asSubclass(Component.class);
        } catch (ClassNotFoundException e) {
            Gdx.app.log("Error", "json reading failed due to non existing component " + componentName);
            return null;
        }

        return component;
    }

    protected abstract void initComponent(Component component, T componentInit);
}
