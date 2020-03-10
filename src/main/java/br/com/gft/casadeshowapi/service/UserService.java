package br.com.gft.casadeshowapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.casadeshowapi.domain.User;
import br.com.gft.casadeshowapi.exception.UserNaoExisteException;
import br.com.gft.casadeshowapi.repository.UserRepository;

@Service	
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> listar(){
		return userRepository.findAll();
	}
	
	public User buscar(Long id) {
		Optional<User> usuario = userRepository.findById(id);
		
		if(usuario.isPresent()) {
			return usuario.get();
		}else {
			throw new UserNaoExisteException("Usuario não existe");
		}
	}
}
