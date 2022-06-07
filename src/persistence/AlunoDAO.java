package persistence;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Aluno;

public class AlunoDAO implements DAO<Aluno> {

	private SessionFactory sf;

	public AlunoDAO(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insert(Aluno a) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(a);
		transaction.commit();
	}

	@Override
	public void update(Aluno a) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(a);
		transaction.commit();
	}

	@Override
	public void delete(Aluno a) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(a);
		transaction.commit();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> selectAll() throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT a.nome, a.email, a.posicaovest ");
		sql.append("FROM aluno f, disciplina dis ");
		sql.append("WHERE a.id = dis.id");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> disciplina = query.getResultList();
		List<Aluno> alunos = new ArrayList<Aluno>();
		for (Object[] o : disciplina) {
			Aluno a = new Aluno();
			a.setNome(o[1].toString());
			a.setEmail(o[2].toString());

			alunos.add(a);
		}

		return alunos;
	}

	@Override
	public Aluno selectOne(Aluno a) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		a = entityManager.find(Aluno.class, a.getId());
		return a;
	}

}