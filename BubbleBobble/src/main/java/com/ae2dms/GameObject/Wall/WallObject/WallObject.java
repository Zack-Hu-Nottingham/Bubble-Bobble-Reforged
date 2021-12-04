package com.ae2dms.GameObject.Wall.WallObject;

import com.ae2dms.GameObject.GameObject;
import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.GameObject.Wall.CollideStrategy.CollideStrategy;
import com.ae2dms.Scene.GameScene;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.ae2dms.GamePanel.UNIT_SIZE;

public abstract class WallObject extends GameObject {

    protected static Image image = new Image(WallUnit.class.getResource("/image/wall/wall.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);

    protected CollideStrategy strategy;

    public WallObject(GameScene world, int colNum, int rowNum) {
        super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, world, image);
        System.out.println(scene.getTheme());
        switch (this.scene.getTheme()) {
            case RED:
                image = new Image(WallUnit.class.getResource("/image/wall/red.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);

            case BLACK:
                image = new Image(WallUnit.class.getResource("/image/wall/black.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
            case PINK:
                image = new Image(WallUnit.class.getResource("/image/wall/pink.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
            case BLUE:
                image = new Image(WallUnit.class.getResource("/image/wall/blue.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
            case GREEN:
                image = new Image(WallUnit.class.getResource("/image/wall/green.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
        }
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