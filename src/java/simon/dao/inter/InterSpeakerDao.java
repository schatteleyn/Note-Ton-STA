/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao.inter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import simon.dao.SpeakerDao;
import simon.entity.Speaker;


public class InterSpeakerDao implements SpeakerDao {
    private EntityManagerFactory emf;
    
    public InterSpeakerDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public String encryptPassword(String password) {
		String result = null;
		try {
			result = new String(MessageDigest.getInstance("SHA-1").digest(password.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
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
    
    @Override
    public Speaker login(String email, String password) {
            Speaker result = null;

            EntityManager em = emf.createEntityManager();
            try {
                Speaker speaker = findSpeakerByEmail(email);
                //if(speaker != null && speaker.getEncryptedPassword().equals(encryptPassword(password))) {
                if(speaker != null && speaker.getPassword().equals(password)) {
                        result = speaker;
                }
            } catch (NoResultException e) { 

            } finally {
                    em.close();
            }

            return result;
    }
    
    @Override
    public Speaker findSpeakerByEmail(String email) {
        Speaker result;

        EntityManager em = emf.createEntityManager();
        Object speaker = null;
        try {
                Query query = em.createQuery("SELECT s FROM Speaker s WHERE s.speaker = :speaker");
                result = (Speaker) query.setParameter("speaker", speaker).getSingleResult();
        } catch (NoResultException e) { 
                result = null;
        } finally {
                em.close();
        }

        return result;
    }

}
