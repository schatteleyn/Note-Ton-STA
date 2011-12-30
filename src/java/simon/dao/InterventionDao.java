/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao;

import java.util.List;
import simon.entity.Campus;
import simon.entity.Intervention;
import simon.entity.Speaker;

public interface InterventionDao {
    
    Intervention findInterventionById(Long Id);
    List<Campus> findInterventionByCampus(Campus campus);
    List<Intervention> findInterventionBySpeaker(Speaker speaker);
    
    Intervention addIntervention(Intervention intervention);
    void updateIntervention(Intervention intervention);
    void removeIntervention(Intervention intervention);
    void removeIntervention(Long interventionId);
    
}
