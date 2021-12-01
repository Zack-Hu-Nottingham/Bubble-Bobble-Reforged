package com.ae2dms.Controller.Game.PopUp;

import com.ae2dms.Controller.Game.GameSceneController;
import com.ae2dms.Util.GameStatus;
import com.ae2dms.Util.ViewHelper;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ExitGamePopUpController {

    @FXML
    private BorderPane ConfirmPane;

    @FXML
    public ImageView confirmBack;

    @FXML
    public ImageView confirmExit;

    public void clickSaveGame(MouseEvent mouseEvent) {}

    public void show() { ViewHelper.popUp(ConfirmPane); }


    public void hide() {
        ViewHelper.fadeOut(ConfirmPane);
    }

}
