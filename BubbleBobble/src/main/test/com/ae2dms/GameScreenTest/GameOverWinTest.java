//package com.ae2dms.GameScreenTest;
//
//
//import com.ae2dms.GamePanel;
//import com.ae2dms.Main;
//import com.ae2dms.Util.GameTimer;
//import com.ae2dms.Util.SoundEffect;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.testfx.api.FxAssert;
//import org.testfx.api.FxRobot;
//import org.testfx.framework.junit.ApplicationTest;
//import org.testfx.framework.junit5.ApplicationExtension;
//import org.testfx.framework.junit5.Start;
//
//import java.io.IOException;
//
//import java.io.IOException;
//import java.lang.reflect.Field;
//
//@ExtendWith(ApplicationExtension.class)
//public class GameOverWinTest extends ApplicationTest {
//
//    @Start
//    public void start(Stage stage) throws IOException, NoSuchFieldException, IllegalAccessException {
//        Main.stage = stage;
//        AnchorPane anchorPane = new AnchorPane();
//        Scene scene = new Scene(anchorPane, 1280, 720);
//
////        GamePanel.gameTimer.
//        GameTimer gameTimer = new GameTimer();
////        GamePanel.getInstance().
//        Field gamePanel = GamePanel.class.getDeclaredField("instance");
//        Field field = GameTimer.class.getDeclaredField("seconds");
//        field.setAccessible(true);
//        field.set(gameTimer, 50);
//        stage.setScene(scene);
//
//        Parent root = FXMLLoader.load(GamePanel.class.getResource("/View_fxml/GameOver/gameOverWin.fxml"));
////        Parent root = FXMLLoader.load(GamePanel.class.getResource("/View_fxml/menu/Menu.fxml"));
//        stage.getScene().setRoot(root);
//        stage.show();
//    }
//
//    @Test
//    void mouseClickedBackToMenu(FxRobot robot) throws NoSuchFieldException, IllegalAccessException {
//        robot.doubleClickOn("#startGameButton");
//
//        Field field = GamePanel.class.getDeclaredField("gameStatus");
//        field.set(GamePanel.getInstance(), GamePanel.GameStatus.WIN);
//
//
////
////        robot.clickOn("#backToMenu");
////
////        robot.clickOn("#confirmBack");
////
////        robot.clickOn("#backToMenu");
////
////        robot.clickOn("#confirmExit");
//
//    }
//
//
//}
//
