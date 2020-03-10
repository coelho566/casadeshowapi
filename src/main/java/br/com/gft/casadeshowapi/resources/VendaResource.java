package br.com.gft.casadeshowapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.casadeshowapi.domain.Venda;
import br.com.gft.casadeshowapi.service.VendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Vendas")
@RestController
@RequestMapping("/api/vendas")
public class VendaResource {
	
	@Autowired
	private VendaService vendaService;
	
	@ApiOperation("Listar todas as vendas.")
	@GetMapping
	public ResponseEntity<Page<Venda>> listar(@PageableDefault(sort="id", direction = Direction.DESC, page = 0, size = 4) Pageable pageable){
		
		Page<Venda> vendas = vendaService.listar(pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(vendas);
	}
	
	@ApiOperation("Lista uma venda por ID.")
	@GetMapping("/{id}")
	public ResponseEntity<Venda> buscar(@PathVariable("id") Long id){
		
		Venda venda = vendaService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(venda);
	}
}
