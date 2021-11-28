package com.ae2dms.GameObject.Wall.WallObject;

import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.GameObject.Wall.CollideStrategy.CollideWithCeiling;
import com.ae2dms.Scene.GameScene;

/**
 * The CeilingUnit class creates ceiling units to be used for the world.
 * A ceiling unit is a unit shaped like a square that is treated as a ceiling, with collision on all four sides.
 * The ceiling collides with any kind of game object.
 * Even if a game object is on top of a ceiling, the game object will be pushed down.
 */
public class CeilingUnit extends WallObject {

	public CeilingUnit(GameScene world, int colNum, int rowNum) {
		super(world, colNum, rowNum);
		strategy = new CollideWithCeiling();
	}

	public void collideWith(SpriteObject obj) {
		strategy.collideWith(obj, this);
	}

//	public CeilingUnit(GameScene world, int colNum, int rowNum) {
//		super(world, colNum, rowNum);
//
//	}
//
//	public void collideWith(SpriteObject obj) {
//		if (overlaps(obj)) {
//			moveBelowUnit(obj);
//			obj.collideWithCeiling();
//		}
//	}
}
