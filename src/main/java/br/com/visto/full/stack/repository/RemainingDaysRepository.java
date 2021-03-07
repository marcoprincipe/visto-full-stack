package br.com.visto.full.stack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.visto.full.stack.model.RemainingDays;

/**
 * Repositório da tabela de dias restantes de alocações.
 * 
 * @author Marco Aurélio P. Gonçalves.
 */

@Repository
public interface RemainingDaysRepository extends JpaRepository<RemainingDays, Long> {
}