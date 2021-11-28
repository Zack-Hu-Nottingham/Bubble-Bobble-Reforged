package com.ae2dms.GameObject.Wall.CollideStrategy;

import com.ae2dms.GameObject.Sprite.SpriteObject;
import com.ae2dms.GameObject.Wall.WallObject.WallObject;

public class CollideWithCeiling implements CollideStrategy {

    @Override
    public void collideWith(SpriteObject sprite, WallObject wall) {
        if (wall.overlaps(sprite)) {
            wall.moveBelowUnit(sprite);
            sprite.collideWithCeiling();
        }
    }
}
