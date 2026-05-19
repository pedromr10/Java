package com.javafx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RelogioDigital extends Application{
	
	final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Override
	public void start(Stage palco) {
		Label rotuloTempo = new Label();
		rotuloTempo.setStyle("-fx-font-size: 24pt; -fx-text-fill: yellow;");
		
		KeyFrame keyFrameAtualizar = new KeyFrame(Duration.ZERO, e -> {
			rotuloTempo.setText(LocalDateTime.now().format(FORMATADOR));
		});
		
		//intervalo de atualizacao:
		KeyFrame keyFrameIntervalo = new KeyFrame(Duration.seconds(1));
		
		//timeline e adicao de keyframe:
		Timeline relogio = new Timeline();
		relogio.getKeyFrames().addAll(keyFrameAtualizar, keyFrameIntervalo);
		
		relogio.setCycleCount(Animation.INDEFINITE); //roda infinitamente
		relogio.play(); //inicia a timeline
		
		VBox layout = new VBox(rotuloTempo);
		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: black;");
		Scene cena = new Scene(layout, 260, 100);
		palco.setTitle("Relogio digital");
		palco.setScene(cena);
		palco.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
