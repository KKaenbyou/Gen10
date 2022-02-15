// @author Kenji Kaenbyou

package kk.classroster;
import kk.classroster.controller.ClassRosterController;
import kk.classroster.dao.ClassRosterAuditDao;
import kk.classroster.dao.ClassRosterAuditDaoFileImpl;
import kk.classroster.dao.ClassRosterDao;
import kk.classroster.dao.ClassRosterDaoFileImpl;
import kk.classroster.service.ClassRosterServiceLayer;
import kk.classroster.service.ClassRosterServiceLayerImpl;
import kk.classroster.ui.ClassRosterView;
import kk.classroster.ui.UserIO;
import kk.classroster.ui.UserIOConsoleImpl;

public class App {
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao);
        ClassRosterController controller = new ClassRosterController(myService, myView);
        controller.run();
    }
}