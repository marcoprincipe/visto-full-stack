package br.com.visto.full.stack.service.impl;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visto.full.stack.dao.RemainingDaysDAO;
import br.com.visto.full.stack.dto.AllocationRequestDTO;
import br.com.visto.full.stack.enums.AllocationStatus;
import br.com.visto.full.stack.enums.AppMessages;
import br.com.visto.full.stack.enums.Status;
import br.com.visto.full.stack.exception.DAOException;
import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Allocation;
import br.com.visto.full.stack.model.Customer;
import br.com.visto.full.stack.model.RemainingDays;
import br.com.visto.full.stack.model.Vehicle;
import br.com.visto.full.stack.repository.AllocationRepository;
import br.com.visto.full.stack.repository.CustomerRepository;
import br.com.visto.full.stack.repository.VehicleRepository;
import br.com.visto.full.stack.service.AllocationService;

/**
 * Implementação da interface dos serviços de alocações.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Service
public class AllocationServiceImpl extends BaseService implements AllocationService {
	
	/**
	 * Declaração das variáveis membro.
	 */

	private CustomerRepository customerRepository;
	private VehicleRepository vehicleRepository;
	private AllocationRepository allocationRepository;
	private RemainingDaysDAO remainingDaysDAO; 

	/**
	 * Construtor default da classe.
	 */
	
	public AllocationServiceImpl() {
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param customerRepository - Instância do repositório de clientes.
	 * @param vehicleRepository - Instância do repositório de veículos.
	 * @param allocationRepository - Instância do repositório de alocações.
	 * @param remainingDaysDAO - Instância do DAO de dias restantes de alocação.
	 * @param resourceBundle - Instância da classe ResourceBundle.
	 */
	
	@Autowired
	public AllocationServiceImpl(
			CustomerRepository customerRepository,
			VehicleRepository vehicleRepository,
			AllocationRepository allocationRepository, 
			RemainingDaysDAO remainingDaysDAO,
			ResourceBundle resourceBundle) {
		super(resourceBundle);
		this.customerRepository = customerRepository;
		this.vehicleRepository = vehicleRepository;
		this.remainingDaysDAO = remainingDaysDAO;
		this.allocationRepository = allocationRepository;
	}
	
	/**
	 * Efetua a alocação de um veículo.
	 * 
	 * @param request - Objeto com os dados da alocação.
	 * 
	 * @return - Resultado da operação.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */

	@Override
	@Transactional
	public Integer doAllocation(AllocationRequestDTO request) throws ServiceException {
		
		if (null == request.getIdCustomer() ||
			request.getIdCustomer() == 0) {
			throw serviceException(AppMessages.CUSTOMER_ID_NOT_INFORMED);
		}

		if (request.getIdCustomer() < 0) {
			throw serviceException(AppMessages.INVALID_CUSTOMER_ID);
		}
		
		if (null == request.getIdVehicle() ||
			request.getIdVehicle() == 0) {
			throw serviceException(AppMessages.VEHICLE_ID_NOT_INFORMED);
		}

		if (request.getIdVehicle() < 0) {
			throw serviceException(AppMessages.INVALID_VEHICLE_ID);
		}
		
		if (request.getStartDate() == null) {
			throw serviceException(AppMessages.ALLOCATION_START_DATE_NOT_INFORMED);
		}
		
		if (request.getEndDate() == null) {
			throw serviceException(AppMessages.ALLOCATION_END_DATE_NOT_INFORMED);
		}
		
		if (request.getStartDate().compareTo(Calendar.getInstance()) < 0) {
			throw serviceException(AppMessages.ALLOCATION_INVALID_START_DATE);
		}
		
		if (request.getStartDate().compareTo(request.getEndDate()) > 0) {
			throw serviceException(AppMessages.ALLOCATION_START_DATE_GREATER_END_DATE);
		}
		
		Customer customer = 
				customerRepository.findByIdAndStatus(request.getIdCustomer(), Status.ACTIVE.code());
		
		if (null == customer) {
			throw serviceException(AppMessages.CUSTOMER_NOT_FOUND);
		}
		
		Vehicle vehicle = 
				vehicleRepository.findByIdAndStatus(request.getIdVehicle(), Status.ACTIVE.code());
		
		if (null == vehicle) {
			throw serviceException(AppMessages.VEHICLE_NOT_FOUND);
		}
		
		Allocation allocationDb = 
				allocationRepository.findByIdVehicleAndStatus(request.getIdVehicle(), AllocationStatus.ACTIVE.code());
		
		if (allocationDb != null) {
			throw serviceException(AppMessages.VEHICLE_ALREADY_ALLOCATED);
		}
		
		allocationDb = 
				allocationRepository.findByIdCustomerAndStatus(request.getIdCustomer(), AllocationStatus.ACTIVE.code());
		
		if (allocationDb != null) {
			throw serviceException(AppMessages.CUSTOMER_ALREADY_HAS_ALLOCATION);
		}

		Allocation entity = new Allocation();
		BeanUtils.copyProperties(request, entity);
		
		entity = allocationRepository.save(entity);
		
		return 0;
		
	}
	
	/**
	 * Efetua o cancelamento da alocação de um veículo.
	 * 
	 * @param request - Objeto com os dados da alocação.
	 * 
	 * @return - Resultado da operação.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	@Override
	@Transactional
	public Integer cancelAllocation(AllocationRequestDTO request) throws ServiceException {
		
		if (null == request.getIdAllocation() ||
			request.getIdAllocation() == 0) {
			throw serviceException(AppMessages.ALLOCATION_ID_NOT_INFORMED);
		}

		if (request.getIdAllocation() < 0) {
			throw serviceException(AppMessages.INVALID_ALLOCATION_ID);
		}
		
		Optional<Allocation> allocationDb = 
				allocationRepository.findById(request.getIdAllocation());

		if (null == allocationDb || !allocationDb.isPresent()) {
			throw serviceException(AppMessages.ALLOCATION_NOT_FOUND);
		}
		
		Allocation allocation = allocationDb.get();

		if (!allocation.getStatus().equals(AllocationStatus.ACTIVE.code())) {
			throw serviceException(AppMessages.ALLOCATION_NOT_ACTIVE);
		}
		
		allocation.setStatus(AllocationStatus.CANCELED.code());
		
		allocationRepository.save(allocation);
		
		return 0;

	}
	
	/**
	 * Efetua o encerramento da alocação de um veículo.
	 * 
	 * @param request - Objeto com os dados da alocação.
	 * 
	 * @return - Resultado da operação.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	@Override
	@Transactional
	public Integer terminateAllocation(AllocationRequestDTO request) throws ServiceException {
		
		if (null == request.getIdAllocation() ||
			request.getIdAllocation() == 0) {
			throw serviceException(AppMessages.ALLOCATION_ID_NOT_INFORMED);
		}

		if (request.getIdAllocation() < 0) {
			throw serviceException(AppMessages.INVALID_ALLOCATION_ID);
		}
		
		Optional<Allocation> allocationDb = 
				allocationRepository.findById(request.getIdAllocation());

		if (null == allocationDb || !allocationDb.isPresent()) {
			throw serviceException(AppMessages.ALLOCATION_NOT_FOUND);
		}
		
		Allocation allocation = allocationDb.get();

		if (!allocation.getStatus().equals(AllocationStatus.ACTIVE.code())) {
			throw serviceException(AppMessages.ALLOCATION_NOT_ACTIVE);
		}
		
		allocation.setStatus(AllocationStatus.TERMINATED.code());
		
		allocationRepository.save(allocation);
		
		return 0;

	}
	
	/**
	 * Retorna a lista de alocações ativas.
	 * 
	 * @return - Lista de alocações.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	@Override
	public List<Allocation> listActivies() throws ServiceException {

		return listByStatus(AllocationStatus.ACTIVE.code());
		
	}
	
	/**
	 * Retorna a lista de alocações a partir do status informado.
	 * 
	 * @param status - Status para pesquisa das alocações.
	 * 
	 * @return - Lista de alocações.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */

	@Override
	public List<Allocation> listByStatus(String status) throws ServiceException {
		
		if (null == status || status.trim().isEmpty()) {
			throw serviceException(AppMessages.ALLOCATION_STATUS_NOT_INFORMED);
		}

		if (!status.equals(AllocationStatus.ACTIVE.code()) && 
			!status.equals(AllocationStatus.CANCELED.code()) &&
			!status.equals(AllocationStatus.EXPIRED.code()) &&
			!status.equals(AllocationStatus.TERMINATED.code())) {
			throw serviceException(AppMessages.INVALID_ALLOCATION_STATUS);
		}
		
		List<Allocation> allocations = allocationRepository.findAllByStatus(status);
		
		return allocations;
		
	}
	
	/**
	 * Efetua o cálculo dos dias restantes por cliente.
	 * 
	 * @return - Resultado da operação.
	 * 
	 * @throws ServiceException - Exceção da camada de negócios.
	 */
	
	@Override
	public Integer calculateRemainingDays() throws ServiceException {
		
		try {
			
			List<Allocation> allocations = allocationRepository.findAllByStatus("A");
			
			for (Allocation allocation: allocations) {
			
				Long remains = ChronoUnit.DAYS.between(
						allocation.getStartDate().toInstant(), allocation.getEndDate().toInstant());
				
				RemainingDays remainingDays = new RemainingDays();
				
				BeanUtils.copyProperties(allocation, remainingDays);
				remainingDays.setId(null);
				remainingDays.setIdAllocation(allocation.getId());
				remainingDays.setRemainingDays(remains);
				remainingDays.setCreatedAt(null);
				remainingDays.setUpdatedAt(null);
				
				remainingDaysDAO.persist(remainingDays);
				
			}
		
		} catch (DAOException ex) {
			
			throw serviceException(AppMessages.UNKNOWN_ERROR);
			
		}

		return 0;
		
	}

}
