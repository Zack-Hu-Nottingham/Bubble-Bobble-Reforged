package com.ae2dms;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static com.ae2dms.Main.stage;
import static org.junit.jupiter.api.Assertions.*;

class GamePanelTest extends ApplicationTest {


    @Start
    public void start(Stage stage) throws IOException {
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
    void loadHelper() {
        GamePanel.getInstance().loadHelper("/View_fxml/menu/Menu.fxml");
        Assertions.assertNotNull(stage.getScene().getRoot());
    }


//    @Test
//    public void init() throws IOException {
//        GamePanel gamePanel = GamePanel.getInstance();
//        gamePanel.init(stage);
//        Assertions.assertNotNull(stage.getIcons());
//        Assertions.assertNotNull(stage.getScene());
//        Assertions.assertEquals(stage.getTitle(), "Bubble Bobble");
//        Assertions.assertEquals(stage.getWidth(), 1294);
//        Assertions.assertEquals(stage.getHeight(), 750);
//    }

    @Test
    void startGame() {
        GamePanel gamePanel = GamePanel.getInstance();
        gamePanel.startGame();
        Assertions.assertNotNull(stage.getScene().getRoot());


//        GamePanel.
    }

    @Test
    void toMenu() {
        GamePanel gamePanel = GamePanel.getInstance();
        gamePanel.toMenu();
        Assertions.assertNotNull(stage.getScene().getRoot());
    }

    @Test
    void gameOver() {
        GamePanel gamePanel = GamePanel.getInstance();
        gamePanel.gameOver();
        Assertions.assertNotNull(stage.getScene().getRoot());
    }

    @Test
    void viewHighScore() {
        GamePanel gamePanel = GamePanel.getInstance();
        gamePanel.toMenu();
        Assertions.assertNotNull(stage.getScene().getRoot());
    }

    @Test
    void incrementBonus() {
    }


    @Test
    void testStartGame() {
    }

    @Test
    void testToMenu() {
    }

    @Test
    void testGameOver() {
    }

    @Test
    void testViewHighScore() {
    }

    @Test
    void testIncrementBonus() {
    }

    @Test
    void testLoadHelper() {
    }
}