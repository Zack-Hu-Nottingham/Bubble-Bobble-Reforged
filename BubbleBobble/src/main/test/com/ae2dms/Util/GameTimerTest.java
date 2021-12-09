package com.ae2dms.Util;

import com.ae2dms.Main;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

class GameTimerTest extends ApplicationTest {


    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
        Main.stage = stage;

        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 24 * 20, 24 * 30);
        stage.setScene(scene);
    }

    @Test
    void start() {
        GameTimer gameTimer = new GameTimer();
        gameTimer.start();
        Assertions.assertNotEquals(gameTimer.getTime(), 0);
    }

    @Test
    void testStop() {
        GameTimer gameTimer = new GameTimer();
        gameTimer.start();

        try {
            wait(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int time1 = gameTimer.getTime();
        gameTimer.stop();

        try {
            wait(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int time2 = gameTimer.getTime();

        Assertions.assertEquals(time1, time2);
    }


    @Test
    void parseToTimeFormat() {
        String time = GameTimer.parseToTimeFormat(200);
        assertEquals("03:20", time);

        time = GameTimer.parseToTimeFormat(0);
        assertEquals("00:00", time);

        time = GameTimer.parseToTimeFormat(600);
        assertEquals("10:00", time);
    }
}