// @author Kenji Kaenbyou

package kk.mp3;
import kk.mp3.controller.MP3Cont;
import kk.mp3.dao.MP3Dao;
import kk.mp3.dao.MP3DaoImp;
import kk.mp3.ui.MP3View;
import kk.mp3.ui.UserIO;
import kk.mp3.ui.UserIOImp;

public class App {
    
    public static void main(String[] args) {
        UserIO myIo = new UserIOImp();
        MP3View myView = new MP3View(myIo);
        MP3Dao myDao = new MP3DaoImp();
        MP3Cont controller = new MP3Cont(myDao, myView);
        controller.run();
    }   
}