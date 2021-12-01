package com.ae2dms.Controller.Menu;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class InformationController {

    @FXML
    public Pane InformationPane;

    public void show() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), InformationPane);
        translateTransition.setByY(-668);
        translateTransition.play();
    }

    @FXML
    public void hide() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), InformationPane);
        translateTransition.setByY(668);
        translateTransition.play();
    }

}
