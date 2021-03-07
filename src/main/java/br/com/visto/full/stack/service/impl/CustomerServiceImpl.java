package br.com.visto.full.stack.service.impl;

import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visto.full.stack.enums.AppMessages;
import br.com.visto.full.stack.enums.Status;
import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Customer;
import br.com.visto.full.stack.repository.CustomerRepository;
import br.com.visto.full.stack.service.CustomerService;

/**
 * Implementação da interface dos serviços de clientes.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Service
public class CustomerServiceImpl extends BaseService implements CustomerService {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private CustomerRepository customerRepository;

	/**
	 * Construtor default da classe.
	 */
	
	public CustomerServiceImpl() {
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param customerRepository - Instância do repositório de clientes.
	 * @param resourceBundle - Instância da classe ResourceBundle.
	 */
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, ResourceBundle resourceBundle) {
		super(resourceBundle);
		this.customerRepository = customerRepository;
	}
	
	/**
	 * Retorna a lista de clientes ativos.
	 * 
	 * @return - Lista de clientes.
	 * 
	 * @throws ServiceException
	 */
	
	@Override
	public List<Customer> listActivies() throws ServiceException {

		return listByStatus(Status.ACTIVE.code());
		
	}
	
	/**
	 * Retorna a lista de clientes a partir do status informado.
	 * 
	 * @param status - Status para pesquisa dos clientes.
	 * 
	 * @return - Lista de clientes.
	 * 
	 * @throws ServiceException
	 */
	
	@Override
	public List<Customer> listByStatus(String status) throws ServiceException {
		
		if (null == status || status.trim().isEmpty()) {
			throw serviceException(AppMessages.CUSTOMER_STATUS_NOT_INFORMED);
		}

		if (!status.equals(Status.ACTIVE.code()) && 
			!status.equals(Status.INACTIVE.code())) {
			throw serviceException(AppMessages.INVALID_CUSTOMER_STATUS);
		}
		
		List<Customer> customers = customerRepository.findAllByStatus(status);
		
		return customers;
		
	}

}
