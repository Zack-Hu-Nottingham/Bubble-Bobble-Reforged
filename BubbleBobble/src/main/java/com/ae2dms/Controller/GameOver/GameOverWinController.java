package com.ae2dms.Controller.GameOver;

import com.ae2dms.Scene.GameOver;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class GameOverWinController {
    public Label time;
    public Label score;
    GameOver gameOver;
    public void clickSaveRecord(MouseEvent mouseEvent) {
    }


    public void initialize() {
        time.textProperty().bind(GameOver.timeConsumed);
        score.textProperty().set(String.valueOf(GameOver.bonusEarned));
    }

}
