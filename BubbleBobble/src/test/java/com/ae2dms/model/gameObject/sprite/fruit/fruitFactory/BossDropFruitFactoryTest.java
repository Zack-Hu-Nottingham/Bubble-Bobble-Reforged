package com.ae2dms.model.gameObject.sprite.fruit.fruitFactory;

import com.ae2dms.model.gameObject.sprite.fruit.Fruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.ae2dms.model.gameObject.sprite.fruit.fruits.Lucky;
import org.testfx.framework.junit5.ApplicationTest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

class BossDropFruitFactoryTest extends ApplicationTest {


    @Test
    void getFruit() {
        BossDropFruitFactory bossDropFruitFactory = new BossDropFruitFactory();

        Fruit fruit = bossDropFruitFactory.getFruit(50, 50, null);
        assertNotNull(fruit);
        assertThat(fruit, instanceOf(Lucky.class));

        fruit = null;
        fruit = bossDropFruitFactory.getFruit(0, 0, null);
        assertNotNull(fruit);
        assertThat(fruit, instanceOf(Lucky.class));

        fruit = null;
        fruit = bossDropFruitFactory.getFruit(111, 66, null);
        assertNotNull(fruit);
        assertThat(fruit, instanceOf(Lucky.class));
    }
}