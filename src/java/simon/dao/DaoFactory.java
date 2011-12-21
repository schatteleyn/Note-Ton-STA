/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simon.dao;

import simon.dao.inter.InterDaoFactory;

public abstract class DaoFactory {
    public static DaoFactory getDaoFactory() {
        return new InterDaoFactory();
    }
    public abstract CampusDao getCampusDao();
    public abstract InterventionDao getInterventionDao();
}
