package com.ae2dms.Model.GameObject.Prompt;

import com.ae2dms.GamePanel;
import com.ae2dms.Main;
import com.ae2dms.Model.GameObject.Sprite.Fruit.Fruit;
import com.ae2dms.Model.Scene.GameScene;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CollectEffectTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
        GamePanel.stage = stage;
//        Main.stage = stage;

        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 24 * 20, 24 * 30);
        stage.setScene(scene);
    }

    @Test
    void update() throws IllegalAccessException, NoSuchFieldException {

        CollectEffect collectEffect = new CollectEffect(100, 100, null, null,50);

        Field field = collectEffect.getClass().getDeclaredField("timer");
        field.setAccessible(true);

        for (int i=1; i<50; i++) {
            collectEffect.update();

            assertEquals(field.getInt(collectEffect), 50-i);

        }

    }

    @Test
    void testConstructor() {
        GamePanel.level = new SimpleIntegerProperty(1);

        GameScene gameScene = new GameScene();

        CollectEffect collectEffect30 = new CollectEffect(5, 5, gameScene, null, 30);
        CollectEffect collectEffect35 = new CollectEffect(5, 5, gameScene, null, 30);
        CollectEffect collectEffect40 = new CollectEffect(5, 5, gameScene, null, 30);
        CollectEffect collectEffect100 = new CollectEffect(5, 5, gameScene, null, 30);


        assertNotNull(collectEffect30.image);
        assertNotNull(collectEffect35.image);
        assertNotNull(collectEffect40.image);
        assertNotNull(collectEffect100.image);
    }

}