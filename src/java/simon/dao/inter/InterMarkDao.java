/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao.inter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import simon.dao.MarkDao;
import simon.entity.Mark;

public class InterMarkDao implements MarkDao {
    private EntityManagerFactory emf;
    
    public InterMarkDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
}
