package view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import controller.AlunoController;
import model.Aluno;

public class PrincipalAluno {

	public static void main(String[] args) {

		Aluno al = new Aluno();
		al.setEmail("emailjoao@net.com");
//		al.setId(0);
		al.setNome("Joaozinho");
		al.setPosicaovestibular(12);
	
	}

	private static void salvarAluno(AlunoController alCont, Aluno al) throws SQLException {
		Aluno al1 = new Aluno();
		al1.setId(1);

		al1 = alCont.consultar(al1);
		System.out.println(al1);
	}

	private static void listarAluno(AlunoController alCont)  throws SQLException {
		List<Aluno> alunos = alCont.listar();
		alunos.forEach(al -> System.out.println(al));
		
	}


	private static void removerAluno(AlunoController alCont, Aluno al) throws SQLException {
		Aluno al1 = al;

		alCont.remover(al1);
		al1 = alCont.consultar(al1);
		System.out.println(al1);
	}
	
	private static void modificarAluno(AlunoController alCont, Aluno al) throws SQLException {
		Aluno al1 = al;
		al1.setEmail("joaozinho@fatec.com");

		alCont.modificar(al1);
		al1 = alCont.consultar(al1);
		System.out.println(al1);
	}
}
