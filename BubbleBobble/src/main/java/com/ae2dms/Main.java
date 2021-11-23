package com.ae2dms;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Main creates a JFrame and adds a com.ae2dms.GamePanel to that frame.
 * The size of the GamePanel is determined here.
 */

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		GamePanel.getInstance().init(stage);
	}
}

//public class Main extends Application {
//
//	public static void main(String[] args) {
////		JFrame frame = new JFrame();
////		frame.setResizable(false);
////		frame.add(new GamePanel(WIDTH * UNIT_SIZE, HEIGHT * UNIT_SIZE));
////
////		frame.pack();
////		frame.setVisible(true);
////		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		launch();
//	}
//
//	@Override
//	public void start(Stage stage) throws Exception {
//		GamePanel.getInstance().init(stage);
//
//
////		Group root = new Group();
////		Scene scene = new Scene(root, WIDTH * UNIT_SIZE, HEIGHT * UNIT_SIZE);
////		stage.setScene(scene);
////		stage.setResizable(false);
////
////		stage.sizeToScene();
//////		Canvas canvas = new Canvas(512, 512);
////		root.getChildren().add(new GamePanel(WIDTH * UNIT_SIZE, HEIGHT * UNIT_SIZE));
////		stage.show();
//	}
//}
