/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao;

import simon.entity.Speaker;

public interface SpeakerDao {
    
    String encryptPassword(String password);
    Speaker addSpeaker(Speaker speaker);
    Speaker login(String email, String password);
    Speaker findSpeakerByEmail(String email);
    Speaker findSpeakerById(Long id);
}
