package br.com.visto.full.stack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.visto.full.stack.model.Customer;

/**
 * Repositório da tabela de clientes.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	/**
	 * Efetua a pesquisa a partir do identificador e o status do cliente.
	 * 
	 * @param id - Identificador do cliente para pesquisa.
	 * @param status - Status para pesquisa do cliente.
	 * 
	 * @return - Entidade com os dados do cliente.
	 */
	
	Customer findByIdAndStatus(Long id, String status);
	
	/**
	 * Retorna a lista de clientes a partir do status informado.
	 * 
	 * @param status - Status para pesquisa dos clientes.
	 * 
	 * @return - Lista de clientes.
	 */
	
	List<Customer> findAllByStatus(String status);
	
}