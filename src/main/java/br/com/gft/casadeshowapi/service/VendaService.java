package br.com.gft.casadeshowapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gft.casadeshowapi.domain.Venda;
import br.com.gft.casadeshowapi.exception.VendaNaoExisteException;
import br.com.gft.casadeshowapi.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public Page<Venda> listar(Pageable pageable){
		
		Page<Venda> venda = vendaRepository.findAll(pageable);
		
		return venda;
	}
	
	public Venda buscar(Long id) {
		Optional<Venda> venda = vendaRepository.findById(id);
		
		if(venda.isPresent()) {
			return venda.get();
		}else {
			throw new VendaNaoExisteException("Venda não existe");
		}
	}
}
