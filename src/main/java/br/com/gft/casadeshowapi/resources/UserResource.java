package br.com.gft.casadeshowapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.casadeshowapi.domain.User;
import br.com.gft.casadeshowapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Usuários")
@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation("Listar todos os usuários")
	@GetMapping
	public ResponseEntity <List<User>> listar(){
		List<User> users = userService.listar();
		
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@ApiOperation("Lista o usuário pelo ID.")
	@GetMapping("/{id}")
	public ResponseEntity<User> buscar(@PathVariable("id") Long id){
		User user = userService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
}
