package com.ae2dms.Model.GameObject.Sprite.Fruit;

import com.ae2dms.Model.Scene.GameScene;
import javafx.scene.image.Image;

public class Banana extends Fruit {
    private static Image fruitImage = new Image(Fruit.class.getResource("/image/award/banana.png").toString(), 30, 30, false, false);

    public Banana(int x, int y, GameScene world) {
        super(x, y, world, fruitImage);
        this.bonus = 30;
    }
}
