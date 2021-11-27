package com.ae2dms.GameObject.Wall;

import com.ae2dms.GameObject.GameObject;
import com.ae2dms.Scene.GameScene;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import static com.ae2dms.GamePanel.UNIT_SIZE;

/**
 * The FloorUnit class creates floor units to be used for the world.
 * A floor unit is a unit shaped like a square that is treated as a floor,
 * with collision on the top, left, and right sides.
 * The floor collides with any kind of game object.
 * When an enemy is bubbled, the enemy will still be stopped by a floor unit above it.
 */
public class FloorUnit extends GameObject {
	GameScene world;
	Image image = new Image(FloorUnit.class.getResource("/image/wall.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);

	public FloorUnit(GameScene world, int colNum, int rowNum) {
		super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, world);
	}

	public void collideWith(GameObject obj) {
		double top = obj.getY();
		double bottom = top + obj.getHeight();
		if (this.overlaps(obj) && obj.yVelocity > 0) {
			if (bottom < y + height) {
				moveAboveUnit(obj);
				obj.collideWithFloor();
			}
			if (top > y){
				moveBelowUnit(obj);
				obj.collideWithCeiling();
			}
		}
	}

	@Override
	public void drawOn(GraphicsContext g) {
//		Image image = new Image(FloorUnit.class.getResource("/image/wall.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);

		g.drawImage(image, x, y, UNIT_SIZE, UNIT_SIZE);
//
//		g.setFill(Color.BLACK);
//		g.fillRect(x, y, width, height);
	}

	void moveAboveUnit(GameObject obj) {
		obj.moveTo(new Point2D(obj.getX(), y - obj.getHeight()));
	}

	void moveBelowUnit(GameObject obj) {
		obj.moveTo(new Point2D(obj.getX(), y + height));
	}

	void moveLeftOfUnit(GameObject obj) {
		obj.moveTo(new Point2D(x - obj.getWidth(), obj.getY()));
	}

	void moveRightOfUnit(GameObject obj) {
		obj.moveTo(new Point2D(x + width, obj.getY()));
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
