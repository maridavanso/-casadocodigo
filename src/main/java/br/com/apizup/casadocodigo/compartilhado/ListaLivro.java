package br.com.apizup.casadocodigo.compartilhado;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ListaLivro {

	@PersistenceContext
	private EntityManager manager;
	
	/*
	 * @GetMapping(value = "/lista-livros") public HashMap<String, Object> list(){
	 * 
	 * List livros = manager.createQuery("select a from Livro a").getResultList();
	 * 
	 * HashMap<String, Object> resultado = new HashMap<>(); resultado.put("livros",
	 * livros.toString());
	 * 
	 * return resultado; }
	 */
	
	@GetMapping(value = "/lista-livros")
	public HashMap<String, Object> list(){
		
		List livros = manager.createQuery("select a from Livro a").getResultList();
				HashMap<String, Object> resultado = new HashMap<>();
				resultado .put("livros", livros.toString());
		
		return resultado;
	}
}
