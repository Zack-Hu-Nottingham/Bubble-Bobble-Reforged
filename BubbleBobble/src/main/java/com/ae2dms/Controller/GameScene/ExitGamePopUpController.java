package com.ae2dms.Controller.GameScene;

import com.ae2dms.Util.AnimationHelper;
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

    public void show() { AnimationHelper.popUp(ConfirmPane); }


    public void hide() {
        AnimationHelper.fadeOut(ConfirmPane);
    }

}
