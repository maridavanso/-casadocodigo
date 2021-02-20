package br.com.apizup.casadocodigo.cadastropaisestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.apizup.casadocodigo.compartilhado.ExisteId;
import br.com.apizup.casadocodigo.compartilhado.UnicoValor;

public class NovoEstadoRequest {
	
	@NotBlank
	@UnicoValor(domainClass = Estado.class,fieldName = "nome")
	private String nome;
	@NotNull
	@ExisteId(domainClass = Pais.class,fieldName = "id")
	private Long idPais;
	
	public NovoEstadoRequest(String nome, Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	@Override
	public String toString() {
		return "NovoEstadoRequest [nome=" + nome + ", idPais=" + idPais + "]";
	}

	public Estado toModel(EntityManager manager) {
		
		 return new Estado(nome, manager.find(Pais.class, idPais));  
	}

	
}
