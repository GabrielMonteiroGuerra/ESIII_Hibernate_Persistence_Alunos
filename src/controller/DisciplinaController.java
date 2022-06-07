package controller;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import model.Disciplina;
import persistence.DisciplinaDAO;
import util.HibernateUtil;

public class DisciplinaController implements OperacoesController<Disciplina> {

	@Override
	public void salvar(Disciplina di) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDAO diDao = new DisciplinaDAO(sessionFactory);
		diDao.insert(di);
	}

	@Override
	public void modificar(Disciplina di) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDAO diDao = new DisciplinaDAO(sessionFactory);
		diDao.update(di);
	}

	@Override
	public void remover(Disciplina di) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDAO diDao = new DisciplinaDAO(sessionFactory);
		diDao.delete(di);
	}

	@Override
	public Disciplina consultar(Disciplina di) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDAO diDao = new DisciplinaDAO(sessionFactory);
		di = diDao.selectOne(di);
		return di;
	}

	@Override
	public List<Disciplina> listar() throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		DisciplinaDAO diDao = new DisciplinaDAO(sessionFactory);
		List<Disciplina> Disciplinas = diDao.selectAll();
		return Disciplinas;
	}
}
