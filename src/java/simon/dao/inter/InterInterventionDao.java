/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao.inter;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import simon.dao.InterventionDao;
import simon.entity.Campus;
import simon.entity.Intervention;
import simon.entity.Speaker;

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
    public List<Intervention> findInterventionByCampus(Campus campus) {
            EntityManager em = emf.createEntityManager();
            try { 
                    Query query = em.createQuery("SELECT i FROM Intervention i WHERE campus = :campus");
                    query.setParameter("campus", campus);
                    List<Intervention> intervention = query.getResultList();
                    return intervention;
            } catch (NoResultException e) {
                    return null;
            } finally { 
                    em.close(); 
            }
    }
    
    @Override
    public List<Intervention> findInterventionBySpeaker(Speaker speaker) {
            EntityManager em = emf.createEntityManager();
            try { 
                    Query query = em.createQuery("SELECT i FROM Intervention i WHERE speaker = :speaker");
                    query.setParameter("speaker", speaker);
                    List<Intervention> intervention = query.getResultList();
                    return intervention;
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
        
        @Override
	public void removeIntervention(Long interventionId) {
		EntityManager em = emf.createEntityManager();
		try{
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Intervention AS i Where i.id = :interventionId")
				.setParameter("interventionId", interventionId)
				.executeUpdate();
			em.getTransaction().commit();
		}
		finally{
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

}