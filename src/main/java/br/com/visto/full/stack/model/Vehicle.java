package br.com.visto.full.stack.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidade para armazenamento dos dados de um veículo.
 * 
 * @author Marco Aurélio P. Gonçalves
 */

@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -5083816400425678092L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "plate")
	private String plate;

	@Column(name = "brand")
	private String brand;

	@Column(name = "model")
	private String model;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	/**
	 * Construtor default da classe.
	 */
	
	public Vehicle() {
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param id - Identificador do veículo.
	 * @param plate - Placa do veículo.
	 * @param brand - Marca do veículo.
	 * @param model - Modelo do veículo.
	 * @param status - Status do veículo.
	 * @param createdAt - Data de criação do veículo.
	 * @param updatedAt - Data de atualização do veículo.
	 */
	
	public Vehicle(Long id, String plate, 
			String brand, String model, String status, Date createdAt, Date updatedAt) {
		this.id = id;
		this.plate = plate;
		this.brand = brand;
		this.model = model;
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
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * @param plate the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
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
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("Vehicle [id=");
		builder.append(id);
		builder.append(", plate=");
		builder.append(plate);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", model=");
		builder.append(model);
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