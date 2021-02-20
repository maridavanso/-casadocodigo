package br.com.apizup.casadocodigo.detalheslivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.apizup.casadocodigo.cadastrolivro.Livro;

@RestController
public class DetalhesLivroController {

	@PersistenceContext
	private EntityManager manager;

	
	@GetMapping(value = "/produtos/{id}")
	public ResponseEntity<?> detalhe (@PathVariable("id") Long id) {
		
		Livro livroBuscado = manager.find(Livro.class, id);
		if(livroBuscado == null) {
			return ResponseEntity.notFound().build();
		}
		
		DetalhesLivroResponse DetalhesLivroResponse = new DetalhesLivroResponse(livroBuscado);
		return ResponseEntity.ok(DetalhesLivroResponse);
	}
}
