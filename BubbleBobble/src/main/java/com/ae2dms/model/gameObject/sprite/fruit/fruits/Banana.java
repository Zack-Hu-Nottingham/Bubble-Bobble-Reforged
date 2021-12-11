package com.ae2dms.model.gameObject.sprite.fruit.fruits;

import com.ae2dms.model.gameObject.sprite.fruit.Fruit;
import com.ae2dms.model.scene.GameScene;
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
