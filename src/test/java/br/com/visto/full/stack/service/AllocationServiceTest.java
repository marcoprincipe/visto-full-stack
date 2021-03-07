package br.com.visto.full.stack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.visto.full.stack.enums.AllocationStatus;
import br.com.visto.full.stack.enums.AppMessages;
import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Allocation;
import br.com.visto.full.stack.repository.AllocationRepository;

/**
 * Classe para testes dos serviços de alocações.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@SpringBootTest
public class AllocationServiceTest {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@MockBean
	private AllocationRepository allocationRepository;
	
	private AllocationService allocationService;
	
	private static List<Allocation> allocations;

	/**
	 * Construtor default da classe.
	 * 
	 * @param allocationService - Instância dos serviços de alocações.
	 */
	
	@Autowired
	public AllocationServiceTest(AllocationService allocationService) {
		this.allocationService = allocationService;
	}
	
	/**
	 * Configura a classe para utilização.
	 */
	
	@BeforeAll
	public static void setUp() {
		
		allocations = new ArrayList<Allocation>();
		
		allocations.add(new Allocation(1L, 1L, 1L, Calendar.getInstance(), Calendar.getInstance(), "A", Calendar.getInstance(), Calendar.getInstance()));
		
	}
	
	/**
	 * Retorna todas as alocações ativas.
	 */
	
	@Test
	public void find_all_activies_allocations() {
		
		List<Allocation> activies = 
				allocations.stream().filter(P -> P.getStatus() == AllocationStatus.ACTIVE.code()).collect(Collectors.toList());
		
		try {
			
			Mockito.when(allocationRepository.findAllByStatus(AllocationStatus.ACTIVE.code())).thenReturn(activies);
			
			List<Allocation> result = allocationService.listActivies();
			
			assertEquals(activies.size(), result.size());
			
		} 
		catch (ServiceException ex) {
			
			ex.printStackTrace();
			
		}
		
	}
	
	/**
	 * Lança a exceção quando o status da alocação é nulo.
	 */
	
	@Test
	public void throw_serviceexception_when_status_is_null() {
		
		try {
			
			Mockito.when(allocationRepository.findAllByStatus(null)).thenReturn(allocations);
			
			allocationService.listByStatus(null);
			
		} 
		catch (ServiceException ex) {
			
			assertEquals(AppMessages.ALLOCATION_STATUS_NOT_INFORMED.code(), ex.getCode());
			
		}
		
	}
	
	/**
	 * Lança a exceção quando o status da alocação é vazio.
	 */
	
	@Test
	public void throw_serviceexception_when_status_is_empty() {
		
		try {
			
			Mockito.when(allocationRepository.findAllByStatus(null)).thenReturn(allocations);
			
			allocationService.listByStatus("");
			
		} 
		catch (ServiceException ex) {
			
			assertEquals(AppMessages.ALLOCATION_STATUS_NOT_INFORMED.code(), ex.getCode());
			
		}
		
	}
	
	/**
	 * Lança a exceção quando o status da alocação é inválido.
	 */
	
	@Test
	public void throw_serviceexception_when_status_is_invalid() {
		
		try {
			
			Mockito.when(allocationRepository.findAllByStatus(null)).thenReturn(allocations);
			
			allocationService.listByStatus("X");
			
		} 
		catch (ServiceException ex) {
			
			assertEquals(AppMessages.INVALID_ALLOCATION_STATUS.code(), ex.getCode());
			
		}
		
	}

}
