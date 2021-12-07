package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Lucky;
import com.ae2dms.Model.Scene.GameScene;

public class BossDropFruitFactory extends FruitFactory{

    @Override
    public Fruit getFruit(int x, int y, GameScene gameScene) {
        return new Lucky(x, y, gameScene);
    }
}
