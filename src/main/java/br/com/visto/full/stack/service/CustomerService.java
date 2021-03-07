package br.com.visto.full.stack.service;

import java.util.List;

import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Customer;

/**
 * Interface para implementação dos serviços de clientes.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public interface CustomerService {
	
	/**
	 * Retorna a lista de clientes ativos.
	 * 
	 * @return - Lista de clientes.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	List<Customer> listActivies() throws ServiceException;
	
	/**
	 * Retorna a lista de clientes a partir do status informado.
	 * 
	 * @param status - Status para pesquisa dos clientes.
	 * 
	 * @return - Lista de clientes.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	List<Customer> listByStatus(String status) throws ServiceException;

}
