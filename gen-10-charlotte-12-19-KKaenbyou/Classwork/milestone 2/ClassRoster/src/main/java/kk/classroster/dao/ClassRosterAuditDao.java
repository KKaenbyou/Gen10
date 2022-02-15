// @author Kenji Kaenbyou

package kk.classroster.dao;

public interface ClassRosterAuditDao {
   
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;   
}