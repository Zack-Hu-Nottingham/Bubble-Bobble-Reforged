package com.ae2dms.model.gameObject.sprite.fruit.fruits;

import com.ae2dms.model.scene.GameScene;
import javafx.scene.image.Image;

/**
 * Killing an enemy has a 20% chance of dropping strawBerry where strawBerry's bonus is 40.
 */
public class StrawBerry extends Fruit {
    private static Image awardImage = new Image(Fruit.class.getResource("/image/fruit/strawBerry.png").toString(), 30, 30, false, false);

    /**
     * Instantiates a new Straw berry.
     *
     * @param x         the x
     * @param y         the y
     * @param gameScene the gameScene
     */
    public StrawBerry(double x, double y, GameScene gameScene) {
        super(x, y, gameScene, awardImage);
        this.bonus = 40;
    }
}
