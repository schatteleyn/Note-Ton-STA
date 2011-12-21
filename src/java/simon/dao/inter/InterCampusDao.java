/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao.inter;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import simon.dao.CampusDao;
import simon.entity.Campus;

public class InterCampusDao implements CampusDao {
    
    private EntityManagerFactory emf;
    
    public InterCampusDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public Campus findCampusById(Long id){
        Campus result;
        EntityManager em = emf.createEntityManager();
		try { 
			result = em.find(Campus.class, id);
		} catch (NoResultException e) {
			result = null;
		} finally {
			em.close(); 
		}
        return result;
    }
    
        @Override
	public List<Campus> getAllCampus() {
		EntityManager em = emf.createEntityManager();
		try {
			CriteriaQuery<Campus> criteriaQuery = em.getCriteriaBuilder().createQuery(Campus.class);
			criteriaQuery.from(Campus.class);
			return em.createQuery(criteriaQuery).getResultList();
		} finally {
			em.close();
		}
	}
        
        @Override
	public Campus addCampus(Campus campus) {
		Campus result = null;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(campus);
			em.getTransaction().commit();
			result = campus;
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
		return result;
	}

}