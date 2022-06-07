package view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import controller.MatriculaController;
import model.Matricula;

public class PrincipalMatricula {

	public static void main(String[] args) {

		Matricula ma = new Matricula();
		ma.setRa("1110482023042");
	
	}

	private static void salvarMatricula(MatriculaController maCont, Matricula ma) throws SQLException {
		Matricula ma1 = new Matricula();

		ma1 = maCont.consultar(ma1);
		System.out.println(ma1);
	}

	private static void listarMatricula(MatriculaController maCont)  throws SQLException {
		List<Matricula> Matriculas = maCont.listar();
		Matriculas.forEach(ma -> System.out.println(ma));
		
	}


	private static void removerMatricula(MatriculaController maCont, Matricula ma) throws SQLException {
		Matricula ma1 = ma;

		maCont.remover(ma1);
		ma1 = maCont.consultar(ma1);
		System.out.println(ma1);
	}
	
	private static void modificarMatricula(MatriculaController maCont, Matricula ma) throws SQLException {
		Matricula ma1 = ma;

		maCont.modificar(ma1);
		ma1 = maCont.consultar(ma1);
		System.out.println(ma1);
	}
}


