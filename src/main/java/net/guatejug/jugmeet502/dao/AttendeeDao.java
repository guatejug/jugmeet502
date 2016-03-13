package net.guatejug.jugmeet502.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import net.guatejug.jugmeet502.domain.Attendee;

/**
 * DAO for Attendee
 */
@Stateless
public class AttendeeDao {
	@PersistenceContext(unitName = "JUGMEET502_DS")
	private EntityManager em;

	public void create(Attendee entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Attendee entity = em.find(Attendee.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Attendee findById(Integer id) {
		return em.find(Attendee.class, id);
	}

	public Attendee update(Attendee entity) {
		return em.merge(entity);
	}

	public List<Attendee> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Attendee> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT a FROM Attendee a LEFT JOIN FETCH a.lectureList ORDER BY a.attendeeId",
						Attendee.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
