package br.com.visto.full.stack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Customer;
import br.com.visto.full.stack.rest.RestResponse;
import br.com.visto.full.stack.service.CustomerService;

/**
 * Controller para acesso aos serviços de clientes.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private CustomerService customerService;

	/**
	 * Construtor default da classe.
	 */
	
	public CustomerController() {
	}

	/**
	 * Construtor default da classe.
	 * 
	 * @param customerService - Instância da classe de serviços de clientes.
	 */
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	/**
	 * Retorna a lista de todos os clientes ativos.
	 * 
	 * @return - Lista de clientes ativos.
	 */
	
	@CrossOrigin
	@RequestMapping(path = "/list-activies", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<List<Customer>>> listActivies() {
		
		ResponseEntity<RestResponse<List<Customer>>> response = null;
		RestResponse<List<Customer>> restResponse = null;
		
		try {
			
			List<Customer> result = customerService.listActivies();
			
			restResponse = new RestResponse<List<Customer>>(result);
			
			response = new ResponseEntity<RestResponse<List<Customer>>>(restResponse, HttpStatus.OK);
			
		} 
		catch (ServiceException ex) {
			
			restResponse = new RestResponse<List<Customer>>(ex.getCode(), ex.getMessage(), null);

			response = new ResponseEntity<RestResponse<List<Customer>>>(restResponse, HttpStatus.BAD_REQUEST);

		}

		return response;
		
	}

}
