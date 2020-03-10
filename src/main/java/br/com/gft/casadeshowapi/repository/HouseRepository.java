package br.com.gft.casadeshowapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gft.casadeshowapi.domain.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
	
	House findByName(String name);	
}
