package br.com.visto.full.stack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.visto.full.stack.enums.AppMessages;
import br.com.visto.full.stack.enums.Status;
import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Customer;
import br.com.visto.full.stack.repository.CustomerRepository;

/**
 * Classe para testes dos serviços de clientes.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@SpringBootTest
public class CustomerServiceTest {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@MockBean
	private CustomerRepository customerRepository;
	
	private CustomerService customerService;
	
	private static List<Customer> customers;

	/**
	 * Construtor default da classe.
	 * 
	 * @param customerService - Instância dos serviços de clientes.
	 */
	
	@Autowired
	public CustomerServiceTest(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	/**
	 * Configura a classe para utilização.
	 */
	
	@BeforeAll
	public static void setUp() {
		
		customers = new ArrayList<Customer>();
		
		customers.add(new Customer(1L, 1L, "Cliente de Teste 001", "A", new Date(), new Date()));
		customers.add(new Customer(2L, 2L, "Cliente de Teste 002", "I", new Date(), new Date()));
		customers.add(new Customer(3L, 3L, "Cliente de Teste 003", "A", new Date(), new Date()));
		customers.add(new Customer(4L, 4L, "Cliente de Teste 004", "I", new Date(), new Date()));
		customers.add(new Customer(5L, 5L, "Cliente de Teste 005", "A", new Date(), new Date()));
		
	}
	
	/**
	 * Retorna todos os clientes ativos.
	 */
	
	@Test
	public void find_all_activies_customers() {
		
		List<Customer> activies = 
				customers.stream().filter(P -> P.getStatus() == Status.ACTIVE.code()).collect(Collectors.toList());
		
		try {
			
			Mockito.when(customerRepository.findAllByStatus("A")).thenReturn(activies);
			
			List<Customer> result = customerService.listActivies();
			
			assertEquals(activies.size(), result.size());
			
		} 
		catch (ServiceException ex) {
			
			ex.printStackTrace();
			
		}
		
	}
	
	/**
	 * Lança a exceção quando o status do cliente é nulo.
	 */
	
	@Test
	public void throw_serviceexception_when_status_is_null() {
		
		try {
			
			Mockito.when(customerRepository.findAllByStatus(null)).thenReturn(customers);
			
			customerService.listByStatus(null);
			
		} 
		catch (ServiceException ex) {
			
			assertEquals(AppMessages.CUSTOMER_STATUS_NOT_INFORMED.code(), ex.getCode());
			
		}
		
	}
	
	/**
	 * Lança a exceção quando o status do cliente é vazio.
	 */
	
	@Test
	public void throw_serviceexception_when_status_is_empty() {
		
		try {
			
			Mockito.when(customerRepository.findAllByStatus(null)).thenReturn(customers);
			
			customerService.listByStatus("");
			
		} 
		catch (ServiceException ex) {
			
			assertEquals(AppMessages.CUSTOMER_STATUS_NOT_INFORMED.code(), ex.getCode());
			
		}
		
	}
	
	/**
	 * Lança a exceção quando o status do cliente é inválido.
	 */
	
	@Test
	public void throw_serviceexception_when_status_is_invalid() {
		
		try {
			
			Mockito.when(customerRepository.findAllByStatus(null)).thenReturn(customers);
			
			customerService.listByStatus("X");
			
		} 
		catch (ServiceException ex) {
			
			assertEquals(AppMessages.INVALID_CUSTOMER_STATUS.code(), ex.getCode());
			
		}
		
	}

}
