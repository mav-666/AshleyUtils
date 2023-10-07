package com.mav6.ashleyUtils.buildingUtils;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.mav6.ashleyUtils.componentUtils.Mappers;

public abstract class EntityBuilder<T> {
    private final String componentPath;
    private final Engine engine;

    protected Entity entity;
    public EntityBuilder(Engine engine, String componentPath) {
        this.engine = engine;
        this.componentPath = componentPath;

    }

    public void build(String entityName) {
        entity = engine.createEntity();
    }

    protected Component parseComponent(String componentName) {
        return getComponent(createComponentClass(componentName));
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

    public <C extends Component> C getComponent(Class<C> componentType) {
        return Mappers.getOrCreate(componentType, entity);
    }

    public <C extends Component> boolean hasComponent(Class<C> componentType) {
        return Mappers.has(componentType, entity);
    }

    public Entity getEntity() {
        return entity;
    }
}
