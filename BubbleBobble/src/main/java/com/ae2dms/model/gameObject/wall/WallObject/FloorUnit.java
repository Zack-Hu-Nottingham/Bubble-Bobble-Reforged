package com.ae2dms.model.gameObject.wall.WallObject;

import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.gameObject.wall.CollideStrategy.CollideWithFloor;
import com.ae2dms.model.scene.GameScene;

/**
 * The FloorUnit class creates floor units to be used for the world.
 * A floor unit is a unit shaped like a square that is treated as a floor,
 * with collision on the top, left, and right sides.
 * The floor collides with any kind of game object.
 * When an enemy is bubbled, the enemy will still be stopped by a floor unit above it.
 */
public class FloorUnit extends WallObject {

    /**
     * Instantiates a new Floor unit.
     *
     * @param gameScene the gameScene
     * @param colNum    the col num
     * @param rowNum    the row num
     */
    public FloorUnit(GameScene gameScene, int colNum, int rowNum) {
		super(gameScene, colNum, rowNum);
		strategy = new CollideWithFloor();
	}

	public void collideWith(SpriteObject obj) {
		strategy.collideWith(obj, this);
	}
}
