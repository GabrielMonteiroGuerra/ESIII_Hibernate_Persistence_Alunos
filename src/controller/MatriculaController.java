package controller;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import model.Matricula;
import persistence.MatriculaDAO;
import util.HibernateUtil;

public class MatriculaController implements OperacoesController<Matricula> {

	@Override
	public void salvar(Matricula ma) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDAO maDao = new MatriculaDAO(sessionFactory);
		maDao.insert(ma);
	}

	@Override
	public void modificar(Matricula ma) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDAO maDao = new MatriculaDAO(sessionFactory);
		maDao.update(ma);
	}

	@Override
	public void remover(Matricula ma) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDAO maDao = new MatriculaDAO(sessionFactory);
		maDao.delete(ma);
	}

	@Override
	public Matricula consultar(Matricula ma) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDAO maDao = new MatriculaDAO(sessionFactory);
		ma = maDao.selectOne(ma);
		return ma;
	}

	@Override
	public List<Matricula> listar() throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		MatriculaDAO maDao = new MatriculaDAO(sessionFactory);
		List<Matricula> matriculas = maDao.selectAll();
		return matriculas;
	}
}
