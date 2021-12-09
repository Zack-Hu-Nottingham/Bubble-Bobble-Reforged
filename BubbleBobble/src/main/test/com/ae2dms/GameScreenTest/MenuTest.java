package com.ae2dms.GameScreenTest;


import com.ae2dms.GamePanel;
import com.ae2dms.Main;
import com.ae2dms.Util.SoundEffect;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;
import java.lang.reflect.Field;

@ExtendWith(ApplicationExtension.class)
public class MenuTest {
//    private ImageView
//    @BeforeAll
//    private static void foo() {
//        try {
//            ApplicationTest.launch(Main.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Start
    private void start(Stage stage) throws IOException {
        Main.stage = stage;
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, 1280, 720);
//        SoundEffect soundEffect = SoundEffect.getInstance();

        stage.setScene(scene);
        Parent root = FXMLLoader.load(GamePanel.class.getResource("/View_fxml/menu/Menu.fxml"));
        stage.getScene().setRoot(root);
        stage.show();
    }


    @Test
    void informationPageTest(FxRobot robot) throws InterruptedException {

        robot.doubleClickOn("#informationButton");

        robot.clickOn("#w");
        robot.clickOn("#e");
        robot.clickOn("#up");
        robot.clickOn("#right");
        robot.clickOn("#left");
        robot.clickOn("#space");

        robot.clickOn("#back");

    }


    @Test
    void settingPageTest(FxRobot robot) throws InterruptedException, NoSuchFieldException, IllegalAccessException {

        SoundEffect soundEffect = SoundEffect.getInstance();
        Field field = SoundEffect.class.getDeclaredField("volume");
        field.setAccessible(true);

        robot.doubleClickOn("#settingButton");

        robot.clickOn("#high");
        Assertions.assertEquals(field.get(soundEffect), SoundEffect.Volume.HIGH);
        robot.clickOn("#red");

        robot.clickOn("#medium");
        Assertions.assertEquals(field.get(soundEffect), SoundEffect.Volume.MEDIUM);
        robot.clickOn("#pink");
        Assertions.assertEquals(GamePanel.theme, GamePanel.Theme.PINK);

        robot.clickOn("#low");
        Assertions.assertEquals(field.get(soundEffect), SoundEffect.Volume.LOW);
        robot.clickOn("#black");
        Assertions.assertEquals(GamePanel.theme, GamePanel.Theme.BLACK);

        robot.clickOn("#mute");
        Assertions.assertEquals(field.get(soundEffect), SoundEffect.Volume.MUTE);
        robot.clickOn("#green");
        Assertions.assertEquals(GamePanel.theme, GamePanel.Theme.GREEN);

        robot.clickOn("#medium");
        Assertions.assertEquals(field.get(soundEffect), SoundEffect.Volume.MEDIUM);
        robot.clickOn("#blue");
        Assertions.assertEquals(GamePanel.theme, GamePanel.Theme.BLUE);

        robot.clickOn("#rubbish");
        Assertions.assertEquals(GamePanel.difficulty, GamePanel.Difficulty.LOW);

        robot.clickOn("#notBad");
        Assertions.assertEquals(GamePanel.difficulty, GamePanel.Difficulty.MEDIUM);

        robot.clickOn("#monster");
        Assertions.assertEquals(GamePanel.difficulty, GamePanel.Difficulty.HIGH);

        robot.clickOn("#back");
    }

    @Test
    void highScorePageTest(FxRobot robot) throws InterruptedException {

        robot.doubleClickOn("#highScoreButton");

        robot.clickOn("#back");
    }

    @Test
    void exit(FxRobot robot) {
        robot.doubleClickOn("#exitGameButton");
    }

}
