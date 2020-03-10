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

import br.com.gft.casadeshowapi.domain.Event;
import br.com.gft.casadeshowapi.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Eventos")
@RestController
@RequestMapping("/api/eventos")
public class EventResource {
	
	@Autowired
	private EventService eventService;
	
	@ApiOperation("Lista todos os eventos.")
	@GetMapping
	public ResponseEntity <Page<Event>> listar(@PageableDefault(sort="id", direction = Direction.DESC, page = 0, size = 4) Pageable paginacao){
		
		Page<Event> event = eventService.listar(paginacao);
		return ResponseEntity.status(HttpStatus.OK).body(event);
	}
	
	@ApiOperation("Inserir evento.")
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Event event){
		 event = eventService.salvar(event);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(event.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Buscar evento por ID.")
	@GetMapping("/{id}")
	public ResponseEntity<Event> buscar(@PathVariable("id") Long id){
		
		Event event = eventService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(event);
		
	}
	
	@ApiOperation("Atualizar evento")
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Event event, @PathVariable("id") Long id){
		event.setId(id);
		eventService.atualizar(event);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Deleta uma evento")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		eventService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Listar os eventos em ordem alfabética crescente por nome.")
	@GetMapping("/nome/asc")
	public ResponseEntity <List<Event>> listaNomeAsc(){
		
		List<Event> event = eventService.buscarNomeAsc();
		
		return ResponseEntity.status(HttpStatus.OK).body(event);
	}
	
	@ApiOperation("Listar os eventos em ordem alfabética decrescente por nome.")
	@GetMapping("/nome/desc")
	public ResponseEntity <List<Event>> listaNomeDesc(){
		
		List<Event> event = eventService.buscarNomeDesc();
		
		return ResponseEntity.status(HttpStatus.OK).body(event);
	}
	
	@ApiOperation("Listar evento por capacidade em ordem crescente.")
	@GetMapping("/capacidade/asc")
	public ResponseEntity <List<Event>> listaCapacidadeAsc(){
		
		List<Event> event = eventService.buscarCapacidadeAsc();
		
		return ResponseEntity.status(HttpStatus.OK).body(event);
	}
	
	@ApiOperation("Listar evento por capacidade em ordem decresente.")
	@GetMapping("/capacidade/desc")
	public ResponseEntity <List<Event>> listaCapacidadeDesc(){
		
		List<Event> event = eventService.buscarCapacidadeDesc();
		return ResponseEntity.status(HttpStatus.OK).body(event);
	}
	
	@ApiOperation("Listar evento por data em ordem crescente.")
	@GetMapping("/data/asc")
	public ResponseEntity <List<Event>> listaDataAsc(){
		
		List<Event> event = eventService.buscarDataAsc();
		
		return ResponseEntity.status(HttpStatus.OK).body(event);
	}
	
	@ApiOperation("Listar evento por data em oredem decresente.")
	@GetMapping("/data/desc")
	public ResponseEntity <List<Event>> listaDataDesc(){
		
		List<Event> event = eventService.buscarDataDesc();
		
		return ResponseEntity.status(HttpStatus.OK).body(event);
	}
	
	@ApiOperation("Listar evento por preço em ordem crescente.")
	@GetMapping("/preco/asc")
	public ResponseEntity <List<Event>> listaPrecoAsc(){
		
		List<Event> event = eventService.buscarPrecoAsc();
		
		return ResponseEntity.status(HttpStatus.OK).body(event);
	}
	
	@ApiOperation("Listar evento por poço em ordem decrescente.")
	@GetMapping("/preco/desc")
	public ResponseEntity <List<Event>> listaPrecoDesc(){
		
		List<Event> event = eventService.buscarPrecoDesc();
		
		return ResponseEntity.status(HttpStatus.OK).body(event);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
