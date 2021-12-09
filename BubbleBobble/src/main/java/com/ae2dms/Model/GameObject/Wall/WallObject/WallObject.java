package com.ae2dms.Model.GameObject.Wall.WallObject;

import com.ae2dms.Model.GameObject.GameObject;
import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.GameObject.Wall.CollideStrategy.CollideStrategy;
import com.ae2dms.GamePanel;
import com.ae2dms.Model.Scene.GameScene;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.ae2dms.GamePanel.UNIT_SIZE;

public abstract class WallObject extends GameObject {

    protected Image image;

    protected CollideStrategy strategy;

    public WallObject(GameScene world, int colNum, int rowNum) {
        super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, world, null);

        WallImageFactory wallImageFactory = new WallImageFactory();
        image = wallImageFactory.getWallImage(GamePanel.theme);
    }

    @Override
    public void drawOn(GraphicsContext graphicsContext) {

        graphicsContext.drawImage(image, x, y, width, height);
    }

    public abstract void collideWith(SpriteObject obj);

    public void moveAboveUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(obj.getX(), y - obj.getHeight()));
    }

    public void moveBelowUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(obj.getX(), y + height));
    }

    public void moveLeftOfUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(x - obj.getWidth(), obj.getY()));
    }

    public void moveRightOfUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(x + width, obj.getY()));
    }
}