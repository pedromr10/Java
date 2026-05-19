package com.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXImage extends Application {
	
	@Override
	public void start(Stage palco) {
		String caminhoImagem = "/imagens/sapo.jpg";
		Image imagem = new Image(caminhoImagem);
		ImageView imageView = new ImageView(imagem);
		
		imageView.setFitWidth(610); //largura em pixel
		imageView.setFitHeight(300); //altura em pixel
		imageView.setPreserveRatio(true); //tamanho original
		
		VBox layout = new VBox(imageView);
		Scene cena = new Scene(layout, 700, 700);
		
		palco.setScene(cena);
		palco.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
