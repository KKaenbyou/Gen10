// @author Kenji Kaenbyou

package kk.mp3.dao;
import java.util.List;
import kk.mp3.dto.MP3;

public interface MP3Dao {
    
    MP3 addMP3(String MP3ID, MP3 MP3) throws MP3DaoException;
    List<MP3> getAllMP3() throws MP3DaoException;
    MP3 getMP3(String MP3ID) throws MP3DaoException;
    MP3 removeMP3(String MP3ID) throws MP3DaoException;
    MP3 editMP3(String MP3ID, MP3 MP3) throws MP3DaoException;
}