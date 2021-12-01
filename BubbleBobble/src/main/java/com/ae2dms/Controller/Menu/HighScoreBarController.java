package com.ae2dms.Controller.Menu;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class HighScoreBarController {

    @FXML
    private Pane HighScoreBar;

    public void show() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), HighScoreBar);
        translateTransition.setByY(-668);
        translateTransition.play();
    }

    @FXML
    public void hide() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), HighScoreBar);
        translateTransition.setByY(668);
        translateTransition.play();
    }

}
