package com.ae2dms.Controller.Menu;

import com.ae2dms.GamePanel;
import com.ae2dms.Util.SoundEffect;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

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

    public void initialize() {
    }

    @FXML
    void mouseClickedStartGame(MouseEvent event) throws IOException {
        SoundEffect.getInstance().play("click");

        GamePanel.getInstance().startGame();
        System.out.println("start");
    }


    public void mouseClickedExitGame(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        System.exit(0);
    }

    public void mouseClickedInformation(MouseEvent mouseEvent) throws IOException {
        SoundEffect.getInstance().play("click");

        informationSceneController.getController(this);
        informationSceneController.show();
    }

    public void mouseClickedHighScoreList(MouseEvent mouseEvent) throws IOException {
        SoundEffect.getInstance().play("click");

        highScoreSceneController.getController(this);
        highScoreSceneController.show();
    }

    public void mouseClickedSetting(MouseEvent mouseEvent) {
        SoundEffect.getInstance().play("click");

        settingController.getController(this);
        settingController.show();

    }

    public void hideButton() {
        informationButton.setVisible(false);
        highScoreButton.setVisible(false);
        settingButton.setVisible(false);
    }

    public void showButton() {
        informationButton.setVisible(true);
        highScoreButton.setVisible(true);
        settingButton.setVisible(true);
    }

    public void setTheme(GamePanel.Theme theme) {
        GamePanel.theme = theme;
    }

    public void setVolume(SoundEffect.Volume volume) { SoundEffect.getInstance().setVolume(volume); }

    public void setDifficulty(GamePanel.Difficulty difficulty) { GamePanel.difficulty = difficulty; }

}