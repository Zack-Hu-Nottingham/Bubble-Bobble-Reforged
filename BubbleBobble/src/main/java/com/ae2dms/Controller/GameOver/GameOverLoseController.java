package com.ae2dms.Controller.GameOver;

import com.ae2dms.Scene.GameOver;
import com.ae2dms.Util.GameTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameOverLoseController {

    @FXML
    public Label time;

    @FXML
    public Label score;

    @FXML
    public ImageView backToMenu;

    @FXML
    public ImageView playAgain;

    public void initialize() {
        time.textProperty().bind(GameOver.timeConsumed);
        score.textProperty().set(String.valueOf(GameOver.bonusEarned));
    }

    public void clickBackToMenu(MouseEvent mouseEvent) {
    }

    public void clickBackPlayAgain(MouseEvent mouseEvent) {
    }
}
