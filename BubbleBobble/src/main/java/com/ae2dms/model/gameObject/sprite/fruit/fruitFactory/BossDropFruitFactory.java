package com.ae2dms.model.gameObject.sprite.fruit.fruitFactory;

import com.ae2dms.model.gameObject.sprite.fruit.Fruit;
import com.ae2dms.model.gameObject.sprite.fruit.fruits.Lucky;
import com.ae2dms.model.scene.GameScene;

/**
 * The type Boss drop fruit factory.
 */
public class BossDropFruitFactory extends FruitFactory{

    @Override
    public Fruit getFruit(double x, double y, GameScene gameScene) {
        return new Lucky(x, y, gameScene);
    }
}
