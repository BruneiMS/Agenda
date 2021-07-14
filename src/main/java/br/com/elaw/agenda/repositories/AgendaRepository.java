package br.com.elaw.agenda.repositories;

import org.springframework.data.repository.CrudRepository;
import br.com.elaw.agenda.entities.Agenda;

public interface AgendaRepository extends CrudRepository<Agenda, Integer> {

}
