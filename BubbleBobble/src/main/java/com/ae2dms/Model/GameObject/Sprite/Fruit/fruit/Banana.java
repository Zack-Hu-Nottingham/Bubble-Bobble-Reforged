package com.ae2dms.Model.GameObject.Sprite.Fruit.fruit;

import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.image.Image;

/**
 * Killing an enemy has a 20% chance of dropping banana where banana's bonus is 30.
 */
public class Banana extends Fruit {
    private static Image fruitImage = new Image(Fruit.class.getResource("/image/fruit/banana.png").toString(), 30, 30, false, false);

    /**
     * Instantiates a new Banana.
     *
     * @param x         the x
     * @param y         the y
     * @param gameScene the gameScene
     */
    public Banana(double x, double y, GameScene gameScene) {
        super(x, y, gameScene, fruitImage);
        this.bonus = 30;
    }
}
