package com.ae2dms.Model.GameObject.Wall.CollideStrategy;

import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.GameObject.Wall.WallObject.WallObject;

/**
 * The interface Collide strategy.
 */
public interface CollideStrategy {

    /**
     * Collide with.
     *
     * @param sprite the sprite
     * @param wall   the wall
     */
    public void collideWith(SpriteObject sprite, WallObject wall);

}
