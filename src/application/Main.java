package application;

import graphic.StartScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		StartScreen startscreen = new StartScreen(primaryStage);
		startscreen.startanimation();
		primaryStage.show();
	}
	public static void main(String [] args) {
		launch(args);
	}
}
