package br.com.gft.casadeshowapi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gft.casadeshowapi.domain.House;
import br.com.gft.casadeshowapi.service.HouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Casas")
@RestController
@RequestMapping("/api/casas")
public class HouseResource {
	
	@Autowired
	private HouseService houseService;
	
	@ApiOperation("Listar todas as casas de show.")
	@GetMapping
	public ResponseEntity <Page<House>> lista(@PageableDefault(sort="id", direction = Direction.ASC, page = 0, size = 4) Pageable paginacao){
		
		Page<House> casa = houseService.listar(paginacao);
		return ResponseEntity.status(HttpStatus.OK).body(casa);
	}
	
	@ApiOperation("Inserir casa de show.")
	@PostMapping
	public ResponseEntity<?> salvar(@ApiParam(name="Corpo",value="Representação de uma nova casa de show") @Valid @RequestBody House house){
		
		house = houseService.salvar(house);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{id}").buildAndExpand(house.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@ApiOperation("Buscar por ID.")
	@GetMapping("/{id}")
	public ResponseEntity<House> buscar(@PathVariable("id") Long id){
		House house = houseService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(house);
	}
	
	@ApiOperation("Atualizar casa de show")
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@ApiParam(name="Corpo",value="Representação de uma casa de show com novos dados")  @Valid @RequestBody House house,@ApiParam(value="ID de uma casa",example = "1") @PathVariable("id")Long id){
		house.setId(id);
		
		houseService.atulizar(house);
		
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Deleta uma casa de show.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@ApiParam(value="ID de Uma cidade",example = "1") @PathVariable("id") Long id){
		
		houseService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Busca casa pelo nome.")
	@GetMapping("/nome/{nome}")
	public ResponseEntity <House> buscaNome(@ApiParam(value="Nome de uma casa de show") @PathVariable String nome){
		
		House house = houseService.buscarNome(nome);
		
		return ResponseEntity.status(HttpStatus.OK).body(house);
	}
	
	@ApiOperation("Listar as casas em ordem alfabética crescente por nome.")
	@GetMapping("/asc")
	public ResponseEntity <List<House>> buscaAsc(){
		
		List<House> house = houseService.buscarAsc();
		
		return ResponseEntity.status(HttpStatus.OK).body(house);
	}
	
	@ApiOperation("Listar as casas em ordem alfabética decrescente por nome.")
	@GetMapping("/desc")
	public ResponseEntity <List<House>> buscaDesc(){
		
		List<House> house = houseService.buscarDesc();
		
		return ResponseEntity.status(HttpStatus.OK).body(house);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
