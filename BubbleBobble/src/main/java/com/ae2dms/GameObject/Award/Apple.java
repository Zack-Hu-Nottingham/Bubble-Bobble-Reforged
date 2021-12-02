package com.ae2dms.GameObject.Award;

import com.ae2dms.Scene.GameScene;
import javafx.scene.image.Image;

public class Apple extends Award {
    private static Image awardImage = new Image(Award.class.getResource("/image/award/apple.png").toString(), 30, 30, false, false);

    public Apple(int x, int y, GameScene world) {
        super(x, y, world, awardImage);
        this.bonus = 35;
    }
}
