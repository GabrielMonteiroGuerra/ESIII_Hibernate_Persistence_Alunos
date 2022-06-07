package model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table (name = "Disciplina")
public class Disciplina {
	
	@Id
	@ManyToAny
	@JoinColumn(name = "cod_Disciplina")
	@NotNull
	private int codDisciplina;
	
	@Column(name = "nome_disciplina")
	@NotNull
	private String nomeDisciplina;
	
	@Column(name = "carga_horaria")
	@NotNull
	private int cargaHoraria;
	
	
	public int getCodDisciplina() {
		return codDisciplina;
	}
	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	@Override
	public String toString() {
		return "Disciplina [codDisciplina=" + codDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", cargaHoraria="
				+ cargaHoraria + "]";
	}
	
	
}
