package com.ae2dms.GameObject.Wall;

import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.Scene.GameScene;

/**
 * The WallUnit class creates wall units to be used for the world.
 * A wall unit is an unit shaped like a square that is treated as a wall,
 * with collision on all four sides.
 * The wall collides with any kind of game object.
 */
public class WallUnit extends WallObject {

	public WallUnit(GameScene world, int colNum, int rowNum) {
		super(world, colNum, rowNum);
		strategy = new CollideWithWall();
	}

	public void collideWith(SpriteObject obj) {
		strategy.collideWith(obj, this);
	}

//	public WallUnit(GameScene world, int colNum, int rowNum) {
//		super(world, colNum, rowNum);
//
//	}
//
//	public void collideWith(SpriteObject obj) {
//		double center = obj.x + obj.getWidth()/2;
//		if (overlaps(obj)) {
//			if (center > getHitbox().getMinX()+getHitbox().getWidth()/2) {
//				moveRightOfUnit(obj);
//				obj.collideWithWall();
//			} else if (center < getHitbox().getMinX()+getHitbox().getWidth()/2){
//				moveLeftOfUnit(obj);
//				obj.collideWithWall();
//			} else {
//				moveBelowUnit(obj);
//				obj.collideWithCeiling();
//			}
//		}
//	}
}
