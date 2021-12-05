package com.ae2dms.Controller;

import com.ae2dms.Controller.Menu.HighScoreController;
import com.ae2dms.Controller.Menu.InformationController;
import com.ae2dms.Controller.Menu.SettingController;
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

    public static GamePanel.Theme theme = GamePanel.Theme.RED;

    public static SoundEffect.Volume volume = SoundEffect.Volume.MEDIUM;
    private GamePanel.Difficulty difficulty = GamePanel.Difficulty.LOW;


    public void initialize() {

    }


    @FXML
    void mouseClickedStartGame(MouseEvent event) throws IOException {
//        SoundEffect.play("/sound/click.mp3");
        GamePanel.getInstance().gameStart();
        System.out.println("start");
    }


    public void mouseClickedExitGame(MouseEvent mouseEvent) {
//        SoundEffect.play("/sound/click.mp3");
        System.exit(0);
    }

    public void mouseClickedInformation(MouseEvent mouseEvent) throws IOException {
        informationSceneController.getController(this);
        informationSceneController.show();
    }

    public void mouseClickedHighScoreList(MouseEvent mouseEvent) throws IOException {
        highScoreSceneController.getController(this);
        highScoreSceneController.show();
    }

    public void mouseClickedSetting(MouseEvent mouseEvent) {
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
