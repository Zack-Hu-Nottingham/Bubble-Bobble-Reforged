package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.*;
import com.ae2dms.Model.Scene.GameScene;

/**
 * The type Fruit factory.
 */
public abstract class FruitFactory {

    /**
     * The fruit factory would return the required fruit according to
     * what factory it is.
     *
     * @param x         the x
     * @param y         the y
     * @param gameScene the game scene
     * @return the fruit
     */
    public abstract Fruit getFruit(double x, double y, GameScene gameScene);

}
