package com.ae2dms.model.gameObject.wall.CollideStrategy;

import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.gameObject.wall.WallObject.WallObject;

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
