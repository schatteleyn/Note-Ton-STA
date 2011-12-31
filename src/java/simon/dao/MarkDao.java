/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao;

import java.util.List;
import simon.entity.Intervention;
import simon.entity.Mark;

public interface MarkDao {
    Float getGlobalMark(Intervention intervention);
    List<Float> getGlobalMarkGroupBy(Long IntervId);
    Integer getCount(Intervention intervention);
    Float getSpeakerMark(Intervention intervention);
    Float getSlideMark(Intervention intervention);
    Mark addMark(Mark mark);
    String getStringChart(Long id);
}
