package com.mav6.ashleyUtils.buildingUtils;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.mav6.ashleyUtils.componentUtils.Mappers;

/**
 * The type Entity template factory by.
 *
 * @param <T> the type parameter
 */
public abstract class EntityTemplateFactoryBy<T> implements EntityTemplateFactory {
    private final String componentPath;
    private final Engine engine;

    /**
     * The Entity template.
     */
    protected Entity entityTemplate;

    /**
     * Instantiates a new Entity template factory by.
     *
     * @param engine        the engine
     * @param componentPath the component path
     */
    public EntityTemplateFactoryBy(Engine engine, String componentPath) {
        this.engine = engine;
        this.componentPath = componentPath;

    }

    @Override
    public Entity createTemplateBy(String entityName) {
        return entityTemplate = engine.createEntity();
    }

    /**
     * Parse component component.
     *
     * @param componentName the component name
     * @return the component
     */
    protected Component parseComponent(String componentName) {
        return Mappers.get(createComponentClass(componentName), entityTemplate);
    }

    /**
     * Create component class class.
     *
     * @param componentName the component name
     * @return the class
     */
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

    /**
     * Init component.
     *
     * @param component     the component
     * @param componentInit the component init
     */
    protected abstract void initComponent(Component component, T componentInit);
}
