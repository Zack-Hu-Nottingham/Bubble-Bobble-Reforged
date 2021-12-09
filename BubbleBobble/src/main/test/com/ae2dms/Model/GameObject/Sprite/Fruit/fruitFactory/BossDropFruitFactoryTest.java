package com.ae2dms.Model.GameObject.Sprite.Fruit.fruitFactory;

//<<<<<<< Updated upstream
import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//class BossDropFruitFactoryTest {
//=======
import com.ae2dms.Main;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Lucky;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BossDropFruitFactoryTest extends ApplicationTest {

//>>>>>>> Stashed changes

    @Test
    void getFruit() {
        BossDropFruitFactory bossDropFruitFactory = new BossDropFruitFactory();

        Fruit fruit = bossDropFruitFactory.getFruit(50, 50, null);
        assertNotNull(fruit);
//<<<<<<< Updated upstream
//=======
        assertThat(fruit, instanceOf(Lucky.class));
//>>>>>>> Stashed changes

        fruit = null;
        fruit = bossDropFruitFactory.getFruit(0, 0, null);
        assertNotNull(fruit);
//<<<<<<< Updated upstream
//=======
        assertThat(fruit, instanceOf(Lucky.class));
//>>>>>>> Stashed changes

        fruit = null;
        fruit = bossDropFruitFactory.getFruit(111, 66, null);
        assertNotNull(fruit);
//<<<<<<< Updated upstream
//=======
        assertThat(fruit, instanceOf(Lucky.class));
//>>>>>>> Stashed changes
    }
}