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
import br.com.visto.full.stack.model.Vehicle;
import br.com.visto.full.stack.rest.RestResponse;
import br.com.visto.full.stack.service.VehicleService;

/**
 * Controller para acesso aos serviços de veículos.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@RestController
@RequestMapping(path = "/vehicles")
public class VehicleController {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private VehicleService vehicleService;

	/**
	 * Construtor default da classe.
	 */
	
	public VehicleController() {
	}

	/**
	 * Construtor default da classe.
	 * 
	 * @param vehicleService - Instância da classe de serviços de veículos.
	 */
	
	@Autowired
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	/**
	 * Retorna a lista de todos os veículos ativos.
	 * 
	 * @return - Lista de veículos ativos.
	 */
	
	@CrossOrigin
	@RequestMapping(path = "/list-activies", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<List<Vehicle>>> listActivies() {
		
		ResponseEntity<RestResponse<List<Vehicle>>> response = null;
		RestResponse<List<Vehicle>> restResponse = null;
		
		try {
			
			List<Vehicle> result = vehicleService.listActivies();
			
			restResponse = new RestResponse<List<Vehicle>>(result);
			
			response = new ResponseEntity<RestResponse<List<Vehicle>>>(restResponse, HttpStatus.OK);
			
		} 
		catch (ServiceException ex) {
			
			restResponse = new RestResponse<List<Vehicle>>(ex.getCode(), ex.getMessage(), null);

			response = new ResponseEntity<RestResponse<List<Vehicle>>>(restResponse, HttpStatus.BAD_REQUEST);

		}

		return response;
		
	}

}
