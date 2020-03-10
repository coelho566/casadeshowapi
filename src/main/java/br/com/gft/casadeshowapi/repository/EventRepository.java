package br.com.gft.casadeshowapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gft.casadeshowapi.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	Event findByName(String name);	
}
