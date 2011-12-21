/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao.inter;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
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
}
