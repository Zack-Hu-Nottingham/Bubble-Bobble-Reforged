package com.ae2dms.GameObject.Wall;

import com.ae2dms.GameObject.Sprite.SpriteObject;

public class CollideWithCeiling implements CollideStrategy{

    @Override
    public void collideWith(SpriteObject sprite, WallObject wall) {
        if (wall.overlaps(sprite)) {
            wall.moveBelowUnit(sprite);
            sprite.collideWithCeiling();
        }
    }
}
