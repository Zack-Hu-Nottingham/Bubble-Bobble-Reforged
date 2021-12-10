package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

import com.ae2dms.Model.GameObject.Sprite.Fruit.*;
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


        Field field = EnemyDropFruitFactory.class.getDeclaredField("typeOfFruit");
        field.set(enemyDropFruitFactory, 0.2);

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