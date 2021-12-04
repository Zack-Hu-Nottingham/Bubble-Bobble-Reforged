package com.ae2dms.Controller.GameOver;

import com.ae2dms.Scene.GameOver;
import com.ae2dms.Util.GameTimer;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class GameOverLoseController {
    public Label time;
    public Label score;

    public void initialize() {
        time.textProperty().bind(GameOver.timeConsumed);
        score.textProperty().set(String.valueOf(GameOver.bonusEarned));
    }
}
