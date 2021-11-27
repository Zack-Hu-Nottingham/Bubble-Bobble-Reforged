package com.ae2dms.GameObject.Wall;


import com.ae2dms.GameObject.GameObject;

import com.ae2dms.Scene.GameScene;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import static com.ae2dms.GamePanel.UNIT_SIZE;

/**
 * The WallUnit class creates wall units to be used for the world.
 * A wall unit is an unit shaped like a square that is treated as a wall,
 * with collision on all four sides.
 * The wall collides with any kind of game object.
 */
public class WallUnit extends GameObject {
	GameScene world;
	Image image = new Image(WallUnit.class.getResource("/image/wall.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);
	public WallUnit(GameScene world, int colNum, int rowNum) {
		super(colNum * UNIT_SIZE, rowNum * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, world);
	}

	public void collideWith(GameObject obj) {
		double center = obj.x + obj.getWidth()/2;
		if (this.overlaps(obj)) {
			if (center > this.getHitbox().getMinX()+this.getHitbox().getWidth()/2) {
				moveRightOfUnit(obj);
				obj.collideWithWall();
			} else if (center < this.getHitbox().getMinX()+this.getHitbox().getWidth()/2){
				moveLeftOfUnit(obj);
				obj.collideWithWall();
			} else {
				moveBelowUnit(obj);
				obj.collideWithCeiling();
			}
		}
	}

	@Override
	public void drawOn(GraphicsContext g) {
//		Image image = new Image(WallUnit.class.getResource("/image/wall.png").toString(), UNIT_SIZE, UNIT_SIZE, false, false);

		g.drawImage(image, x, y, UNIT_SIZE, UNIT_SIZE);

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
