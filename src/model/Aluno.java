package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "aluno")

public class Aluno {
	
	@Column(name = "id_aluno")
	@NotNull
	private int id;
	
	
	@Column(name = "nome_aluno")
	@NotNull
	private String nome;
	
	@Column(name = "email_aluno")
	@NotNull
	private String email;
	
	@Column(name = "posivest_aluno")
	@NotNull
	private int posicaovestibular;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPosicaovestibular() {
		return posicaovestibular;
	}
	public void setPosicaovestibular(int posicaovestibular) {
		this.posicaovestibular = posicaovestibular;
	}
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", email=" + email + ", posicaovestibular=" + posicaovestibular + "]";
	}
	
	
	
}
