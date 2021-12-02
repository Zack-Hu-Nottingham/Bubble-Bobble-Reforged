package com.ae2dms.GameObject.Award;

import com.ae2dms.Scene.GameScene;
import javafx.scene.image.Image;

public class StrawBerry extends Award{
    private static Image awardImage = new Image(Award.class.getResource("/image/award/strawBerry.png").toString(), 30, 30, false, false);

    public StrawBerry(int x, int y, GameScene world) {
        super(x, y, world, awardImage);
        this.bonus = 40;
    }
}
