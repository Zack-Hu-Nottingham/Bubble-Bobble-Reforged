package com.ae2dms.Controller.Menu;

import com.ae2dms.Util.SoundEffect;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * The controller of Information page.
 */
public class InformationController {

    @FXML
    private Pane InformationPane;

    /**
     * The Menu controller.
     */
    @FXML
    MenuController menuController;

    /**
     * Gets controller.
     *
     * @param menuController the menu controller
     */
    public void getController(MenuController menuController) {
        this.menuController = menuController;
    }

    /**
     * Show.
     */
    public void show() {
        InformationPane.setVisible(true);

        menuController.hideButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), InformationPane);
        translateTransition.setByY(-732);
        translateTransition.play();
    }

    /**
     * Hide.
     */
    @FXML
    public void hide() {
        SoundEffect.getInstance().play("click");

        menuController.showButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), InformationPane);
        translateTransition.setByY(732);
        translateTransition.play();
    }
}
