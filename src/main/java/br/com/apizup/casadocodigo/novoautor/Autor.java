package br.com.apizup.casadocodigo.novoautor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	private LocalDateTime instanteCriacao = LocalDateTime.now();

	@Deprecated
	public Autor() {
		
	}
	
	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {

		// programação defensiva
		Assert.hasLength(nome, "Nome obrigatório");
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", instanteCriacao=" + instanteCriacao + "]";
	}

	
}
