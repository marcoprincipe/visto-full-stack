package br.com.visto.full.stack.dao.impl;

import java.text.SimpleDateFormat;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.visto.full.stack.dao.RemainingDaysDAO;
import br.com.visto.full.stack.dto.RemainingDaysDTO;
import br.com.visto.full.stack.exception.DAOException;
import br.com.visto.full.stack.model.RemainingDays;

/**
 * Implementação da interface dos DAOs de dias restantes de alocação.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Component
public class RemainingDaysDAOImpl implements RemainingDaysDAO {
	
	/**
	 * Declaração das variáveis membro.
	 */

	private RabbitTemplate rabbitTemplate;
	
	private Queue queue;
	
	/**
	 * Construtor default da classe.
	 */
	
	public RemainingDaysDAOImpl() {
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param rabbitTemplate - Template para utilização do RabbitMQ
	 */
	
	@Autowired
	public RemainingDaysDAOImpl(RabbitTemplate rabbitTemplate, Queue queue) {
		this.rabbitTemplate = rabbitTemplate;
		this.queue = queue;
	}
	
	/**
	 * Efetua a gravação dos dados dos dias restantes.
	 * 
	 * @param entity - Objeto com os dados a seren persistidos.
	 * 
	 * @return - Objeto com os dados persistidos.
	 * 
	 * @throws DAOException - Exceção da camada de integração
	 */
	
	@Override
	public RemainingDays persist(RemainingDays entity) throws DAOException {
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			RemainingDaysDTO remainingDaysDTO = new RemainingDaysDTO();
			remainingDaysDTO.setIdAllocation(entity.getIdAllocation());
			remainingDaysDTO.setIdCustomer(entity.getIdCustomer());
			remainingDaysDTO.setStartDate(sdf.format(entity.getStartDate().getTime()));
			remainingDaysDTO.setEndDate(sdf.format(entity.getEndDate().getTime()));
			remainingDaysDTO.setRemainingDays(entity.getRemainingDays());
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(remainingDaysDTO);
			
			rabbitTemplate.convertAndSend(queue.getName(), json);
			
		} 
		catch (JsonProcessingException ex) {
			
			throw new DAOException(ex.getMessage());

		}
		
		return entity;
		
	}

}
