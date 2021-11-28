package com.ae2dms.GameObject.Wall;

import com.ae2dms.GameObject.Sprite.SpriteObject;

public interface CollideStrategy {

    public void collideWith(SpriteObject sprite, WallObject wall);

}
