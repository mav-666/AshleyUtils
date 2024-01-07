package com.mav6.ashleyUtils.buildingUtils.FieldInitializers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * The type Skin color initializer.
 */
public class SkinColorInitializer extends FieldInitializer<Color, String> {
    private final Skin skin;

    /**
     * Instantiates a new Skin color initializer.
     *
     * @param skin the skin
     */
    public SkinColorInitializer(Skin skin) {
        this.skin = skin;
    }
    @Override
    public Color getInitBy(String config) {
        return new Color(skin.getColor(config));
    }
}
