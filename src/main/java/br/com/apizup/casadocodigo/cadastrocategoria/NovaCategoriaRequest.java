package br.com.apizup.casadocodigo.cadastrocategoria;

import javax.validation.constraints.NotBlank;

import br.com.apizup.casadocodigo.compartilhado.UnicoValor;

public class NovaCategoriaRequest {

	@NotBlank
	@UnicoValor(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
	
		this.nome = nome;
	}

	public String getNome() {
		
		return nome;
	}
	
	
}
