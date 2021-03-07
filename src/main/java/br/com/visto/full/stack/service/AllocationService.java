package br.com.visto.full.stack.service;

import java.util.List;

import br.com.visto.full.stack.dto.AllocationRequestDTO;
import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Allocation;

/**
 * Interface para implementação dos serviços de alocações.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public interface AllocationService {
	
	/**
	 * Efetua a alocação de um veículo.
	 * 
	 * @param request - Objeto com os dados da alocação.
	 * 
	 * @return - Resultado da operação.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	Integer doAllocation(AllocationRequestDTO request) throws ServiceException;
	
	/**
	 * Efetua o cancelamento da alocação de um veículo.
	 * 
	 * @param request - Objeto com os dados da alocação.
	 * 
	 * @return - Resultado da operação.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	Integer cancelAllocation(AllocationRequestDTO request) throws ServiceException;
	
	/**
	 * Efetua o encerramento da alocação de um veículo.
	 * 
	 * @param request - Objeto com os dados da alocação.
	 * 
	 * @return - Resultado da operação.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	Integer terminateAllocation(AllocationRequestDTO request) throws ServiceException;
	
	/**
	 * Retorna a lista de alocações ativas.
	 * 
	 * @return - Lista de alocações.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	List<Allocation> listActivies() throws ServiceException;
	
	/**
	 * Retorna a lista de alocações a partir do status informado.
	 * 
	 * @param status - Status para pesquisa das alocações.
	 * 
	 * @return - Lista de alocações.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	List<Allocation> listByStatus(String status) throws ServiceException;
	
	/**
	 * Efetua o cálculo dos dias restantes por cliente.
	 * 
	 * @return - Resultado da operação.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	Integer calculateRemainingDays() throws ServiceException;

}