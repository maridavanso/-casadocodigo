package br.com.apizup.casadocodigo.cadastropaisestado;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	
 
	@Deprecated
	public Pais() {
		
	}
	
	public Pais(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}

	//codigo copiado do mentor
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	//codigo copiado do mentor
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public List<Estado> getEstados() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
