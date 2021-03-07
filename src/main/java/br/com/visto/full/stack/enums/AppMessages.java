package br.com.visto.full.stack.enums;

/**
 * Enumeração com as mensagens da aplicação.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public enum AppMessages {
	
	/**
	 * Declaração das mensagens disponíveis.
	 */
	
	UNKNOWN_ERROR(-1L, "unknown.error"),
	CUSTOMER_NOT_FOUND(-2L, "customer.not.found"),
	VEHICLE_NOT_FOUND(-3L, "vehicle.not.found"),
	ALLOCATION_NOT_FOUND(-4L, "allocation.not.found"),
	ALLOCATION_NOT_ACTIVE(-5L, "allocation.not.active"),
	
	CUSTOMER_ID_NOT_INFORMED(-11L, "customer.id.not.informed"),
	INVALID_CUSTOMER_ID(-12L, "invalid.customer.id"),
	VEHICLE_ID_NOT_INFORMED(-13L, "vehicle.id.not.informed"),
	INVALID_VEHICLE_ID(-14L, "invalid.vehicle.id"),
	ALLOCATION_START_DATE_NOT_INFORMED(-15L, "allocation.start.date.not.informed"),
	ALLOCATION_INVALID_START_DATE(-16L, "allocation.invalid.start.date"),
	ALLOCATION_END_DATE_NOT_INFORMED(-17L, "allocation.end.date.not.informed"),
	ALLOCATION_INVALID_END_DATE(-18L, "allocation.invalid.end.date"),
	ALLOCATION_START_DATE_GREATER_END_DATE(-19L, "allocation.start.date.greater.end.date"),
	CUSTOMER_ALREADY_HAS_ALLOCATION(-20L, "customer.already.has.allocation"),
	
	CUSTOMER_STATUS_NOT_INFORMED(-1001L, "customer.status.not.informed"),
	INVALID_CUSTOMER_STATUS(-1002L, "invalid.customer.status"),

	VEHICLE_STATUS_NOT_INFORMED(-2001L, "vehicle.status.not.informed"),
	INVALID_VEHICLE_STATUS(-2002L, "invalid.vehicle.status"),
	VEHICLE_ALREADY_ALLOCATED(-2003L, "vehicle.already.allocated"),

	ALLOCATION_ID_NOT_INFORMED(-3001L, "allocation.id.not.informed"),
	INVALID_ALLOCATION_ID(-3002L, "invalid.allocation.id"),
	ALLOCATION_STATUS_NOT_INFORMED(-3003L, "allocation.status.not.informed"),
	INVALID_ALLOCATION_STATUS(-3004L, "invalid.allocation.status");
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	Long code;
	String key;
	
	/**
	 * Construtor alternativo da enumeraçãp.
	 * 
	 * @param code - Código da mensagem.
	 * @param key - Chave do arquivo de mensagens.
	 */
	
	AppMessages(Long code, String key) {
		this.code = code;
		this.key = key;
	}

	/**
	 * @return the code
	 */
	public Long code() {
		return code;
	}

	/**
	 * @return the key
	 */
	public String key() {
		return key;
	}

}
