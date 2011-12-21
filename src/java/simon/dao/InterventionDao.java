/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao;

import simon.entity.Intervention;

public interface InterventionDao {
    
    Intervention findInterventionById(Long Id);
    
}
