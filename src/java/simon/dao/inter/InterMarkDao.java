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
import javax.persistence.criteria.CriteriaQuery;
import simon.dao.MarkDao;
import simon.entity.Intervention;
import simon.entity.Mark;

public class InterMarkDao implements MarkDao {
    private EntityManagerFactory emf;
    
    public InterMarkDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public Float getGlobalMark(Intervention intervention) {
            EntityManager em = emf.createEntityManager();
             try {
                Query query = em.createQuery("SELECT AVG(mark1+mark2+mark3+mark4+mark5+mark6) FROM Mark WHERE intervention := intervention");
                query.setParameter("intervention", intervention);
                return (Float) query.getSingleResult();
            }
            catch(NoResultException e) {
                return null;
            }
            finally {
                em.close();
            }
    }
    
    @Override
    public Integer getCount(Intervention intervention) {
            EntityManager em = emf.createEntityManager();
            try {
                Query query = em.createQuery("SELECT COUNT(id) FROM Mark WHERE intervention := intervention");
                query.setParameter("intervention", intervention);
                return (Integer) query.getSingleResult();
            }
            catch(NoResultException e) {
                return null;
            }
            finally {
                em.close();
            }
    }
    
    @Override
    public Float getSpeakerMark(Intervention intervention) {
            EntityManager em = emf.createEntityManager();
            try {
                Query query = em.createQuery("SELECT AVG(mark1+mark2+mark3) FROM Mark WHERE intervention := intervention");
                query.setParameter("intervention", intervention);
                return (Float) query.getSingleResult();
            }
            catch(NoResultException e) {
                return null;
            }
            finally {
                em.close();
            }

    }
    
    @Override
    public Float getSlideMark(Intervention intervention) {
            EntityManager em = emf.createEntityManager();
            try {
                Query query = em.createQuery("SELECT AVG(mark4+mark5+mark6) FROM Mark WHERE intervention := intervention");
                query.setParameter("intervention", intervention);
                return (Float) query.getSingleResult();
            }
            catch(NoResultException e) {
                return null;
            }
            finally {
                em.close();
            }

    }
    
    @Override
    public Mark addMark(Mark mark) {
        Mark result = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
                em.persist(mark);
                em.getTransaction().commit();
                result = mark;
        } finally {
                if(em.getTransaction().isActive()) {
                        em.getTransaction().rollback();
                }
                em.close();
        }
        return result;
    }
    
}