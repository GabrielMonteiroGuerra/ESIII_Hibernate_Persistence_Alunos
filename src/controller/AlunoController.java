package controller;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import model.Aluno;
import persistence.AlunoDAO;
import util.HibernateUtil;

public class AlunoController implements OperacoesController<Aluno> {

	@Override
	public void salvar(Aluno al) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDAO alDao = new AlunoDAO(sessionFactory);
		alDao.insert(al);
	}

	@Override
	public void modificar(Aluno al) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDAO alDao = new AlunoDAO(sessionFactory);
		alDao.update(al);
	}

	@Override
	public void remover(Aluno al) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDAO alDao = new AlunoDAO(sessionFactory);
		alDao.delete(al);
	}

	@Override
	public Aluno consultar(Aluno al) throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDAO alDao = new AlunoDAO(sessionFactory);
		al = alDao.selectOne(al);
		return al;
	}

	@Override
	public List<Aluno> listar() throws SQLException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		AlunoDAO alDao = new AlunoDAO(sessionFactory);
		List<Aluno> Alunos = alDao.selectAll();
		return Alunos;
	}
}
