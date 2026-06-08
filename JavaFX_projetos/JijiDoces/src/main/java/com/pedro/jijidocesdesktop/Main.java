package com.pedro.jijidocesdesktop;

import com.pedro.jijidocesdesktop.services.ProductClient;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		
		ProductClient productClient = new ProductClient();
		
		try {
			String json = productClient.getAllProducts();
			System.out.println(json);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

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