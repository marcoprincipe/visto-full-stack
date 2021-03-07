package br.com.visto.full.stack.dto;

import java.io.Serializable;

/**
 * DTO para armazenamento dos dados de dias restantes de uma alocação.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public class RemainingDaysDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -2061127430921187321L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private Long idAllocation;
	private Long idCustomer;
	private String startDate;
	private String endDate;
	private Long remainingDays;
	
	/**
	 * @return the idAllocation
	 */
	public Long getIdAllocation() {
		return idAllocation;
	}
	
	/**
	 * @param idAllocation the idAllocation to set
	 */
	public void setIdAllocation(Long idAllocation) {
		this.idAllocation = idAllocation;
	}
	
	/**
	 * @return the idCustomer
	 */
	public Long getIdCustomer() {
		return idCustomer;
	}
	
	/**
	 * @param idCustomer the idCustomer to set
	 */
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return the remainingDays
	 */
	public Long getRemainingDays() {
		return remainingDays;
	}

	/**
	 * @param remainingDays the remainingDays to set
	 */
	public void setRemainingDays(Long remainingDays) {
		this.remainingDays = remainingDays;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("RemainingDaysDTO [idAllocation=");
		builder.append(idAllocation);
		builder.append(", idCustomer=");
		builder.append(idCustomer);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", remainingDays=");
		builder.append(remainingDays);
		builder.append("]");
		
		return builder.toString();
		
	}

}
