package br.com.apizup.casadocodigo.cadastropaisestado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class Estado { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	 @ManyToOne 
	private @NotNull @Valid Pais pais;
	
	@Deprecated
	public Estado() {
		
	}
	
	public Estado (String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}

	//codigo copiado do mentor
	public boolean pertenceAPais(Pais pais) {
		return this.pais.equals(pais);
	}
	
	
	

}
