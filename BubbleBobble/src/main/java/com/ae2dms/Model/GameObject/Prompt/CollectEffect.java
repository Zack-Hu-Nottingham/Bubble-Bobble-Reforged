package com.ae2dms.Model.GameObject.Prompt;

import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.Scene.GameScene;
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
                this.image = new Image(Fruit.class.getResource("/image/fruit/collectEffect/bonus30.png").toString(), 30, 30, false, false);
                break;
            case 35:
                this.image = new Image(Fruit.class.getResource("/image/fruit/collectEffect/bonus35.png").toString(), 30, 30, false, false);
                break;
            case 40:
                this.image = new Image(Fruit.class.getResource("/image/fruit/collectEffect/bonus40.png").toString(), 30, 30, false, false);
                break;
            case 100:
                this.image = new Image(Fruit.class.getResource("/image/fruit/collectEffect/bonus100.png").toString(), 30, 30, false, false);
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