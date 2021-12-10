package com.ae2dms.Model.GameObject.Sprite.Fruit.fruit;

import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.image.Image;

/**
 * Killing an enemy has a 60% chance of dropping apple, where apple's bonus is 35.
 */
public class Apple extends Fruit {
    private static Image awardImage = new Image(Fruit.class.getResource("/image/fruit/apple.png").toString(), 30, 30, false, false);

    /**
     * Instantiates a new Apple.
     *
     * @param x         the x
     * @param y         the y
     * @param gameScene the gameScene
     */
    public Apple(double x, double y, GameScene gameScene) {
        super(x, y, gameScene, awardImage);
        this.bonus = 35;
    }
}
