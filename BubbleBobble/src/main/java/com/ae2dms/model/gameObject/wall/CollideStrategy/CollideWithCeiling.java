package com.ae2dms.model.gameObject.wall.CollideStrategy;

import com.ae2dms.model.gameObject.sprite.SpriteObject;
import com.ae2dms.model.gameObject.wall.WallObject.WallObject;

/**
 * The type Collide with ceiling.
 */
public class CollideWithCeiling implements CollideStrategy {

    @Override
    public void collideWith(SpriteObject sprite, WallObject wall) {
        if (wall.overlaps(sprite)) {
            wall.moveBelowUnit(sprite);
            sprite.collideWithCeiling();
        }
    }
}
