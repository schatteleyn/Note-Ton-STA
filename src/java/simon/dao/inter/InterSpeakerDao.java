/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao.inter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import simon.dao.SpeakerDao;
import simon.entity.Speaker;


public class InterSpeakerDao implements SpeakerDao {
    private EntityManagerFactory emf;
    
    public InterSpeakerDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public Speaker addSpeaker(Speaker speaker) {
        Speaker result = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
                em.persist(speaker);
                em.getTransaction().commit();
                result = speaker;
        } finally {
                if(em.getTransaction().isActive()) {
                        em.getTransaction().rollback();
                }
                em.close();
        }
        return result;
    }

}
