package br.com.apizup.casadocodigo.fluxocompra;

import java.util.function.Function;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.apizup.casadocodigo.cadastropaisestado.Estado;
import br.com.apizup.casadocodigo.cadastropaisestado.Pais;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @Email @NotBlank String email;
	private @NotBlank String nome;
	private @NotBlank String sobrenome;
	private @NotBlank String documento;
	private @NotBlank String endereco;
	private @NotBlank String complemento;
	@ManyToOne
	private @NotNull Pais pais;
	private @NotBlank String telefone;
	private @NotBlank String cep;
	@ManyToOne
	private Estado estado;

	
	
	
	
	public Cliente(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotNull Pais pais,
			@NotBlank String telefone, @NotBlank String cep) {
		
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
		this.estado = estado;
		
	}



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", pais=" + pais
				+ ", telefone=" + telefone + ", cep=" + cep + ", estado=" + estado + "]";
	}


	//codigo copiado do g do mentor
	public void setEstado(@NotNull @Valid Estado estado) {
		Assert.notNull(pais,"Não podemos associar um estado enquanto o pais for nulo");
		Assert.isTrue(estado.pertenceAPais(pais),"Este estado não é do país associado a compra");
		this.estado = estado;
		
	}



	@Deprecated
	public Cliente() {
		
	}






	public Function<Cliente, Long> toModel(EntityManager manager) {
		// TODO Auto-generated method stub
		return null;
	}

		
	
}
