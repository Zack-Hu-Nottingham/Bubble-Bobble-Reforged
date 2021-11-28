package com.ae2dms.GameObject.Wall;

import com.ae2dms.GameObject.Sprite.SpriteObject;

import com.ae2dms.Scene.GameScene;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.ae2dms.GamePanel.UNIT_SIZE;

/**
 * The CeilingUnit class creates ceiling units to be used for the world.
 * A ceiling unit is a unit shaped like a square that is treated as a ceiling, with collision on all four sides.
 * The ceiling collides with any kind of game object.
 * Even if a game object is on top of a ceiling, the game object will be pushed down.
 */
public class CeilingUnit extends WallObject {
//	GameScene world;
//	Image image = new Image(CeilingUnit.class.getResource("/image/wall.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);

	public CeilingUnit(GameScene world, int colNum, int rowNum) {
		super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, world, image);
	}

	public void collideWith(SpriteObject obj) {
		if (this.overlaps(obj)) {
			moveBelowUnit(obj);
			obj.collideWithCeiling();
		}
	}
//
//	@Override
//	public void drawOn(GraphicsContext g) {
//		g.drawImage(image, x, y, UNIT_SIZE, UNIT_SIZE);
//	}
//
//	void moveAboveUnit(SpriteObject obj) {
//		obj.moveTo(new Point2D(obj.getX(), y - obj.getHeight()));
//	}
//
//	void moveBelowUnit(SpriteObject obj) {
//		obj.moveTo(new Point2D(obj.getX(), y + height));
//	}
//
//	void moveLeftOfUnit(SpriteObject obj) {
//		obj.moveTo(new Point2D(x - obj.getWidth(), obj.getY()));
//	}
//
//	void moveRightOfUnit(SpriteObject obj) {
//		obj.moveTo(new Point2D(x + width, obj.getY()));
//	}
//
//	@Override
//	public void collideWithFloor() {
//		// Nothing happens
//	}
//
//	@Override
//	public void collideWithCeiling() {
//		// Nothing happens
//	}
//
//	@Override
//	public void collideWithWall() {
//		// Nothing happens
//	}
}
