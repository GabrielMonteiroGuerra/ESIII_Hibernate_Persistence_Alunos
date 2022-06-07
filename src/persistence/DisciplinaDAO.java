package persistence;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Disciplina;

public class DisciplinaDAO implements DAO<Disciplina> {

	private SessionFactory sf;

	public DisciplinaDAO(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insert(Disciplina d) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(d);
		transaction.commit();
	}

	@Override
	public void update(Disciplina d) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(d);
		transaction.commit();
	}

	@Override
	public void delete(Disciplina d) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(d);
		transaction.commit();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> selectAll() throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT d.codDisciplina, d.nomeDisciplina, d.cargaHoraria ");
		sql.append("FROM disciplina d, aluno a ");
		sql.append("WHERE d.codDisciplina = a.id");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> disciplina = query.getResultList();
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		for (Object[] o : disciplina) {
			Disciplina d = new Disciplina();
			d.setCodDisciplina(Integer.parseInt(o[0].toString()));
			d.setNomeDisciplina(o[1].toString());
			d.setCargaHoraria(Integer.parseInt(o[3].toString()));

			disciplinas.add(d);
		}

		return disciplinas;
	}

	@Override
	public Disciplina selectOne(Disciplina d) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		d = entityManager.find(Disciplina.class, d.getCodDisciplina());
		return d;
	}

}