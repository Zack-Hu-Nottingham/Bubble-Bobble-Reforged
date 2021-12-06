package com.ae2dms.Model_GameObject.Wall.WallObject;

import com.ae2dms.Model_GameObject.Sprite.SpriteObject;
import com.ae2dms.Model_GameObject.Wall.CollideStrategy.CollideWithFloor;
import com.ae2dms.Scene.GameScene;

/**
 * The FloorUnit class creates floor units to be used for the world.
 * A floor unit is a unit shaped like a square that is treated as a floor,
 * with collision on the top, left, and right sides.
 * The floor collides with any kind of game object.
 * When an enemy is bubbled, the enemy will still be stopped by a floor unit above it.
 */
public class FloorUnit extends WallObject {

	public FloorUnit(GameScene world, int colNum, int rowNum) {
		super(world, colNum, rowNum);
		strategy = new CollideWithFloor();
	}

	public void collideWith(SpriteObject obj) {
		strategy.collideWith(obj, this);
	}
}
