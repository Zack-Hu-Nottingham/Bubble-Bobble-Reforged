package com.ae2dms.Controller.Menu;

import com.ae2dms.Controller.MenuController;
import com.ae2dms.GamePanel;
import com.ae2dms.Util.SoundEffect;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SettingController {

    @FXML
    private ImageView high;
    @FXML
    private ImageView medium;
    @FXML
    private ImageView low;
    @FXML
    private ImageView mute;
    @FXML
    private ImageView rubbish;
    @FXML
    private ImageView notBad;
    @FXML
    private ImageView monster;
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


    private Image untick = new Image(SettingController.class.getResource("/image/ui/menu/setting/untick.png").toString());
    private Image tick = new Image(SettingController.class.getResource("/image/ui/menu/setting/tick.png").toString());

    public void clickRed(MouseEvent mouseEvent) {
        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.PINK);
        red.setImage(tick);
    }

    public void clickPink(MouseEvent mouseEvent) {
        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.PINK);
        pink.setImage(tick);
    }

    public void clickBlue(MouseEvent mouseEvent) {
        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.BLUE);
        blue.setImage(tick);
    }

    public void clickGreen(MouseEvent mouseEvent) {
        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.GREEN);
        green.setImage(tick);
    }

    public void clickBlack(MouseEvent mouseEvent) {
        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.BLACK);
        black.setImage(tick);
    }

    public void clearColorChoice() {
        red.setImage(untick);
        pink.setImage(untick);
        blue.setImage(untick);
        green.setImage(untick);
        black.setImage(untick);

        menuController.setTheme(GamePanel.Theme.RED);
    }

//    private SoundEffect.Volume volume = SoundEffect.Volume.MEDIUM;
//    private Difficulty difficulty = Difficulty.LOW;

    public void clickHigh(MouseEvent mouseEvent) {
        clearVolumeChoice();
        menuController.setVolume(SoundEffect.Volume.HIGH);
//        System.out.println(GamePanel.volume);

        high.setImage(tick);
    }

    public void clickMedium(MouseEvent mouseEvent) {
        System.out.println("medium");
        clearVolumeChoice();
        menuController.setVolume(SoundEffect.Volume.MEDIUM);
        medium.setImage(tick);
    }

    public void clickLow(MouseEvent mouseEvent) {
        System.out.println("low");
        clearVolumeChoice();
        menuController.setVolume(SoundEffect.Volume.LOW);
        low.setImage(tick);
    }

    public void clickMute(MouseEvent mouseEvent) {
        System.out.println("mute");
        clearVolumeChoice();
        menuController.setVolume(SoundEffect.Volume.MUTE);
        mute.setImage(tick);
    }

    public void clearVolumeChoice() {
        high.setImage(untick);
        medium.setImage(untick);
        low.setImage(untick);
        mute.setImage(untick);

        menuController.setVolume(SoundEffect.Volume.MEDIUM);
    }



    public void clickRubbish(MouseEvent mouseEvent) {
        clearDifficultyChoice();
        menuController.setDifficulty(GamePanel.Difficulty.LOW);
        rubbish.setImage(tick);
    }

    public void clickNotBad(MouseEvent mouseEvent) {
        clearDifficultyChoice();
        menuController.setDifficulty(GamePanel.Difficulty.MEDIUM);
        notBad.setImage(tick);
    }

    public void clickMonster(MouseEvent mouseEvent) {
        clearDifficultyChoice();
        menuController.setDifficulty(GamePanel.Difficulty.HIGH);
        monster.setImage(tick);
    }

    public void clearDifficultyChoice() {
        rubbish.setImage(untick);
        notBad.setImage(untick);
        monster.setImage(untick);

        menuController.setDifficulty(GamePanel.Difficulty.LOW);
    }

}
