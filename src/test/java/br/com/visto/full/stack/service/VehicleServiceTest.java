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
import br.com.visto.full.stack.model.Vehicle;
import br.com.visto.full.stack.repository.VehicleRepository;

/**
 * Classe para testes dos serviços de veículos.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@SpringBootTest
public class VehicleServiceTest {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@MockBean
	private VehicleRepository vehicleRepository;
	
	private VehicleService vehicleService;
	
	private static List<Vehicle> vehicles;

	/**
	 * Construtor default da classe.
	 * 
	 * @param vehicleService - Instância dos serviços de veículos.
	 */
	
	@Autowired
	public VehicleServiceTest(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	/**
	 * Configura a classe para utilização.
	 */
	
	@BeforeAll
	public static void setUp() {
		
		vehicles = new ArrayList<Vehicle>();
		
		vehicles.add(new Vehicle(1L, "AAA-1111", "VolksWagen", "Fusca 1964", "A", new Date(), new Date()));
		vehicles.add(new Vehicle(2L, "BBB-2222", "VolksWagen", "Fusca 1965", "A", new Date(), new Date()));
		vehicles.add(new Vehicle(3L, "CCC-3333", "VolksWagen", "Fusca 1966", "A", new Date(), new Date()));
		vehicles.add(new Vehicle(4L, "DDD-4444", "VolksWagen", "Fusca 1967", "A", new Date(), new Date()));
		vehicles.add(new Vehicle(5L, "EEE-5555", "VolksWagen", "Fusca 1968", "A", new Date(), new Date()));
		
	}
	
	/**
	 * Retorna todos os veículos ativos.
	 */
	
	@Test
	public void find_all_activies_vehicles() {
		
		List<Vehicle> activies = 
				vehicles.stream().filter(P -> P.getStatus() == Status.ACTIVE.code()).collect(Collectors.toList());
		
		try {
			
			Mockito.when(vehicleRepository.findAllByStatus("A")).thenReturn(activies);
			
			List<Vehicle> result = vehicleService.listActivies();
			
			assertEquals(activies.size(), result.size());
			
		} 
		catch (ServiceException ex) {
			
			ex.printStackTrace();
			
		}
		
	}
	
	/**
	 * Lança a exceção quando o status do veículo é nulo.
	 */
	
	@Test
	public void throw_serviceexception_when_status_is_null() {
		
		try {
			
			Mockito.when(vehicleRepository.findAllByStatus(null)).thenReturn(vehicles);
			
			vehicleService.listByStatus(null);
			
		} 
		catch (ServiceException ex) {
			
			assertEquals(AppMessages.VEHICLE_STATUS_NOT_INFORMED.code(), ex.getCode());
			
		}
		
	}
	
	/**
	 * Lança a exceção quando o status do veículo é vazio.
	 */
	
	@Test
	public void throw_serviceexception_when_status_is_empty() {
		
		try {
			
			Mockito.when(vehicleRepository.findAllByStatus(null)).thenReturn(vehicles);
			
			vehicleService.listByStatus("");
			
		} 
		catch (ServiceException ex) {
			
			assertEquals(AppMessages.VEHICLE_STATUS_NOT_INFORMED.code(), ex.getCode());
			
		}
		
	}
	
	/**
	 * Lança a exceção quando o status do veículo é inválido.
	 */
	
	@Test
	public void throw_serviceexception_when_status_is_invalid() {
		
		try {
			
			Mockito.when(vehicleRepository.findAllByStatus(null)).thenReturn(vehicles);
			
			vehicleService.listByStatus("X");
			
		} 
		catch (ServiceException ex) {
			
			assertEquals(AppMessages.INVALID_VEHICLE_STATUS.code(), ex.getCode());
			
		}
		
	}

}
