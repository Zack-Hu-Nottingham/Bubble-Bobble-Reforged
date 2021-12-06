package com.ae2dms;

import com.ae2dms.Util.GameRecorder;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Main creates a JFrame and adds a com.ae2dms.GamePanel to that frame.
 * The size of the GamePanel is determined here.
 */

public class Main extends Application {

	public static Stage stage;

	public static void main(String[] args) throws IOException {
//		GameRecorder gameRecorder = new GameRecorder();
//		gameRecord.saveRecord("foo", 200, 15);
//		gameRecorder.readRecord();
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		GamePanel.getInstance().init(stage);
	}
}

