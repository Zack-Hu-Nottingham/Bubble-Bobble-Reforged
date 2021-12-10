package com.ae2dms.Model.GameObject.Wall.WallObject;

import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.GameObject.Wall.CollideStrategy.CollideWithCeiling;
import com.ae2dms.Model.Scene.GameScene;

/**
 * The CeilingUnit class creates ceiling units to be used for the world.
 * A ceiling unit is a unit shaped like a square that is treated as a ceiling, with collision on all four sides.
 * The ceiling collides with any kind of game object.
 * Even if a game object is on top of a ceiling, the game object will be pushed down.
 */
public class CeilingUnit extends WallObject {

    /**
     * Instantiates a new Ceiling unit.
     *
     * @param gameScene the gameScene that this ceiling is displayed on
     * @param colNum    the col num that this ceiling would be placed
     * @param rowNum    the row num that this ceiling would be placed
     */
    public CeilingUnit(GameScene gameScene, int colNum, int rowNum) {
		super(gameScene, colNum, rowNum);
		strategy = new CollideWithCeiling();
	}

	public void collideWith(SpriteObject obj) {
		strategy.collideWith(obj, this);
	}
}
