package com.mav6.ashleyUtils.componentUtils;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * The type Mappers.
 */
public class Mappers {
    private static Mappers instance;

    private Engine engine;
    private final ObjectMap<Class<? extends Component>, ComponentMapper<? extends Component>> mappers = new ObjectMap<>();

    private Mappers() {}

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Mappers getInstance() {
        if(instance == null) {
            instance = new Mappers();
        }
        return instance;
    }

    /**
     * Gets component from entity.
     *
     * @param <T>           the type parameter
     * @param componentType the component type
     * @param entity        the entity
     * @return the t
     */
    public static <T extends Component> T get(Class<T> componentType, Entity entity) {
        ComponentMapper<T> mapper = getMapper(componentType);
        T component = null;

        if(mapper.has(entity))
            component = mapper.get(entity);

        return component;
    }

    /**
     * Gets or creates component in entity.
     *
     * @param <T>           the type parameter
     * @param componentType the component type
     * @param entity        the entity
     * @return the or create
     */
    public static <T extends Component> T getOrCreate(Class<T> componentType, Entity entity) {
        Engine engine = getInstance().engine;
        T component = get(componentType, entity);

        if(component == null && engine != null) {
            component = engine.createComponent(componentType);
            entity.add(component);
        }
        return component;
    }

    /**
     * Has component in entity.
     *
     * @param <T>           the type parameter
     * @param componentType the component type
     * @param entity        the entity
     * @return the boolean
     */
    public static <T extends Component> boolean has(Class<T> componentType, Entity entity) {
        ComponentMapper<T> mapper = getMapper(componentType);

        return mapper.has(entity);
    }

    /**
     * Gets mapper.
     *
     * @param <T>           the type parameter
     * @param componentType the component type
     * @return the mapper
     */
    @SuppressWarnings("unchecked")
    public static <T extends Component> ComponentMapper<T> getMapper(Class<T> componentType) {
        ObjectMap<Class<? extends Component>, ComponentMapper<? extends Component>> mappers = Mappers.getInstance().mappers;
        if(!mappers.containsKey(componentType)) {
            mappers.put(componentType, ComponentMapper.getFor(componentType));
        }
        return (ComponentMapper<T>) mappers.get(componentType);
    }

    /**
     * Sets engine.
     *
     * @param engine the engine
     */
    public static void setEngine(Engine engine) {
        getInstance().engine = engine;
    }
}
