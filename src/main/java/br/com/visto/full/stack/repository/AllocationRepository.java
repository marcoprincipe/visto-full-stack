package br.com.visto.full.stack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.visto.full.stack.model.Allocation;

/**
 * Repositório da tabela de alocações.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
	
	/**
	 * Retorna a lista de alocações a partir do status informado.
	 * 
	 * @param status - Status para pesquisa das alocações.
	 * 
	 * @return - Lista de alocações.
	 */
	
	List<Allocation> findAllByStatus(String status);
	
	/**
	 * Efetua a pesquisa pelo identificador do cliente e o status da alocação.
	 * 
	 * @param idCustomer - Identificador do cliente para pesquisa.
	 * @param status - Status da alocação.
	 * 
	 * @return - Entidade com a alocação.
	 */
	
	Allocation findByIdCustomerAndStatus(Long idCustomer, String status);
	
	/**
	 * Efetua a pesquisa pelo identificador do veículo e o status da alocação.
	 * 
	 * @param idCustomer - Identificador do veículo para pesquisa.
	 * @param status - Status da alocação.
	 * 
	 * @return - Entidade com a alocação.
	 */
	
	Allocation findByIdVehicleAndStatus(Long idVehicle, String status);

}
