package com.ae2dms.GameObject.Sprite;

import com.ae2dms.GameObject.Award.Award;
import com.ae2dms.Scene.GameScene;
import javafx.scene.image.Image;

public class CollectEffect extends SpriteObject {

    private int activeFrames;
    private int timer;

    public CollectEffect(int x, int y, GameScene scene, Image image, int bonus) {
        super(x-30, y-25, 60, 50, scene, image);
        activeFrames = 50;
        timer = activeFrames;
        switch (bonus) {
            case 30:
                this.image = new Image(Award.class.getResource("/image/award/bonus30.png").toString(), 30, 30, false, false);
                break;
            case 35:
                this.image = new Image(Award.class.getResource("/image/award/bonus35.png").toString(), 30, 30, false, false);
                break;
            case 40:
                this.image = new Image(Award.class.getResource("/image/award/bonus40.png").toString(), 30, 30, false, false);
                break;
            case 100:
                this.image = new Image(Award.class.getResource("/image/award/bonus100.png").toString(), 30, 30, false, false);
        }
    }

    @Override
    public void update() {
        timer -= 1;
        if (timer == 0) {
            markToRemove();
        }
    }

    @Override
    public void collideWithFloor() {

    }

    @Override
    public void collideWithCeiling() {

    }

    @Override
    public void collideWithWall() {

    }

}
