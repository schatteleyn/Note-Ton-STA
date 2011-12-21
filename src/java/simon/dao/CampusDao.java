/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao;

import java.util.List;
import simon.entity.Campus;

public interface CampusDao {
    Campus findCampusById(Long id);
    List<Campus> getAllCampus();
    Campus addCampus(Campus campus);
}
