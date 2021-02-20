package br.com.apizup.casadocodigo.fluxocompra;

import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import br.com.apizup.casadocodigo.cadastrocategoria.Categoria;
import br.com.apizup.casadocodigo.cadastrolivro.Livro;
import br.com.apizup.casadocodigo.cadastropaisestado.Estado;
import br.com.apizup.casadocodigo.cadastropaisestado.Pais;
import br.com.apizup.casadocodigo.compartilhado.CpfOuCnpj;
import br.com.apizup.casadocodigo.compartilhado.ExisteId;
import br.com.apizup.casadocodigo.compartilhado.UnicoValor;
import br.com.apizup.casadocodigo.novoautor.Autor;

public class NovoClienteRequest {

	@Email
	@NotBlank
	@UnicoValor(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CpfOuCnpj
	@UnicoValor(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExisteId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	@ExisteId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	private Cliente cliente;
	private Function<Cliente, Long> funcaoCriacaoPedido;

	public NovoClienteRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	

	public String getDocumento() {
		return documento;
	}

	@Override
	public String toString() {
		return "NovaCompraRequest [email=" + email + ", nome=" + nome
				+ ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento
				+ ", cidade=" + cidade + ", idPais=" + idPais + ", idEstado="
				+ idEstado + ", telefone=" + telefone + ", cep=" + cep +"]";
	}

	public boolean documentoValido() {
		Assert.hasLength(documento,
				"você nao deveria validar o documento se ele não tiver sido preenchido");

		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(documento, null)
				|| cnpjValidator.isValid(documento, null);
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	//1
	public Cliente toModel(EntityManager manager) {
		@NotNull
		//1
		Pais pais = manager.find(Pais.class, idPais);

		//1 funcao como argumento
		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco,
				complemento, pais, telefone, cep);
		//1
		if (idEstado != null) {
			cliente.setEstado(manager.find(Estado.class, idEstado));
		}
		
		
		
		
		
		return cliente;
	}

	public boolean temEstado() {
		return Optional.ofNullable(idEstado).isPresent();
	}
	

}