package com.ae2dms.Controller.Menu;

import com.ae2dms.Controller.MenuController;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SettingController {

    @FXML
    Pane SettingPane;

    @FXML
    MenuController menuController;

    public void getController(MenuController menuController) {
       this.menuController = menuController;
    }

    public void show() {
        menuController.hideButton();
        SettingPane.setVisible(true);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), SettingPane);
        translateTransition.setByY(-731);
        translateTransition.play();
    }

    @FXML
    public void hide() {
        menuController.showButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), SettingPane);
        translateTransition.setByY(731);
        translateTransition.play();
//        SettingPane.setVisible(false);
    }
}
