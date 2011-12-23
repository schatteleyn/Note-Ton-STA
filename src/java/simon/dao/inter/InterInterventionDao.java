/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao.inter;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import simon.dao.InterventionDao;
import simon.entity.Intervention;

public class InterInterventionDao implements InterventionDao {
    private EntityManagerFactory emf;
    
    public InterInterventionDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public Intervention findInterventionById(Long id){
        Intervention result;
        EntityManager em = emf.createEntityManager();
		try { 
			result = em.find(Intervention.class, id);
		} catch (NoResultException e) {
			result = null;
		} finally {
			em.close(); 
		}
        return result;
    }
    
    @Override
    public Intervention findInterventionByCampus(Long id) {
            EntityManager em = emf.createEntityManager();
            try { 
                    Query query = em.createQuery("SELECT i FROM Intervention i LEFT JOIN FETCH i.campus WHERE i.id = :id");
                    query.setParameter("id", id);
                    return (Intervention) query.getSingleResult();
            } catch (NoResultException e) {
                    return null;
            } finally { 
                    em.close(); 
            }
    }
    
    @Override
    public Intervention findInterventionBySpeaker(Long id) {
            EntityManager em = emf.createEntityManager();
            try { 
                    Query query = em.createQuery("SELECT i FROM Intervention i LEFT JOIN FETCH i.speaker WHERE i.id = :id");
                    query.setParameter("id", id);
                    return (Intervention) query.getSingleResult();
            } catch (NoResultException e) {
                    return null;
            } finally { 
                    em.close(); 
            }
    }
    
    @Override
    public Intervention addIntervention(Intervention intervention) {
        Intervention result = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
                em.persist(intervention);
                em.getTransaction().commit();
                result = intervention;
        } finally {
                if(em.getTransaction().isActive()) {
                        em.getTransaction().rollback();
                }
                em.close();
        }
        return result;
    }
    
    @Override
	public void updateIntervention(Intervention intervention) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(intervention);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

	@Override
	public void removeIntervention(Intervention intervention) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(em.merge(intervention));
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

}