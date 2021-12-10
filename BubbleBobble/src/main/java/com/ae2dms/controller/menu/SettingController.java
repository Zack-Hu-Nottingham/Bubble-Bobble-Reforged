package com.ae2dms.controller.menu;

import com.ae2dms.GamePanel;
import com.ae2dms.util.SoundEffect;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * The controller of Setting page.
 */
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
    /**
     * The Setting pane.
     */
    @FXML
    Pane SettingPane;

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
        SettingPane.setVisible(true);

        menuController.hideButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), SettingPane);
        translateTransition.setByY(-731);
        translateTransition.play();
    }

    /**
     * Hide.
     */
    @FXML
    public void hide() {
        SoundEffect.getInstance().play("click");

        menuController.showButton();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), SettingPane);
        translateTransition.setByY(731);
        translateTransition.play();
    }


    private Image untick = new Image(SettingController.class.getResource("/image/ui/menu/setting/untick.png").toString());
    private Image tick = new Image(SettingController.class.getResource("/image/ui/menu/setting/tick.png").toString());

    /**
     * Click red.
     *
     * @param mouseEvent the mouse event
     */
    public void clickRed(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.PINK);
        red.setImage(tick);
    }

    /**
     * Click pink.
     *
     * @param mouseEvent the mouse event
     */
    public void clickPink(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.PINK);
        pink.setImage(tick);
    }

    /**
     * Click blue.
     *
     * @param mouseEvent the mouse event
     */
    public void clickBlue(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.BLUE);
        blue.setImage(tick);
    }

    /**
     * Click green.
     *
     * @param mouseEvent the mouse event
     */
    public void clickGreen(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.GREEN);
        green.setImage(tick);
    }

    /**
     * Click black.
     *
     * @param mouseEvent the mouse event
     */
    public void clickBlack(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearColorChoice();
        menuController.setTheme(GamePanel.Theme.BLACK);
        black.setImage(tick);
    }

    /**
     * Clear color choice.
     */
    public void clearColorChoice() {
        red.setImage(untick);
        pink.setImage(untick);
        blue.setImage(untick);
        green.setImage(untick);
        black.setImage(untick);

        menuController.setTheme(GamePanel.Theme.RED);
    }

    /**
     * Click high.
     *
     * @param mouseEvent the mouse event
     */
    public void clickHigh(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearVolumeChoice();
        menuController.setVolume(SoundEffect.Volume.HIGH);
        high.setImage(tick);
    }

    /**
     * Click medium.
     *
     * @param mouseEvent the mouse event
     */
    public void clickMedium(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearVolumeChoice();
        menuController.setVolume(SoundEffect.Volume.MEDIUM);
        medium.setImage(tick);
    }

    /**
     * Click low.
     *
     * @param mouseEvent the mouse event
     */
    public void clickLow(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearVolumeChoice();
        menuController.setVolume(SoundEffect.Volume.LOW);
        low.setImage(tick);
    }

    /**
     * Click mute.
     *
     * @param mouseEvent the mouse event
     */
    public void clickMute(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearVolumeChoice();
        menuController.setVolume(SoundEffect.Volume.MUTE);
        mute.setImage(tick);
    }

    /**
     * Clear volume choice.
     */
    public void clearVolumeChoice() {
        high.setImage(untick);
        medium.setImage(untick);
        low.setImage(untick);
        mute.setImage(untick);

        menuController.setVolume(SoundEffect.Volume.MEDIUM);
    }


    /**
     * Click rubbish.
     *
     * @param mouseEvent the mouse event
     */
    public void clickRubbish(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearDifficultyChoice();
        menuController.setDifficulty(GamePanel.Difficulty.LOW);
        rubbish.setImage(tick);
    }

    /**
     * Click not bad.
     *
     * @param mouseEvent the mouse event
     */
    public void clickNotBad(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearDifficultyChoice();
        menuController.setDifficulty(GamePanel.Difficulty.MEDIUM);
        notBad.setImage(tick);
    }

    /**
     * Click monster.
     *
     * @param mouseEvent the mouse event
     */
    public void clickMonster(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        clearDifficultyChoice();
        menuController.setDifficulty(GamePanel.Difficulty.HIGH);
        monster.setImage(tick);
    }

    /**
     * Clear difficulty choice.
     */
    public void clearDifficultyChoice() {
        rubbish.setImage(untick);
        notBad.setImage(untick);
        monster.setImage(untick);

        menuController.setDifficulty(GamePanel.Difficulty.LOW);
    }

}
