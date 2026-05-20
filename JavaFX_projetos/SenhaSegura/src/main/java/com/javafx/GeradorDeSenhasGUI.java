package com.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GeradorDeSenhasGUI extends Application{
	
	@Override
	public void start(Stage palco) {
		palco.setTitle("Gerador de senhas");
		
		Label labelTamanho = new Label("Tamanho da senha: ");
		TextField campoTamanho = new TextField();
		campoTamanho.setText("8");
		
		Label labelSenhaGerada = new Label("Senha gerada: ");
		TextField campoSenhaGerada = new TextField();
		campoSenhaGerada.setEditable(false);
		
		Button botaoGerar = new Button("Gerar senha");
		botaoGerar.setOnAction(e->{
			int tamanhoSenha = Integer.parseInt(campoTamanho.getText());
			String senha = SenhaSegura.gerarSenha(tamanhoSenha);
			campoSenhaGerada.setText(senha);
		});
		VBox vBox = new VBox(labelTamanho, campoTamanho, botaoGerar, labelSenhaGerada, campoSenhaGerada);
		Scene cena = new Scene(vBox, 250, 200);
		palco.setScene(cena);
		palco.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
