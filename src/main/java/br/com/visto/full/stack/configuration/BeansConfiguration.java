package br.com.visto.full.stack.configuration;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Classe para criação e configuração dos beans da aplicação.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Configuration
public class BeansConfiguration {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Value("${USER_LANGUAGE:pt}")
	private String language;

	@Value("${USER_COUNTRY:BR}")
	private String country;
	
	@Value("${VISTO_RABBITMQ_QUEUE:visto-queue}")
	private String queueName;
	
	/**
	 * Retorna a instância da classe ResourceBundle.
	 * 
	 * @return - Instância da classe ResourceBundle configurada.
	 */
	
	@Bean
	public ResourceBundle resourceBundle() {

		Locale locale = new Locale(language, country);

		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/messages", locale);
		
		return resourceBundle;
		
	}
	
	/**
	 * Efetua a criação da fila de mensagens
	 * 
	 * @return - Instância da fila de mensagens configurada.
	 */
	
	@Bean
	public Queue createQueue() {
		
		return new Queue(queueName, true);
		
	}

	/**
	 * Retorna a configuração do Swagger
	 * 
	 * @return - Instância configurada do swagger;
	 */
	
	@Bean
	public Docket springFox() {
		
		return new Docket(DocumentationType.SWAGGER_2).
				select().
				apis(RequestHandlerSelectors.any()).
				paths(PathSelectors.any()).
				build();
		
	}

}
