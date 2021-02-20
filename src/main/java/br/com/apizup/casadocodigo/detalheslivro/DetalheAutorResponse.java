package br.com.apizup.casadocodigo.detalheslivro;

import br.com.apizup.casadocodigo.novoautor.Autor;

public class DetalheAutorResponse {

	private String nome;
	private String descricao;

	public DetalheAutorResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
