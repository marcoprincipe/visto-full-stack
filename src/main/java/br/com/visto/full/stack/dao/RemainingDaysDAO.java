package br.com.visto.full.stack.dao;

import br.com.visto.full.stack.exception.DAOException;
import br.com.visto.full.stack.model.RemainingDays;

/**
 * Interface para implementação dos DAOs de dias restantes de alocação.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

public interface RemainingDaysDAO {
	
	/**
	 * Efetua a gravação dos dados dos dias restantes.
	 * 
	 * @param entity - Objeto com os dados a seren persistidos.
	 * 
	 * @return - Objeto com os dados persistidos.
	 * 
	 * @throws DAOException - Exceção da camada de integração
	 */
	
	RemainingDays persist(RemainingDays entity) throws DAOException;

}
