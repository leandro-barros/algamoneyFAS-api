package com.algamoneyFAS.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algamoneyFAS.api.event.RecursoCriadoEvent;
import com.algamoneyFAS.api.model.Categoria;
import com.algamoneyFAS.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

//	// Somente esta url pode fazer requisão get para a api
//	@CrossOrigin(maxAge = 10, origins = { "http://localhost:8000" })
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	// Se caso não houver categoria, retorna status 204, afirmando que não há conteudo
//	@GetMapping
//	public ResponseEntity<?> listar() {
//		List<Categoria> categorias = categoriaRepository.findAll();
//		return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
//	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		// Retorna no Headers a URL de da categoria salva com o ID
//	    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
//		.buildAndExpand(categoriaSalva.getId()).toUri();
//	    response.setHeader("Location", uri.toASCIIString());
//	    
		//Este código seria o mesmo comentado acima, porém mais limpo, com eventos criado.
		publisher.publishEvent( new RecursoCriadoEvent(this, response, categoriaSalva.getId()));
	    return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public ResponseEntity<Categoria> buscarPorCodigo(@PathVariable Long codigo) {
		Categoria recebeCodigo = categoriaRepository.findOne(codigo);
		return recebeCodigo != null ? ResponseEntity.ok(recebeCodigo) : ResponseEntity.notFound().build();
	}

}
