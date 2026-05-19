package com.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXMinhaAplicacao extends Application{
	@Override
	public void start(Stage palco) {
		palco.setTitle("Meu primeiro palco");
		Label label = new Label("Ola, mundo! Sou uma label");
		Button botao = new Button("Clique aqui");
		TextField campoTexto = new TextField();
		
		VBox layout = new VBox(label, botao, campoTexto);
		
		Scene cena = new Scene(layout, 300, 200); //300px, 200px
		palco.setScene(cena);
		palco.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
