package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.*;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruit.Apple;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruit.Banana;
import com.ae2dms.Model.GameObject.Sprite.Fruit.fruit.StrawBerry;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EnemyDropFruitFactoryTest extends ApplicationTest {

    @Test
    void getFruit() throws NoSuchFieldException, IllegalAccessException {
        EnemyDropFruitFactory enemyDropFruitFactory = new EnemyDropFruitFactory();

        Fruit fruit = enemyDropFruitFactory.getFruit(50, 50, null);
        assertNotNull(fruit);

        fruit = null;
        fruit = enemyDropFruitFactory.getFruit(0, 0, null);
        assertNotNull(fruit);

        fruit = null;
        fruit = enemyDropFruitFactory.getFruit(111, 66, null);
        assertNotNull(fruit);

        fruit = enemyDropFruitFactory.getFruit(50, 50, null);

        if (fruit.getClass().equals(Banana.class)) {
            assertThat(fruit, instanceOf(Banana.class));
        } else if (fruit.getClass().equals(Apple.class)) {
            assertThat(fruit, instanceOf(Apple.class));
        } else if (fruit.getClass().equals(StrawBerry.class)) {
            assertThat(fruit, instanceOf(StrawBerry.class));
        } else {
            fail();
        }

    }
}