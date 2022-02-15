// @author Kenji Kaenbyou

package kk.mp3.controller;
import java.util.List;
import kk.mp3.dao.MP3Dao;
import kk.mp3.dao.MP3DaoException;
import kk.mp3.dto.MP3;
import kk.mp3.ui.MP3View;

public class MP3Cont {
    
    MP3View view;
    MP3Dao dao;
    public MP3Cont(MP3Dao dao, MP3View view) {
        this.dao = dao;
        this.view = view;
    }
     
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        listMP3();
                        break;
                    case 2:
                        createMP3();
                        break;
                    case 3:
                        viewMP3();
                        break;
                    case 4:
                        removeMP3();
                        break;
                    case 5:
                        editMP3();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (MP3DaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createMP3() throws MP3DaoException {
        view.displayCreateMP3Banner();
        MP3 newMP3 = view.getNewMP3Info();
        dao.addMP3(newMP3.getMP3ID(), newMP3);
        view.displayCreateSuccessBanner();
    }
    
    private void listMP3() throws MP3DaoException {
        view.displayDisplayAllBanner();
        List<MP3> MP3List = dao.getAllMP3();
        view.displayMP3List(MP3List);
    }
    
    private void viewMP3() throws MP3DaoException {
        view.displayDisplayMP3Banner();
        String MP3ID = view.getMP3IDChoice();
        MP3 MP3 = dao.getMP3(MP3ID);
        view.displayMP3(MP3);
    }
    
    private void removeMP3() throws MP3DaoException {
        view.displayRemoveMP3Banner();
        String MP3ID = view.getMP3IDChoice();
        dao.removeMP3(MP3ID);
        view.displayRemoveSuccessBanner();
    }
    
    private void editMP3() throws MP3DaoException {
        view.displayEditMP3Banner();
        String MP3ID = view.getMP3IDChoice();
        MP3 MP3 = dao.getMP3(MP3ID);
        view.editMP3Info(MP3);
        if (MP3 != null) {
        dao.editMP3(MP3ID, MP3);
        view.displayEditSuccessBanner();
        }
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}