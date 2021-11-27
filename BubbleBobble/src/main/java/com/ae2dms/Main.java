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

