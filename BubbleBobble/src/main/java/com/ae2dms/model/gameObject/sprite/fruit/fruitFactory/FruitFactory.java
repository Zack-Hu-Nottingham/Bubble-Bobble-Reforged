package com.ae2dms.model.gameObject.sprite.fruit.fruitFactory;

import com.ae2dms.model.gameObject.sprite.fruit.fruits.Fruit;
import com.ae2dms.model.scene.GameScene;

/**
 * The abstract class Fruit factory, which defines the behavior of fruit factory.
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
