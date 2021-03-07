package br.com.visto.full.stack.service.impl;

import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visto.full.stack.enums.AppMessages;
import br.com.visto.full.stack.enums.Status;
import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Vehicle;
import br.com.visto.full.stack.repository.VehicleRepository;
import br.com.visto.full.stack.service.VehicleService;

/**
 * Implementação da interface dos serviços de veículos.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Service
public class VehicleServiceImpl extends BaseService implements VehicleService {
	
	/**
	 * Declaração das variáveis membro.
	 */

	private VehicleRepository vehicleRepository;

	/**
	 * Construtor default da classe.
	 */
	
	public VehicleServiceImpl() {
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param vehicleRepository - Instância do repositório de veículos.
	 * @param resourceBundle - Instância da classe ResourceBundle.
	 */
	
	@Autowired
	public VehicleServiceImpl(VehicleRepository vehicleRepository, ResourceBundle resourceBundle) {
		super(resourceBundle);
		this.vehicleRepository = vehicleRepository;
	}
	
	/**
	 * Retorna a lista de veículos ativos.
	 * 
	 * @return - Lista de veículos.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	@Override
	public List<Vehicle> listActivies() throws ServiceException {

		return listByStatus(Status.ACTIVE.code());
		
	}
	
	/**
	 * Retorna a lista de veículos a partir do status informado.
	 * 
	 * @param status - Status para pesquisa dos veículos.
	 * 
	 * @return - Lista de veículos.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	@Override
	public List<Vehicle> listByStatus(String status) throws ServiceException {
		
		if (null == status || status.trim().isEmpty()) {
			throw serviceException(AppMessages.VEHICLE_STATUS_NOT_INFORMED);
		}

		if (!status.equals(Status.ACTIVE.code()) && 
			!status.equals(Status.INACTIVE.code())) {
			throw serviceException(AppMessages.INVALID_VEHICLE_STATUS);
		}
		
		List<Vehicle> vehicles = vehicleRepository.findAllByStatus(status);
		
		return vehicles;
		
	}

}
