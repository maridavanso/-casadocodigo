package br.com.apizup.casadocodigo.cadastropaisestado;

import javax.persistence.EntityManager;

import com.sun.istack.NotNull;

import br.com.apizup.casadocodigo.compartilhado.UnicoValor;

public class NovoPaisRequest {

	@NotNull
	@UnicoValor(domainClass = Pais.class, fieldName = "nome")
	private String nome;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
