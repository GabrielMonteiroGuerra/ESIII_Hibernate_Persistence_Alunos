package view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import controller.DisciplinaController;
import model.Disciplina;

public class PrincipalDisciplina {

	public static void main(String[] args) {

		Disciplina di = new Disciplina();
		di.setCargaHoraria(12);
	
	}

	private static void salvarDisciplina(DisciplinaController diCont, Disciplina di) throws SQLException {
		Disciplina di1 = new Disciplina();

		di1 = diCont.consultar(di1);
		System.out.println(di1);
	}

	private static void listarDisciplina(DisciplinaController diCont)  throws SQLException {
		List<Disciplina> Disciplinas = diCont.listar();
		Disciplinas.forEach(di -> System.out.println(di));
		
	}


	private static void removerDisciplina(DisciplinaController diCont, Disciplina di) throws SQLException {
		Disciplina di1 = di;

		diCont.remover(di1);
		di1 = diCont.consultar(di1);
		System.out.println(di1);
	}
	
	private static void modificarDisciplina(DisciplinaController diCont, Disciplina di) throws SQLException {
		Disciplina di1 = di;

		diCont.modificar(di1);
		di1 = diCont.consultar(di1);
		System.out.println(di1);
	}
}

