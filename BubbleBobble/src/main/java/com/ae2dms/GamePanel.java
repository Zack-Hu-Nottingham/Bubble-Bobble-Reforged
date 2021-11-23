package com.ae2dms;

import com.ae2dms.GameObject.Objects.Hero;
import com.ae2dms.GameScene.InteractableWorld;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * The GamePanel is where the entire game is constantly updated.
 * After every few milliseconds, GamePanel calls the methods that update its InteractableWorld,
 * then repaints the window to display the new drawn graphics.
 */
//public class GamePanel extends GraphicContext {
//	InteractableWorld world;
//
//	public GamePanel(int width, int height) {
//		world = new InteractableWorld(width, height);
//
//		this.add(world);
//
//		world.startGame();
//
//		Timer repaintTimer = new Timer(1000 / 60, new ActionListener() {
//			//handles updating the game, going to next frame
//			public void actionPerformed(ActionEvent arg0) {
//				world.updatePosition();
//				repaint();
//			}
//		});
//		repaintTimer.start();
//	}
//}



public class GamePanel {

	public static final int UNIT_SIZE = 20;
	public static final int WIDTH = 40, HEIGHT = 34;
	private Stage stage;

//	private Canvas canvas = new Canvas((double)UNIT_SIZE * WIDTH, (double)UNIT_SIZE * HEIGHT);
//	private Hero hero = new Hero();

	private static GamePanel instance = new GamePanel();
	private InteractableWorld world = new InteractableWorld(UNIT_SIZE * WIDTH, UNIT_SIZE * HEIGHT);
	private GraphicsContext graphicsContext = world.getGraphicsContext2D();

	GamePanel() {}

	public static GamePanel getInstance() { return instance; }

	public void init(Stage stage) {
		this.stage = stage;
		AnchorPane root = new AnchorPane(world);
		Scene scene = new Scene(root, UNIT_SIZE * WIDTH, UNIT_SIZE * HEIGHT);

		stage.setTitle("Bubble Bobble");
		stage.getIcons().add(new Image("/icon.jpg"));
		stage.setResizable(false);
		stage.setScene(scene);
		world.startGame();

		stage.show();

		new AnimationTimer() {
			private long lastUpdate = 0 ;
			public void handle(long currentTime) {

//				world.clearRect(0, 0, an)
				world.updatePosition();
				world.paintComponent(graphicsContext);
			}
		}.start();
	}

	public void gameStart() {
//		world.
	}

	public void toIndex() {}
	public void gameOver() {}



//	public GamePanel(int width, int height) {
//		world = new InteractableWorld(width, height);
//
////		this.world = world;
//		world.startGame();
////		GraphicsContext gc = this.getGraphicsContext2D();
//
//
//		new AnimationTimer() {
//			public void handle(long currentTime) {
//				world.updatePosition();
//
//			}
//		}.start();
//
//	}
}