package com.ae2dms.controller.menu;

import com.ae2dms.GamePanel;
import com.ae2dms.util.SoundEffect;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * The controller of Menu.
 */
public class MenuController {

    @FXML
    private ImageView highScoreButton;
    @FXML
    private ImageView settingButton;
    @FXML
    private ImageView informationButton;
    @FXML
    private ImageView exitGameButton;
    @FXML
    private ImageView startGameButton;

    @FXML
    private InformationController informationSceneController;

    @FXML
    private HighScoreController highScoreSceneController;

    @FXML
    private SettingController settingController;

    /**
     * Initialize.
     */
    public void initialize() {
    }

    /**
     * Mouse clicked start game.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void mouseClickedStartGame(MouseEvent event) throws IOException {
        SoundEffect.getInstance().play("click");

        GamePanel.getInstance().startGame();
    }


    /**
     * Mouse clicked exit game.
     *
     * @param mouseEvent the mouse event
     */
    public void mouseClickedExitGame(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        System.exit(0);

    }

    /**
     * Mouse clicked information.
     *
     * @param mouseEvent the mouse event
     * @throws IOException the io exception
     */
    public void mouseClickedInformation(MouseEvent mouseEvent) throws IOException {
        SoundEffect.getInstance().play("click");

        informationSceneController.getController(this);
        informationSceneController.show();
    }

    /**
     * Mouse clicked high score list.
     *
     * @param mouseEvent the mouse event
     * @throws IOException the io exception
     */
    public void mouseClickedHighScoreList(MouseEvent mouseEvent) throws IOException {
        SoundEffect.getInstance().play("click");

        highScoreSceneController.getController(this);
        highScoreSceneController.show();
    }

    /**
     * Mouse clicked setting.
     *
     * @param mouseEvent the mouse event
     */
    public void mouseClickedSetting(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        settingController.getController(this);
        settingController.show();

    }

    /**
     * Hide button.
     */
    public void hideButton() {
        informationButton.setVisible(false);
        highScoreButton.setVisible(false);
        settingButton.setVisible(false);
    }

    /**
     * Show button.
     */
    public void showButton() {
        informationButton.setVisible(true);
        highScoreButton.setVisible(true);
        settingButton.setVisible(true);
    }

    /**
     * Sets theme.
     *
     * @param theme the theme
     */
    public void setTheme(GamePanel.Theme theme) {
        GamePanel.theme = theme;
    }

    /**
     * Sets volume.
     *
     * @param volume the volume
     */
    public void setVolume(SoundEffect.Volume volume) { SoundEffect.getInstance().setVolume(volume); }

    /**
     * Sets difficulty.
     *
     * @param difficulty the difficulty
     */
    public void setDifficulty(GamePanel.Difficulty difficulty) { GamePanel.difficulty = difficulty; }

}
