package logic;

import graphic.GameWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Buttons extends HBox{

	private static final Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 20);
	public Button startButton;
	public Button exitButton;
	
	public Buttons(String name) {
		setSpacing(50);
		setPrefWidth(800);
		setPrefHeight(100);
		setAlignment(Pos.BOTTOM_CENTER);
		
		startButton = new Button(name);
		exitButton = new Button("Exit");		
		startButton.setPrefSize(100, 45);
		exitButton.setPrefSize(100, 45);
		startButton.setFont(mainFont);
		exitButton.setFont(mainFont);
		getChildren().addAll(startButton, exitButton);
	}
	public void setupExitButton() {
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
	}

}
