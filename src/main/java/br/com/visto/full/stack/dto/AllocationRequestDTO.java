package br.com.visto.full.stack.dto;

import java.io.Serializable;
import java.util.Calendar;

/**
 * DTO para armazenamento dos dados de uma requisição de alocação.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public class AllocationRequestDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -7047401265768402605L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private Long idAllocation;
	private Long idCustomer;
	private Long idVehicle;
	private Calendar startDate;
	private Calendar endDate;
	
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
	 * @return the idVehicle
	 */
	public Long getIdVehicle() {
		return idVehicle;
	}
	
	/**
	 * @param idVehicle the idVehicle to set
	 */
	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}
	
	/**
	 * @return the startDate
	 */
	public Calendar getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return the endDate
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("AllocationRequestDTO [idAllocation=");
		builder.append(idAllocation);
		builder.append(", idCustomer=");
		builder.append(idCustomer);
		builder.append(", idVehicle=");
		builder.append(idVehicle);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		
		return builder.toString();
		
	}

}
