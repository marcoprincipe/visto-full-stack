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
 * Entidade para armazenamento dos dados de um cliente.
 * 
 * @author Marco Aurélio P. Gonçalves
 */

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -5022033528308895606L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code")
	private Long code;
	
	@Column(name = "name")
	private String name;
	
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
	
	public Customer() {
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param id - Identificador do cliente.
	 * @param code - Código do cliente.
	 * @param name - Nome do cliente.
	 * @param status - Status do cliente.
	 * @param createdAt - Data de criação do cliente.
	 * @param updatedAt - Data de atualização do cliente.
	 */
	
	public Customer(Long id, Long code, 
			String name, String status, Date createdAt, Date updatedAt) {
		this.id = id;
		this.code = code;
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
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
