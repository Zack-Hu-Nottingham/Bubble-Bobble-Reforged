package com.ae2dms.controller.gameScene;

import com.ae2dms.util.AnimationHelper;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * The controller of exitGamePopUp page.
 */
public class ExitGamePopUpController {

    @FXML
    private BorderPane ConfirmPane;

    /**
     * The Confirm back button.
     */
    @FXML
    public ImageView confirmBack;

    /**
     * The Confirm exit button.
     */
    @FXML
    public ImageView confirmExit;

    /**
     * Show the confirmPane with animation.
     */
    public void show() { AnimationHelper.popUp(ConfirmPane); }


    /**
     * Hide the confirmPane with animation.
     */
    public void hide() {
        AnimationHelper.fadeOut(ConfirmPane);
    }

}
