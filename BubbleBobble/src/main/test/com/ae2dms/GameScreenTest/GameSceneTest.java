package com.ae2dms.GameScreenTest;

import com.ae2dms.GamePanel;
import com.ae2dms.Main;
import com.ae2dms.Util.GameRecorder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import java.io.IOException;

@ExtendWith(ApplicationExtension.class)
public class GameSceneTest extends ApplicationTest {

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
    void mouseClickedBackToMenu(FxRobot robot) {
        robot.doubleClickOn("#startGameButton");

        FxAssert.verifyThat("#levelHint", LabeledMatchers.hasText("1"));

        FxAssert.verifyThat("#chargeState", LabeledMatchers.hasText("Charging"));

        FxAssert.verifyThat("#currentScore", LabeledMatchers.hasText("0"));

        GameRecorder gameRecorder = new GameRecorder();
        int highScore = gameRecorder.getHighestScore();

        FxAssert.verifyThat("#bestRecord", LabeledMatchers.hasText(String.valueOf(highScore)));

        robot.clickOn("#backToMenu");

        robot.clickOn("#confirmBack");

        robot.clickOn("#backToMenu");

        robot.clickOn("#confirmExit");

    }


}
