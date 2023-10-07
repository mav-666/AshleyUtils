package com.mav6.ashleyUtils.buildingUtils;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.Gdx;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Optional;

public class ComponentInitializer {

    protected final HashMap<Class<?>, com.mav6.ashleyUtils.buildingUtils.FieldInitializers.FieldInitializer<?, ?>>  initializers = new HashMap<>();

    public ComponentInitializer() {
        this.addInitializer(new com.mav6.ashleyUtils.buildingUtils.FieldInitializers.FloatInitializer());
        this.addInitializer(new com.mav6.ashleyUtils.buildingUtils.FieldInitializers.StringInitializer());
        this.addInitializer(new com.mav6.ashleyUtils.buildingUtils.FieldInitializers.IntegerInitializer());
        this.addInitializer(new com.mav6.ashleyUtils.buildingUtils.FieldInitializers.BooleanInitializer());
        this.addInitializer(new com.mav6.ashleyUtils.buildingUtils.FieldInitializers.Vector2Initializer());
    }

    @SuppressWarnings("unchecked")
    public <P> void initField(Component component, String fieldName, P config) throws NoSuchFieldException {
        Field field = component.getClass().getField(fieldName);

        findInitializer(getTypeOf(field)).ifPresentOrElse(
                fieldInitializer ->
                    setField(field, component, ((com.mav6.ashleyUtils.buildingUtils.FieldInitializers.FieldInitializer<?,P>)fieldInitializer).getInitBy(config)),
                () -> Gdx.app.log("Error","initializer of "+ field.getType().getSimpleName() + " is not found"));
    }

    private void setField(Field field, Component component, Object value) {
        try {
            field.set(component, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Optional<com.mav6.ashleyUtils.buildingUtils.FieldInitializers.FieldInitializer<?, ?>> findInitializer(Class<?> fieldType) {
        return Optional.ofNullable(initializers.get(fieldType));
    }

    public void addInitializer(com.mav6.ashleyUtils.buildingUtils.FieldInitializers.FieldInitializer<?, ?> initializer) {
        initializers.put(initializer.getFieldType(), initializer);
    }

    public static Class<?> getTypeOf(Field field) {
        Class<?> type = field.getType();

        if(type.isPrimitive())
            type = ClassUtils.primitiveToWrapper(type);

        return type;
    }
}
