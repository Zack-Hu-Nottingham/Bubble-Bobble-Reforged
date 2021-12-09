package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossDropFruitFactoryTest {

    @Test
    void getFruit() {
        BossDropFruitFactory bossDropFruitFactory = new BossDropFruitFactory();

        Fruit fruit = bossDropFruitFactory.getFruit(50, 50, null);
        assertNotNull(fruit);

        fruit = null;
        fruit = bossDropFruitFactory.getFruit(0, 0, null);
        assertNotNull(fruit);

        fruit = null;
        fruit = bossDropFruitFactory.getFruit(111, 66, null);
        assertNotNull(fruit);
    }
}