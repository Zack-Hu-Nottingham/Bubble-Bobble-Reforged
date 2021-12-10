package com.ae2dms.Model.GameObject.Sprite.Fruit.fruit;

import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.image.Image;

/**
 * This kind of bonus would only drop when boss is killed, and its bonus is 100.
 */
public class Lucky extends Fruit {
    private static Image lucky = new Image(Fruit.class.getResource("/image/fruit/award.png").toString(), 30, 30, false, false);

    /**
     * Instantiates a new Lucky.
     *
     * @param x         the x
     * @param y         the y
     * @param gameScene the gameScene
     */
    public Lucky(double x, double y, GameScene gameScene) {
        super(x, y, gameScene, lucky);
        this.bonus = 100;
    }
}
