package br.com.visto.full.stack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.visto.full.stack.model.Vehicle;

/**
 * Repositório da tabela de veículos.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	/**
	 * Efetua a pesquisa a partir do identificador e o status do veículo.
	 * 
	 * @param id - Identificador do veículo para pesquisa.
	 * @param status - Status para pesquisa do veículo.
	 * 
	 * @return - Entidade com os dados do veículo.
	 */
	
	Vehicle findByIdAndStatus(Long id, String status);
	
	/**
	 * Retorna a lista de veículos a partir do status informado.
	 * 
	 * @param status - Status para pesquisa dos veículos.
	 * 
	 * @return - Lista de veículos.
	 */
	
	List<Vehicle> findAllByStatus(String status);

}
