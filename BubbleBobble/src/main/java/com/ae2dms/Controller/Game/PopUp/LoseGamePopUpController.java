package com.ae2dms.Controller.Game.PopUp;

import com.ae2dms.Util.ViewHelper;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class LoseGamePopUpController {

    @FXML BorderPane LoseGamePane;

    public void clickBackToMenu(MouseEvent mouseEvent) {

    }

    public void clickPlayAgain(MouseEvent mouseEvent) {
    }

    public void show() {
        ViewHelper.popUp(LoseGamePane); }


    public void hide() {
        ViewHelper.fadeOut(LoseGamePane);
    }
}
