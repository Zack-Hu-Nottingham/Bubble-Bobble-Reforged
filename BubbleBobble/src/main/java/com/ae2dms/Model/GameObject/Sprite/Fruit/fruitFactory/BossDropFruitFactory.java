package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruit.Lucky;
import com.ae2dms.Model.Scene.GameScene;

/**
 * The type Boss drop fruit factory.
 */
public class BossDropFruitFactory extends FruitFactory{

    @Override
    public Fruit getFruit(double x, double y, GameScene gameScene) {
        return new Lucky(x, y, gameScene);
    }
}
