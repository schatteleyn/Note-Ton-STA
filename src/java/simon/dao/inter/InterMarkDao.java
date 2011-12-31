/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao.inter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
                Query query = em.createQuery("SELECT (mark1+mark2+mark3+mark4+mark5+mark6)/6 FROM Mark WHERE intervention := intervention");
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
    @SuppressWarnings("unchecked")
    public List<Float> getGlobalMarkGroupBy(Long IntervId) {
            EntityManager em = emf.createEntityManager();
             try {
                Query query = em.createQuery("SELECT (mark1+mark2+mark3+mark4+mark5+mark6)/6 FROM Mark m WHERE m.IntervId := IntervId");
                query.setParameter("IntervId", IntervId);
                return (List<Float>) query.getResultList();
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
                Query query = em.createQuery("SELECT (mark1+mark2+mark3)/3 FROM Mark WHERE intervention := intervention");
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
                Query query = em.createQuery("SELECT (mark4+mark5+mark6)/3 FROM Mark WHERE intervention := intervention");
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
    
    @Override
	public String getStringChart(Long id) {
		//Generate the String Chart
		List<Float> MarksList = this.getGlobalMarkGroupBy(id);
		ArrayList<Integer> MarksRound = new ArrayList<>();
		int counter, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;
		String ChartList;
		Integer round;
		try{

			for (Float marksTemp  : MarksList) {
				round = Math.round(marksTemp);
				MarksRound.add(round);
			}

			for (int i = 0; i < 6; i++) {
				counter = 0;
				for (Integer value : MarksRound) {
					if(value==i){
						counter++;
					}
				}

				switch (i) {
				case 1: count1 = counter; break;
				case 2: count2 = counter; break;
				case 3: count3 = counter; break;
				case 4: count4 = counter; break;
				case 5: count5 = counter; break;
				}
			}	

			ChartList = "['1', " + count1 + "]";
			ChartList = ChartList + ", ['2', " + count2 + "]";
			ChartList = ChartList + ", ['3', " + count3 + "]";
			ChartList = ChartList + ", ['4', " + count4 + "]";
			ChartList = ChartList + ", ['5', " + count5 + "]";

			return ChartList;
		}
		catch (NullPointerException e) {
			return null;
		}

	}
    
}