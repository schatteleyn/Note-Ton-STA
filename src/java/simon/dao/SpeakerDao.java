/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao;

import simon.entity.Speaker;

public interface SpeakerDao {
    
    Speaker addSpeaker(Speaker speaker);
    Speaker authenticate(String email, String password);
    Speaker findSpeakerByEmail(String email);
}
