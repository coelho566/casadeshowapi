package br.com.gft.casadeshowapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.gft.casadeshowapi.domain.Event;
import br.com.gft.casadeshowapi.exception.EventNaoExisteException;
import br.com.gft.casadeshowapi.exception.HouseExistenteException;
import br.com.gft.casadeshowapi.exception.HouseNaoExisteException;
import br.com.gft.casadeshowapi.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public Page<Event> listar(Pageable pageable) {
		
		Page<Event> evento = eventRepository.findAll(pageable);
		
		return evento;
	}

	public boolean verificarExiste(String nome) {

		Event evento = eventRepository.findByName(nome);
		if (evento.getId() != null) {
			return true;
		} else {
			return false;
		}
	}

	public Event salvar(Event event) {

		if (event.getId() != null) {

			Optional<Event> evento = eventRepository.findById(event.getId());

			if (evento.isPresent()) {
				throw new HouseExistenteException("Casa de show já existe");
			}
		}

		return eventRepository.save(event);
	}

	public Event buscar(Long id) {
		Optional<Event> event = eventRepository.findById(id);

		if (event.isPresent()) {
			return event.get();
		} else {
			throw new EventNaoExisteException("Evento não existe");
		}
	}

	public void atualizar(Event event) {
		buscar(event.getId());
		eventRepository.save(event);
	}

	public void delete(Long id) {
		try {
			eventRepository.delete(buscar(id));
		} catch (NoSuchFieldError e) {
			throw new HouseNaoExisteException("Evento não existe");
		}
	}
	
	public List<Event> buscarNomeAsc(){
		return eventRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
	
	public List<Event> buscarNomeDesc(){
		return eventRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
	}
	
	public List<Event> buscarDataAsc(){
		return eventRepository.findAll(Sort.by(Sort.Direction.ASC, "dateEvent"));
	}
	
	public List<Event> buscarDataDesc(){
		return eventRepository.findAll(Sort.by(Sort.Direction.DESC, "dateEvent"));
	}
	
	public List<Event> buscarCapacidadeAsc(){
		return eventRepository.findAll(Sort.by(Sort.Direction.ASC, "capacity"));
	}
	
	public List<Event> buscarCapacidadeDesc(){
		return eventRepository.findAll(Sort.by(Sort.Direction.DESC, "capacity"));
	}
	
	public List<Event> buscarPrecoAsc(){
		return eventRepository.findAll(Sort.by(Sort.Direction.ASC, "preco"));
	}
	
	public List<Event> buscarPrecoDesc(){
		return eventRepository.findAll(Sort.by(Sort.Direction.DESC, "preco"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
