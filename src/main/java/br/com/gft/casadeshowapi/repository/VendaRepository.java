package br.com.gft.casadeshowapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gft.casadeshowapi.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
