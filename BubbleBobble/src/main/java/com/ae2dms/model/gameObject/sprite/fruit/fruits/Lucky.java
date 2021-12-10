package com.ae2dms.model.gameObject.sprite.fruit.fruits;

import com.ae2dms.model.gameObject.sprite.fruit.Fruit;
import com.ae2dms.model.scene.GameScene;
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
