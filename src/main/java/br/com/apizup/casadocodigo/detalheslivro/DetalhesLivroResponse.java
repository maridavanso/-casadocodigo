package br.com.apizup.casadocodigo.detalheslivro;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.TituloEleitoral;

import br.com.apizup.casadocodigo.cadastrolivro.Livro;
import br.com.apizup.casadocodigo.novoautor.Autor;

public class DetalhesLivroResponse {

	private String titulo;
	private DetalheAutorResponse autor;
	private String isbn;
	private int numeroPaginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;

	public DetalhesLivroResponse(Livro livro) {
		titulo = livro.getTitulo();
		autor = new DetalheAutorResponse(livro.getAutor());
		isbn = livro.getIsbn();
		numeroPaginas = livro.getNumeroPaginas();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		
	}

	public String getTitulo() {
		return titulo;
	}

	public DetalheAutorResponse getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}


	
}
