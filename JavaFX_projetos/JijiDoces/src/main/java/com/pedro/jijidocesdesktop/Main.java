package com.pedro.jijidocesdesktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) {

		Label label = new Label("Jiji Doces");

		Scene scene = new Scene(new StackPane(label), 800, 600);

		stage.setTitle("Jiji Doces");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}