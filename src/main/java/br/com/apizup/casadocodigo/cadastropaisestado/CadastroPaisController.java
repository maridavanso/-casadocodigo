package br.com.apizup.casadocodigo.cadastropaisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroPaisController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/paises")
	@Transactional
	public String cria (@Valid @RequestBody NovoPaisRequest request) {
		Pais novoPais = new Pais(request.getNome());
		manager.persist(novoPais);
		return novoPais.toString();
	}
}
