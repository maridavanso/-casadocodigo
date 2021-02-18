package br.com.apizup.casadocodigo.novoautor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

/*import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;*/
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoAutorController {
	
	@PersistenceContext
	private EntityManager manager;
	
	/*
	 * @Autowired private AnulaEmailDuplicadoValidator anulaEmailDuplicadoValidator;
	 * 
	 * @InitBinder public void init(WebDataBinder binder) {
	 * binder.addValidators(anulaEmailDuplicadoValidator); }
	 */
	
	@PostMapping(value = "/autores")
	@Transactional
	public String cria(@Valid @RequestBody NovoAutorRequest request ) {
		Autor autor = request.toModel();
		manager.persist(autor);
		return autor.toString();
	}
}
