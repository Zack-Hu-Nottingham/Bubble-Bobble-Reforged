package com.ae2dms.Model.GameObject.Wall.CollideStrategy;

import com.ae2dms.Model.GameObject.Sprite.SpriteObject;
import com.ae2dms.Model.GameObject.Wall.WallObject.WallObject;

public class CollideWithCeiling implements CollideStrategy {

    @Override
    public void collideWith(SpriteObject sprite, WallObject wall) {
        if (wall.overlaps(sprite)) {
            wall.moveBelowUnit(sprite);
            sprite.collideWithCeiling();
        }
    }
}
