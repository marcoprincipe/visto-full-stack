package br.com.visto.full.stack.enums;

/**
 * Enumeração com os status de alocações disponíveis.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public enum AllocationStatus {
	
	/**
	 * Declaração das mensagens disponíveis.
	 */
	
	ACTIVE("A", "Alocação ativa"),
	TERMINATED("T", "Alocação encerrada"),
	CANCELED("C", "Alocação cancelada"),
	EXPIRED("E", "Alocação expirada");
	
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
	
	AllocationStatus(String code, String description) {
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
