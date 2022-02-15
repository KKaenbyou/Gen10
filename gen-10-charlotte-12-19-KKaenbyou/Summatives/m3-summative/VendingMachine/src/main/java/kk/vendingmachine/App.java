package kk.vendingmachine;
import kk.vendingmachine.cont.VendCont;
import kk.vendingmachine.dao.AuditDao;
import kk.vendingmachine.dao.VendAuditDaoImp;
import kk.vendingmachine.dao.VendDao;
import kk.vendingmachine.dao.VendEx;
import kk.vendingmachine.dao.VendDaoImp;
import kk.vendingmachine.serv.LowFundsEx;
import kk.vendingmachine.serv.NoItemEx;
import kk.vendingmachine.serv.VendServLayer;
import kk.vendingmachine.serv.VendServLayerImp;
import kk.vendingmachine.ui.UserIO;
import kk.vendingmachine.ui.UserIOImp;
import kk.vendingmachine.ui.VendView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    
    public static void main(String[] args) throws VendEx, LowFundsEx, NoItemEx {
        /*
        UserIO myIo = new UserIOImp();
        VendView myView = new VendView(myIo);
        VendDao myDao = new VendDaoImp();
        AuditDao myAuditDao = new VendAuditDaoImp();
        VendServLayer myService = new VendServLayerImp(myDao, myAuditDao);
        VendCont controller = new VendCont(myService, myView);
        */
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendCont controller = ctx.getBean("controller", VendCont.class);
        controller.run();
    }
}