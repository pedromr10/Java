package com.javafx;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.JSONObject;

public class SistemaClimatico {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome da cidade: ");
		String cidade = scanner.nextLine();
		
		try {
			String  dadosClimaticos = getDadosClimaticos(cidade);
			
			//codigo 1006 = resposta da api para localizacao nao foi encontrada
			if(dadosClimaticos.contains("\"code\":1006")) {
				System.out.println("Localizacao nao encontrada");
			}
			else {
				imprimirDadosClimaticos(dadosClimaticos);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String getDadosClimaticos(String cidade) throws Exception{
		String apiKey = Files.readString(Paths.get("src/main/resources/api/api-key.txt")).trim();
		String formataNomeCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
		
		String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formataNomeCidade; 
		
		//começa a construcao de uma nova solicitacao http:
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(apiUrl)) //define o rui da solicitacao http
				.build(); //finaliza a construcao da solicitacao http
		
		//cria objeto para enviar solicitacoes e receber respostas http:
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
	}
	
	public static void imprimirDadosClimaticos(String dados) {
		JSONObject dadosJson = new JSONObject(dados);
		JSONObject informacoesMeteorologicas = dadosJson.getJSONObject("current");
		
		String cidade = dadosJson.getJSONObject("location").getString("name");
		String pais = dadosJson.getJSONObject("location").getString("country");
		String condicaoTempo = informacoesMeteorologicas.getJSONObject("condition").getString("text");
		int umidade = informacoesMeteorologicas.getInt("humidity");
		float velocidadeVento = informacoesMeteorologicas.getFloat("wind_kph");
		float pressaoAtmosferica = informacoesMeteorologicas.getFloat("pressure_mb");
		float sensacaoTermica = informacoesMeteorologicas.getFloat("feelslike_c");
		float temperaturaAtual = informacoesMeteorologicas.getFloat("temp_c");
		String dataHoraString = informacoesMeteorologicas.getString("last_updated");
		
		System.out.println("Informacoes meteorologicas para " + cidade + ", " + pais);
		System.out.println("Data e hora: " + dataHoraString);
		System.out.println("Temperatura atual: " + temperaturaAtual + " graus celcius");
		System.out.println("Sensacao termica: " + sensacaoTermica + " graus celcius");
		System.out.println("Condicao do tempo: " + condicaoTempo);
		System.out.println("Umidade: " + umidade + "%");
		System.out.println("Velocidade do vento: " + velocidadeVento + " kmh");
		System.out.println("Pressao atmosferica: " + pressaoAtmosferica + " mb");
	}
}









