package com.ae2dms.Model.GameObject.Sprite.Fruit;

import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.image.Image;

public class StrawBerry extends Fruit {
    private static Image awardImage = new Image(Fruit.class.getResource("/image/fruit/strawBerry.png").toString(), 30, 30, false, false);

    public StrawBerry(int x, int y, GameScene world) {
        super(x, y, world, awardImage);
        this.bonus = 40;
    }
}
