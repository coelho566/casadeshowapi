package br.com.gft.casadeshowapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.gft.casadeshowapi.domain.House;
import br.com.gft.casadeshowapi.exception.HouseExistenteException;
import br.com.gft.casadeshowapi.exception.HouseNaoExisteException;
import br.com.gft.casadeshowapi.repository.HouseRepository;

@Service
public class HouseService {
	
	@Autowired
	private HouseRepository houseRepository;
	
	public Page<House> listar(Pageable pageable){
		
		Page<House> house = houseRepository.findAll(pageable);
		
		return house;
	}
	
	public House salvar(House house) {
		
		if(house.getId() != null) {
			
			Optional<House> casa = houseRepository.findById(house.getId());
			
			if(casa.isPresent()) {
				throw new HouseExistenteException("Casa de show já existe");
			}	
		}
		
		return houseRepository.save(house);
		
	}
	
	public House buscar(Long id) {
		
		Optional<House> casa = houseRepository.findById(id);
		
		if(casa.isPresent()) {
			return casa.get();
		}else {
			throw new HouseNaoExisteException("Casa de show não existe");
		}
	}
	
	public void atulizar(House house) {
		this.buscar(house.getId());
		houseRepository.save(house);
	}
	
	public House buscarNome(String nome) {
		
		if(nome != null) {
			return houseRepository.findByName(nome);
		}else {
			throw new HouseNaoExisteException("Casa de show não existe");
		}
		
	}
	
	public List<House> buscarAsc(){
		return houseRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
	
	public List<House> buscarDesc(){
		return houseRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
	}
	
	public void delete(Long id) {
		
		try {
			houseRepository.delete(buscar(id));
		} catch (NoSuchFieldError e) {
			throw new HouseNaoExisteException("Casa de show não existe");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
