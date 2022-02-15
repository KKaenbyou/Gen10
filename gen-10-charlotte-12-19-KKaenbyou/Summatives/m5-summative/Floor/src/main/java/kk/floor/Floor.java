package kk.floor;

import kk.floor.cont.FloorCont;
import kk.floor.dao.FloorDao;
import kk.floor.dao.FloorDaoImp;
import kk.floor.serv.FloorEx;
import kk.floor.serv.FloorServ;
import kk.floor.serv.FloorServImp;
import kk.floor.ui.FloorView;
import kk.floor.ui.UserIO;
import kk.floor.ui.UserIOImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Floor {

    public static void main(String[] args) throws FloorEx {
        /*
        UserIO io = new UserIOImp();
        FloorView view = new FloorView(io);
        FloorDao dao = new FloorDaoImp();
        FloorServ serv = new FloorServImp(dao);
        FloorCont cont = new FloorCont(serv, view);
        */

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FloorCont cont = ctx.getBean("cont", FloorCont.class);
        cont.run();
    }
}