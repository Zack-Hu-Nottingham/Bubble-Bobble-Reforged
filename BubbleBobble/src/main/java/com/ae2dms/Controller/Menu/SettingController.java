package com.ae2dms.Controller.Menu;

import com.ae2dms.Controller.MenuController;
import com.ae2dms.GameObject.Sprite.Hero;
import com.ae2dms.Util.Theme;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SettingController {

    @FXML
    private ImageView black;
    @FXML
    private ImageView green;
    @FXML
    private ImageView blue;
    @FXML
    private ImageView pink;
    @FXML
    private ImageView red;
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


    private Image untick = new Image(SettingController.class.getResource("/image/ui/menu/untick.png").toString());
    private Image tick = new Image(SettingController.class.getResource("/image/ui/menu/tick.png").toString());

    public void clickRed(MouseEvent mouseEvent) {
        clearChoice();
        menuController.setTheme(Theme.PINK);
        red.setImage(tick);
    }

    public void clickPink(MouseEvent mouseEvent) {
        clearChoice();
        menuController.setTheme(Theme.PINK);
        pink.setImage(tick);
    }

    public void clickBlue(MouseEvent mouseEvent) {
        clearChoice();
        menuController.setTheme(Theme.BLUE);
        blue.setImage(tick);
    }

    public void clickGreen(MouseEvent mouseEvent) {
        clearChoice();
        menuController.setTheme(Theme.GREEN);
        green.setImage(tick);
    }

    public void clickBlack(MouseEvent mouseEvent) {
        clearChoice();
        menuController.setTheme(Theme.BLACK);
        black.setImage(tick);
    }

    public void clearChoice() {
        red.setImage(untick);
        pink.setImage(untick);
        blue.setImage(untick);
        green.setImage(untick);
        black.setImage(untick);

        menuController.setTheme(Theme.RED);
    }
}
