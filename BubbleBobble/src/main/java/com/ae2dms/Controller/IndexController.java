package com.ae2dms.Controller;

import com.ae2dms.GamePanel;
import com.ae2dms.Util.SoundEffect;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class IndexController {
    @FXML
    public ImageView exitGame;

    @FXML
    private ImageView startGame;

    @FXML
    public ImageView information;


    @FXML
    void mouseClickedStartGame(MouseEvent event) {
        SoundEffect.play("/sound/click.mp3");
        GamePanel.getInstance().gameStart();
        System.out.println("start");
    }

    @FXML
    void mouseEnteredStartGame(MouseEvent event) {
        startGame.setOpacity(0.8);
//        SoundEffect.play("/sound/Forest.wav");
    }

    @FXML
    void mouseExitStartGame(MouseEvent event) {
        startGame.setOpacity(1);
    }

    public void mouseClickedExitGame(MouseEvent mouseEvent) {
        SoundEffect.play("/sound/click.mp3");
        System.exit(0);
    }

    public void mouseClickedInformation(MouseEvent mouseEvent) {
        SoundEffect.play("/sound/click.mp3");
    }

    public void mouseEnteredExitGame(MouseEvent mouseEvent) {
        exitGame.setOpacity(0.8);
    }

    public void mouseEnteredInformation(MouseEvent mouseEvent) {
        information.setOpacity(0.8);
    }

    public void mouseExitExitGame(MouseEvent mouseEvent) {
        exitGame.setOpacity(1);
    }

    public void mouseExitInformation(MouseEvent mouseEvent) {
        information.setOpacity(1);
    }
}
