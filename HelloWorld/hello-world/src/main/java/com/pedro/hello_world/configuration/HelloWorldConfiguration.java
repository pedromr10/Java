package com.pedro.hello_world.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
	
	//
	
	/*so para exemplo:
	@Bean
	public SdkAWS sdkAws() {
		return new SdkAws();
	}
	*/
	
	/*
	Explicacao de IA para a utilizacao de bean:
		No Spring Framework, o @Autowired só funciona para objetos que o próprio Spring sabe criar e gerenciar. Isso normalmente acontece quando a classe está anotada com algo como @Component, @Service ou outras anotações semelhantes, porque assim o Spring encontra essa classe automaticamente.
		
		No seu caso, a classe SdkAws não está anotada (ou não pode estar), então o Spring não sabe como criar uma instância dela sozinho. É aí que entra o @Bean: você cria um método dentro de uma classe anotada com @Configuration e diz explicitamente como esse objeto deve ser criado. Quando a aplicação sobe, o Spring executa esse método, cria o objeto e passa a gerenciá-lo dentro do container.
		
		A partir desse momento, esse objeto passa a existir dentro do contexto do Spring, e aí sim o @Autowired consegue injetá-lo em outras partes da aplicação.
	*/

}
