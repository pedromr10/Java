package com.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraIMC extends Application{

	@Override
	public void start(Stage palco) {
		Label etiquetaPeso = new Label("Peso: ");
		Label etiquetaAltura = new Label("Altura: ");
		
		TextField campoPeso = new TextField();
		campoPeso.setPromptText("Peso em kg");
		TextField campoAltura = new TextField();
		campoAltura.setPromptText("Altura em m");
		
		Label etiquetaResultado = new Label();
		
		Button botaoCalcular = new Button("Calcular IMC");
		botaoCalcular.setOnAction(e -> {
			double peso = Double.parseDouble(campoPeso.getText());
			double altura = Double.parseDouble(campoAltura.getText());
			
			double imc = peso / (altura*altura);
			etiquetaResultado.setText(String.format("Seu IMC e: %.2f", imc));
		});
		
		VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular, etiquetaResultado);
		layout.setPadding(new Insets(10));
		layout.setAlignment(Pos.CENTER);
		
		Scene cena = new Scene(layout, 300, 250);
		palco.setTitle("Calculadora de IMC");
		palco.setScene(cena);
		palco.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
