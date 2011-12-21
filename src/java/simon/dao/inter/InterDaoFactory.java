/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao.inter;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import simon.dao.CampusDao;
import simon.dao.DaoFactory;
import simon.dao.InterventionDao;
import simon.dao.SpeakerDao;

public class InterDaoFactory extends DaoFactory {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("nts");

	private InterCampusDao campusDao;
	private InterInterventionDao interventionDao;
        private InterSpeakerDao speakerDao;

	@Override
	public CampusDao getCampusDao() {
		if(campusDao == null) {
			campusDao = new InterCampusDao(emf);
		}
		return (CampusDao) campusDao;
	}

	@Override
	public InterventionDao getInterventionDao() {
		if(interventionDao == null) {
			interventionDao = new InterInterventionDao(emf);
		}
		return (InterventionDao) interventionDao;
	}
        
        @Override
	public SpeakerDao getSpeakerDao() {
		if(speakerDao == null) {
			speakerDao = new InterSpeakerDao(emf);
		}
		return (SpeakerDao) speakerDao;
	}

    
}
