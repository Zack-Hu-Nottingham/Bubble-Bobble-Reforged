package com.ae2dms.Model_GameObject.Wall.CollideStrategy;

import com.ae2dms.Model_GameObject.Sprite.SpriteObject;
import com.ae2dms.Model_GameObject.Wall.WallObject.WallObject;

public interface CollideStrategy {

    public void collideWith(SpriteObject sprite, WallObject wall);

}
