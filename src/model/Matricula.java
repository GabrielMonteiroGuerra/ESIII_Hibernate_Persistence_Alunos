package model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "Matricula")

public class Matricula {
	
	@Id
	@ManyToAny
	@JoinColumn(name = "id_aluno")
	@NotNull
	private String ra;
	
	@Id
	@ManyToAny
	@JoinColumn(name = "cod_disciplina")
	@NotNull
	private String codDisciplina;
	
	@Id
	@ManyToAny
	@JoinColumn(name = "semestre")
	@NotNull
	private int semestre;
	
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getCodDisciplina() {
		return codDisciplina;
	}
	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	@Override
	public String toString() {
		return "Matricula [ra=" + ra + ", codDisciplina=" + codDisciplina + ", semestre=" + semestre + "]";
	}
	
	
	
}
