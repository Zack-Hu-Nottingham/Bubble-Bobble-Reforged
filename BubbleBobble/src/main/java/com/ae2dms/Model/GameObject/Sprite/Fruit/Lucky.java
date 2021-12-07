package com.ae2dms.Model.GameObject.Sprite.Fruit;

import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.image.Image;

public class Lucky extends Fruit {
    private static Image lucky = new Image(Fruit.class.getResource("/image/award/award.png").toString(), 30, 30, false, false);

    public Lucky(int x, int y, GameScene world) {
        super(x, y, world, lucky);
        this.bonus = 100;
    }
}
