package br.com.apizup.casadocodigo.cadastropaisestado;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroEstadoController {

	@Autowired
	private EntityManager manager;
	
	@PostMapping(value = "/estados")
	@Transactional
	public String cria(@Valid @RequestBody NovoEstadoRequest request) {
		Estado novoEstado = request.toModel(manager);
		manager.persist(novoEstado);
		return novoEstado.toString();
	}
	
}
