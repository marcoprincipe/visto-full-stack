package br.com.visto.full.stack.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade para armazenamento dos dados dos dias restantes de uma alocação.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Entity
@Table(name = "remaining_days")
public class RemainingDays implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -7088665965256468482L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_allocation")
	private Long idAllocation;
	
	@Column(name = "id_customer")
	private Long idCustomer;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endDate;
	
	@Column(name = "remaining_days")
	private Long remainingDays;
	
	@Column(name = "status", insertable = false)
	private String status;
	
	@Column(name = "created_at", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	@Column(name = "updated_at", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the createdAt
	 */
	public Calendar getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("RemainingDays [id=");
		builder.append(id);
		builder.append(", idAllocation=");
		builder.append(idAllocation);
		builder.append(", idCustomer=");
		builder.append(idCustomer);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", remainingDays=");
		builder.append(remainingDays);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
