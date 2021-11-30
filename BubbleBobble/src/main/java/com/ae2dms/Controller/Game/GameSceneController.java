package com.ae2dms.Controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class GameSceneController {

    int timeDuration;

    int score;

    @FXML
    public Label currentScore;

    @FXML
    public Label timeSpend;

    public void intialize() {

    }

    public void assignData(int timeDuration, int score) {
        this.timeDuration = timeDuration;
        this.score = score;

        currentScore.setText(String.valueOf(score));
        timeSpend.setText(String.valueOf(timeDuration));
    }

    public void mouseClickedBackToMenu(MouseEvent mouseEvent) {
    }

    public void mouseEnteredBackToMenu(MouseEvent mouseEvent) {
    }

    public void mouseExitedBackToMenu(MouseEvent mouseEvent) {
    }
}
