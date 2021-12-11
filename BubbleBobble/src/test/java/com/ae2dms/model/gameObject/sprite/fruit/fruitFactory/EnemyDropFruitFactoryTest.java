package com.ae2dms.model.gameObject.sprite.fruit.fruitFactory;

import com.ae2dms.GamePanel;
import com.ae2dms.model.gameObject.sprite.fruit.*;
import com.ae2dms.model.gameObject.sprite.fruit.fruits.Apple;
import com.ae2dms.model.gameObject.sprite.fruit.fruits.Banana;
import com.ae2dms.model.gameObject.sprite.fruit.fruits.StrawBerry;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EnemyDropFruitFactoryTest extends ApplicationTest {

    @Start
    public void start(Stage stage) throws IOException {
        GamePanel.stage = stage;
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, 1280, 720);

        stage.setScene(scene);
        Parent root = FXMLLoader.load(GamePanel.class.getResource("/view_fxml/menu/Menu.fxml"));
        stage.getScene().setRoot(root);
        stage.show();
    }

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