package br.com.visto.full.stack.rest;

import java.io.Serializable;

/**
 * Classe para respostas de requisições rest.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public class RestResponse<T> implements Serializable {
	
	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 2099355501073456477L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private Long code;
	private String message;
	private T data;

	/**
	 * Construtor default da classe.
	 */
	
	public RestResponse() {
		this(0L, "ok", null);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param data - Dados de retorno da operação.
	 */
	
	public RestResponse(T data) {
		this(0L, "ok", data);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param code - Código com o resultado da operação.
	 * @param message - Mensagem do resultado da operação.
	 */
	
	public RestResponse(Long code, String message) {
		this(code, message, null);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param code - Código com o resultado da operação.
	 * @param message - Mensagem do resultado da operação.
	 * @param data - Dados de retorno da operação.
	 */
	
	public RestResponse(Long code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}
	
	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("RestResponse [code=");
		builder.append(code);
		builder.append(", message=");
		builder.append(message);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		
		return builder.toString();
		
	}

}
