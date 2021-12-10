package com.ae2dms.model.gameObject.wall.WallObject;

import com.ae2dms.model.gameObject.GameObject;
import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.gameObject.wall.CollideStrategy.CollideStrategy;
import com.ae2dms.GamePanel;
import com.ae2dms.model.scene.GameScene;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.ae2dms.GamePanel.UNIT_SIZE;

/**
 * The type Wall object.
 */
public abstract class WallObject extends GameObject {

    /**
     * The constant image.
     */
//    protected Image image;
    static Image image = new Image(WallObject.class.getResource("/image/wall/red.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
    /**
     * The Strategy.
     */
    protected CollideStrategy strategy;

    /**
     * Instantiates a new Wall object.
     *
     * @param world  the world
     * @param colNum the col num
     * @param rowNum the row num
     */
    public WallObject(GameScene world, int colNum, int rowNum) {
        super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, world, image);

        WallImageFactory wallImageFactory = new WallImageFactory();
        image = wallImageFactory.getWallImage(GamePanel.theme);
    }

    @Override
    public void drawOn(GraphicsContext graphicsContext) {

        graphicsContext.drawImage(image, this.getX(), this.getY(), getWidth(), getHeight());
    }

    /**
     * Collide with.
     *
     * @param obj the obj
     */
    public abstract void collideWith(SpriteObject obj);

    /**
     * Move above unit.
     *
     * @param obj the obj
     */
    public void moveAboveUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(obj.getX(), this.getY() - obj.getHeight()));
    }

    /**
     * Move below unit.
     *
     * @param obj the obj
     */
    public void moveBelowUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(obj.getX(), this.getY() + getHeight()));
    }

    /**
     * Move left of unit.
     *
     * @param obj the obj
     */
    public void moveLeftOfUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(this.getX() - obj.getWidth(), obj.getY()));
    }

    /**
     * Move right of unit.
     *
     * @param obj the obj
     */
    public void moveRightOfUnit(SpriteObject obj) {
        obj.moveTo(new Point2D(this.getX() + getWidth(), obj.getY()));
    }
}