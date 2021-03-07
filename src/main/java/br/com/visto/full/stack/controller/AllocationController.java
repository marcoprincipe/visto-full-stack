package br.com.visto.full.stack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.visto.full.stack.dto.AllocationRequestDTO;
import br.com.visto.full.stack.exception.ServiceException;
import br.com.visto.full.stack.model.Allocation;
import br.com.visto.full.stack.rest.RestResponse;
import br.com.visto.full.stack.service.AllocationService;

/**
 * Controller para acesso aos serviços de alocações.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private AllocationService allocationService;

	/**
	 * Construtor default da classe.
	 */
	
	public AllocationController() {
	}

	/**
	 * Construtor default da classe.
	 * 
	 * @param allocationService - Instância da classe de serviços de alocações.
	 */
	
	@Autowired
	public AllocationController(AllocationService allocationService) {
		this.allocationService = allocationService;
	}
	
	/**
	 * Efetua a alocação de um veículo.
	 * 
	 * @return - Resultado da operação.
	 */
	
	@CrossOrigin
	@RequestMapping(path = "/do-allocation", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> doAllocation(@RequestBody AllocationRequestDTO request) {
		
		ResponseEntity<RestResponse<Integer>> response = null;
		RestResponse<Integer> restResponse = null;
		
		try {
			
			Integer result = allocationService.doAllocation(request);
			
			restResponse = new RestResponse<Integer>(result);
			
			response = new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
			
		} 
		catch (ServiceException ex) {
			
			restResponse = new RestResponse<Integer>(ex.getCode(), ex.getMessage(), null);

			response = new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.BAD_REQUEST);

		}

		return response;
		
	}
	
	/**
	 * Efetua o cancelamento de um alocação.
	 * 
	 * @return - Resultado da operação.
	 */
	
	@CrossOrigin
	@RequestMapping(path = "/cancel-allocation", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> cancelAllocation(@RequestBody AllocationRequestDTO request) {
		
		ResponseEntity<RestResponse<Integer>> response = null;
		RestResponse<Integer> restResponse = null;
		
		try {
			
			Integer result = allocationService.cancelAllocation(request);
			
			restResponse = new RestResponse<Integer>(result);
			
			response = new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
			
		} 
		catch (ServiceException ex) {
			
			restResponse = new RestResponse<Integer>(ex.getCode(), ex.getMessage(), null);

			response = new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.BAD_REQUEST);

		}

		return response;
		
	}
	
	/**
	 * Efetua o encerramento de um alocação.
	 * 
	 * @return - Resultado da operação.
	 */
	
	@CrossOrigin
	@RequestMapping(path = "/terminate-allocation", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> terminateAllocation(@RequestBody AllocationRequestDTO request) {
		
		ResponseEntity<RestResponse<Integer>> response = null;
		RestResponse<Integer> restResponse = null;
		
		try {
			
			Integer result = allocationService.terminateAllocation(request);
			
			restResponse = new RestResponse<Integer>(result);
			
			response = new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
			
		} 
		catch (ServiceException ex) {
			
			restResponse = new RestResponse<Integer>(ex.getCode(), ex.getMessage(), null);

			response = new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.BAD_REQUEST);

		}

		return response;
		
	}
	
	/**
	 * Retorna a lista de todas as alocações ativas.
	 * 
	 * @return - Lista de alocações ativas.
	 */
	
	@CrossOrigin
	@RequestMapping(path = "/list-activies", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<List<Allocation>>> listActivies() {
		
		ResponseEntity<RestResponse<List<Allocation>>> response = null;
		RestResponse<List<Allocation>> restResponse = null;
		
		try {
			
			List<Allocation> result = allocationService.listActivies();
			
			restResponse = new RestResponse<List<Allocation>>(result);
			
			response = new ResponseEntity<RestResponse<List<Allocation>>>(restResponse, HttpStatus.OK);
			
		} 
		catch (ServiceException ex) {
			
			restResponse = new RestResponse<List<Allocation>>(ex.getCode(), ex.getMessage(), null);

			response = new ResponseEntity<RestResponse<List<Allocation>>>(restResponse, HttpStatus.BAD_REQUEST);

		}

		return response;
		
	}
	
	/**
	 * Retorna a lista de todas as alocações ativas.
	 * 
	 * @return - Lista de alocações ativas.
	 */
	
	@CrossOrigin
	@RequestMapping(path = "/calculate-remaining-days", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> calculateRainingDays() {
		
		ResponseEntity<RestResponse<Integer>> response = null;
		RestResponse<Integer> restResponse = null;
		
		try {
			
			Integer result = allocationService.calculateRemainingDays();
			
			restResponse = new RestResponse<Integer>(result);
			
			response = new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
			
		} 
		catch (ServiceException ex) {
			
			restResponse = new RestResponse<Integer>(ex.getCode(), ex.getMessage(), null);

			response = new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.BAD_REQUEST);

		}

		return response;
		
	}

}
