package com.ae2dms.GameObject.Award;

import com.ae2dms.Scene.GameScene;
import javafx.scene.image.Image;

public class Banana extends Award {
    private static Image fruitImage = new Image(Award.class.getResource("/image/award/banana.png").toString(), 30, 30, false, false);

    public Banana(int x, int y, GameScene world) {
        super(x, y, world, fruitImage);
        this.bonus = 30;
    }
}
