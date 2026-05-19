package com.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXList extends Application{
	
	@Override
	public void start(Stage palco) {
		ObservableList<String> itens;
		itens = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");
		ListView<String> listView = new ListView<>(itens);
		VBox layout = new VBox(listView);
		Scene cena = new Scene(layout, 300, 200);
		
		palco.setScene(cena);
		palco.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
