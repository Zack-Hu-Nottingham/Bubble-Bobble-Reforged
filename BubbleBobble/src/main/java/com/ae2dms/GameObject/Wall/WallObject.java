package com.ae2dms.GameObject.Wall;

import com.ae2dms.GameObject.GameObject;
import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.Scene.GameScene;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import static com.ae2dms.GamePanel.UNIT_SIZE;

// strategy design pattern

public abstract class WallObject extends GameObject {
    protected static Image image = new Image(WallUnit.class.getResource("/image/wall.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);

    protected CollideStrategy strategy;

    public WallObject(GameScene world, int colNum, int rowNum) {
        super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, world, image);
    }

    public abstract void collideWith(SpriteObject obj);

    void moveAboveUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(obj.getX(), y - obj.getHeight()));
    }

    void moveBelowUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(obj.getX(), y + height));
    }

    void moveLeftOfUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(x - obj.getWidth(), obj.getY()));
    }

    void moveRightOfUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(x + width, obj.getY()));
    }
}