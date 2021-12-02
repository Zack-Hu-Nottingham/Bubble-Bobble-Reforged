package com.ae2dms.GameObject.Award;

import com.ae2dms.Scene.GameScene;
import javafx.scene.image.Image;

public class Lucky extends Award{
    private static Image lucky = new Image(Award.class.getResource("/image/award/award.png").toString(), 30, 30, false, false);

    public Lucky(int x, int y, GameScene world) {
        super(x, y, world, lucky);
        this.bonus = 100;
    }
}
