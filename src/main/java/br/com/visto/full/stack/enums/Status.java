package br.com.visto.full.stack.enums;

/**
 * Enumeração com os status disponíveis.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public enum Status {
	
	/**
	 * Declaração das mensagens disponíveis.
	 */
	
	ACTIVE("A", "Ativo"),
	INACTIVE("I", "Inativo");
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	String code;
	String description;
	
	/**
	 * Construtor alternativo da enumeraçãp.
	 * 
	 * @param code - Código do status.
	 * @param description - Descrição do status.
	 */
	
	Status(String code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public String code() {
		return code;
	}

	/**
	 * @return the key
	 */
	public String description() {
		return description;
	}

}
