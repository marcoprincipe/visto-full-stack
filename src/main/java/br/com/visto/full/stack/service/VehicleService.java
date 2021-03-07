package br.com.visto.full.stack.service;

import java.util.List;

import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Vehicle;

/**
 * Interface para implementação dos serviços de veículos.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public interface VehicleService {
	
	/**
	 * Retorna a lista de veículos ativos.
	 * 
	 * @return - Lista de veículos.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	List<Vehicle> listActivies() throws ServiceException;
	
	/**
	 * Retorna a lista de veículos a partir do status informado.
	 * 
	 * @param status - Status para pesquisa dos veículos.
	 * 
	 * @return - Lista de veículos.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	List<Vehicle> listByStatus(String status) throws ServiceException;

}
