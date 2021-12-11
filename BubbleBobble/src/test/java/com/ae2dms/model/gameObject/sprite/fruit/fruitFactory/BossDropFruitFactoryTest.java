package com.ae2dms.model.gameObject.sprite.fruit.fruitFactory;

import com.ae2dms.GamePanel;
import com.ae2dms.model.gameObject.sprite.fruit.Fruit;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.ae2dms.model.gameObject.sprite.fruit.fruits.Lucky;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

class BossDropFruitFactoryTest extends ApplicationTest {


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