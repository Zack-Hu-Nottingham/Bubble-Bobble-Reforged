package com.ae2dms.Controller.Menu;

import com.ae2dms.Controller.MenuController;
import com.ae2dms.Util.SoundEffect;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class InformationController {

    @FXML
    public Pane InformationPane;

    @FXML
    MenuController menuController;

    public void getController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void show() {
        menuController.hideButton();
        InformationPane.setVisible(true);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), InformationPane);
        translateTransition.setByY(-732);
        translateTransition.play();
    }

    @FXML
    public void hide() {
        SoundEffect.getInstance().play("click");

        menuController.showButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), InformationPane);
        translateTransition.setByY(732);
        translateTransition.play();
    }
}
