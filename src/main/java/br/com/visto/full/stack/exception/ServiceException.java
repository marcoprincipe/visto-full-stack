package br.com.visto.full.stack.exception;

import br.com.visto.full.stack.enums.AppMessages;

/**
 * Classe de exceção da camada de negócios.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public class ServiceException extends Exception {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 883747619775435085L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private Long code = AppMessages.UNKNOWN_ERROR.code();

	/**
	 * Construtor default da classe.
	 */

	public ServiceException() {
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param message - Mensagem da exceção.
	 */
	
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param code - Código da exceção.
	 * @param message - Mensagem da exceção.
	 */
	
	public ServiceException(Long code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param cause - Causa raiz da exceção.
	 */
	
	public ServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param code - Código da exceção.
	 * @param cause - Causa raiz da exceção.
	 */
	
	public ServiceException(Long code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param message - Mensagem da exceção.
	 * @param cause - Causa raiz da exceção.
	 */

	public ServiceException(String message, Throwable cause) {
		super(cause);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param code - Código da exceção.
	 * @param message - Mensagem da exceção.
	 * @param cause - Causa raiz da exceção.
	 */

	public ServiceException(Long code, String message, Throwable cause) {
		super(cause);
		this.code = code;
	}
	
	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

}
