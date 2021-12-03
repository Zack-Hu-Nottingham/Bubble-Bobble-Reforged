package com.ae2dms.Controller.Game.PopUp;

import com.ae2dms.Util.ViewHelper;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class GameCompletePopUpController {

//    public BorderPane Game_Complete_Pop_Up;
    @FXML private BorderPane GameCompletePane;

    public void clickSaveRecord(MouseEvent mouseEvent) {

    }

    public void clickBackToMenu(MouseEvent mouseEvent) {
    }


    public void show() {
        ViewHelper.popUp(GameCompletePane); }


    public void hide() {
        ViewHelper.fadeOut(GameCompletePane);
    }
}
