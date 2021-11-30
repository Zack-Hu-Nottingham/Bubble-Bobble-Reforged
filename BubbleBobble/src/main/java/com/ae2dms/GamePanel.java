package com.ae2dms;

import com.ae2dms.Scene.GameScene;
import com.ae2dms.Scene.Index;
import com.ae2dms.Util.SoundEffect;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * The GamePanel is where the entire game is constantly updated.
 * After every few milliseconds, GamePanel calls the methods that update its InteractableWorld,
 * then repaints the window to display the new drawn graphics.
 */

public class GamePanel {

	public static final int UNIT_SIZE = 20;
	public static final int WIDTH = 40, HEIGHT = 34;
	private Stage stage;

	private static GamePanel instance = new GamePanel();
	private GameScene gameScene = new GameScene();


	GamePanel() {}

	public static GamePanel getInstance() { return instance; }

	public void init(Stage stage) {
		this.stage = stage;
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, UNIT_SIZE * WIDTH, UNIT_SIZE * HEIGHT);

		stage.setTitle("Bubble Bobble");
		String imgUrl = GamePanel.class.getResource("/image/ui/icon.jpg").toString();
		stage.getIcons().add(new Image(imgUrl));

		stage.setResizable(false);
		stage.setScene(scene);
		stage.setWidth(1280);
		stage.setHeight(750);

		toIndex();
		stage.show();
	}

	public void gameStart() {
		gameScene.init(stage);
	}

	public void toIndex() {
		Index.load(stage);
	}
	public void gameOver() {
//		String sound = success? "/sound/success.wav" : "/sound/aiyouwodemaya.mp3";
//		SoundEffect.play(sound);
//		gameScene.clear(stage);
//		GameOver.load(stage, success);
	}

}