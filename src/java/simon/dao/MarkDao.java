/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao;

import simon.entity.Mark;

public interface MarkDao {
    Float getGlobalMark(Long id);
    Integer getCount(Long id);
    Float getSpeakerMark(Long id);
    Float getSlideMark(Long id);
    Mark addMark(Mark mark);
}
