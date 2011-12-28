/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao;

import simon.entity.Intervention;

public interface InterventionDao {
    
    Intervention findInterventionById(Long Id);
    Intervention findInterventionByCampus(Long id);
    Intervention findInterventionBySpeaker(Long id);
    
    Intervention addIntervention(Intervention intervention);
    void updateIntervention(Intervention intervention);
    void removeIntervention(Intervention intervention);
    void removeIntervention(Long interventionId);
    
}
