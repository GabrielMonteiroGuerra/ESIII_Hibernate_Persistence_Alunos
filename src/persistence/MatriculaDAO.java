package persistence;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Matricula;

public class MatriculaDAO implements DAO<Matricula> {

	private SessionFactory sf;

	public MatriculaDAO(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insert(Matricula m) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(m);
		transaction.commit();
	}

	@Override
	public void update(Matricula m) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(m);
		transaction.commit();
	}

	@Override
	public void delete(Matricula m) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(m);
		transaction.commit();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> selectAll() throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT m.idaluno, m.codDisciplina, m.semestre ");
		sql.append("FROM matricula m, aluno a ");
		sql.append("WHERE m.idAluno = a.id");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> matricula = query.getResultList();
		List<Matricula> matriculas = new ArrayList<Matricula>();
		for (Object[] o : matricula) {
			Matricula m = new Matricula();
			m.setRa(o[1].toString());
			m.setCodDisciplina(o[1].toString());
			m.setSemestre(Integer.parseInt(o[3].toString()));

			matriculas.add(m);
		}

		return matriculas;
	}

	@Override
	public Matricula selectOne(Matricula m) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		m = entityManager.find(Matricula.class, m.getCodDisciplina());
		return m;
	}

}