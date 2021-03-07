package br.com.visto.full.stack.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade para armazenamento dos dados de uma alocação.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Entity
@Table(name = "allocations")
public class Allocation implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -7740240870152968355L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_customer")
	private Long idCustomer;
	
	@Column(name = "id_vehicle")
	private Long idVehicle;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endDate;
	
	@Column(name = "status", insertable = false)
	private String status;
	
	@Column(name = "created_at", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	@Column(name = "updated_at", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "id_customer", insertable = false, updatable = false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "id_vehicle", insertable = false, updatable = false)
	private Vehicle vehicle;

	/**
	 * Construtor default da classe.
	 */
	
	public Allocation() {
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param id - Identificador da alocação.
	 * @param idCustomer - Identificador do cliente.
	 * @param idVehicle - Identificador do veículo.
	 * @param startDate - Data inicial da alocação.
	 * @param endDate - Data final da alocação.
	 * @param status - Status da alocação.
	 * @param createdAt - Data de criação da alocação.
	 * @param updatedAt - Data de atualização da alocação.
	 */
	
	public Allocation(Long id, Long idCustomer, 
			Long idVehicle, Calendar startDate, Calendar endDate, 
			String status, Calendar createdAt, Calendar updatedAt) {
		this.id = id;
		this.idCustomer = idCustomer;
		this.idVehicle = idVehicle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



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

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("Allocation [id=");
		builder.append(id);
		builder.append(", idCustomer=");
		builder.append(idCustomer);
		builder.append(", idVehicle=");
		builder.append(idVehicle);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", customer=");
		builder.append(customer);
		builder.append(", vehicle=");
		builder.append(vehicle);
		builder.append("]");
		
		return builder.toString();
		
	}

}