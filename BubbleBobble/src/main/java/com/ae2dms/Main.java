package com.ae2dms;

import com.ae2dms.UI.GamePanel;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

//import javax.swing.JFrame;

/**
 * Main creates a JFrame and adds a com.ae2dms.UI.GamePanel to that frame.
 * The size of the GamePanel is determined here.
 */
public class Main extends Application {
	public static final int UNIT_SIZE = 20;
	static final int WIDTH = 40;
	static final int HEIGHT = 34;

	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setResizable(false);
//		frame.add(new GamePanel(WIDTH * UNIT_SIZE, HEIGHT * UNIT_SIZE));
//
//		frame.pack();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, WIDTH * UNIT_SIZE, HEIGHT * UNIT_SIZE);
		stage.setScene(scene);
		stage.setResizable(false);

		stage.sizeToScene();
//		Canvas canvas = new Canvas(512, 512);
		root.getChildren().add(new GamePanel(WIDTH * UNIT_SIZE, HEIGHT * UNIT_SIZE));
		stage.show();
	}
}
