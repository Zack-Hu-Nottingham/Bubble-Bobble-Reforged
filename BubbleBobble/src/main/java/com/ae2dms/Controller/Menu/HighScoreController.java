package com.ae2dms.Controller.Menu;

import com.ae2dms.Controller.MenuController;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class HighScoreController {

    @FXML
    private Pane HighScoreBar;

    @FXML
    MenuController menuController;

    public void getController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void show() {
        menuController.hideButton();
        HighScoreBar.setVisible(true);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), HighScoreBar);
        translateTransition.setByY(-731);
        translateTransition.play();
    }

    @FXML
    public void hide() {
        menuController.showButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), HighScoreBar);
        translateTransition.setByY(731);
        translateTransition.play();
//        HighScoreBar.setVisible(false);
    }

}
