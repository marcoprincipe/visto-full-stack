package br.com.visto.full.stack.service.impl;

import java.util.ResourceBundle;

import br.com.visto.full.stack.enums.AppMessages;
import br.com.visto.full.stack.exception.ServiceException;

/**
 * Classe base para extensão dos demais serviços.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public class BaseService {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private ResourceBundle resourceBundle;

	/**
	 * Construtor default da classe.
	 */
	
	public BaseService() {
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param resourceBundle - Instância da classe ResourceBundle.
	 */
	
	public BaseService(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}
	
	/**
	 * Retorna a instância da exceção da camada de negócios.
	 * 
	 * @param appMessages - Enumeração para criação da instância da exceção.
	 * 
	 * @return - Instância da exceção ServiceException.
	 */
	
	protected ServiceException serviceException(AppMessages appMessages) {
		
		Long code = appMessages.code();
		String message = resourceBundle.getString(appMessages.key());
		
		return new ServiceException(code, message);
		
	}

}
