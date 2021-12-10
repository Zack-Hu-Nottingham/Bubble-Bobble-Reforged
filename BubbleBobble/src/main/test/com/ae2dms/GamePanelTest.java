package com.ae2dms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static com.ae2dms.GamePanel.stage;
//import static com.ae2dms.Main.stage;

class GamePanelTest extends ApplicationTest {


    @Start
    public void start(Stage stage) throws IOException {
        GamePanel.stage = stage;
//        Main.stage = stage;
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, 1280, 720);

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
//    void startGame() {
//        GamePanel gamePanel = GamePanel.getInstance();
//        gamePanel.startGame();
//        Assertions.assertNotNull(stage.getScene().getRoot());
//
//
//    }

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
        GamePanel.bonus = new SimpleIntegerProperty(0);
        GamePanel.incrementBonus(50);
        Assertions.assertEquals(GamePanel.bonus.intValue(), 50);
    }
}