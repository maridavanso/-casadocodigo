package br.com.apizup.casadocodigo.fluxocompra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.apizup.casadocodigo.cadastrocategoria.Categoria;

@RestController
public class CadastroClienteController {

	@PersistenceContext
	private EntityManager manager;
	
	
	
	@PostMapping(value = "/clientes")
	@Transactional
	public String cria(@RequestBody @Valid NovoClienteRequest request) {
		
		Cliente novoCliente = request.toModel(manager);
		manager.persist(novoCliente);
		
		return novoCliente.toString();
	}
}
