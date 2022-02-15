// @author Kenji Kaenbyou

package kk.mp3.dao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import kk.mp3.dto.MP3;

public class MP3DaoImp implements MP3Dao {
    private Map<String, MP3> MP3s = new HashMap<>();
    public static final String LIST_FILE = "list.txt";
    public static final String DELIMITER = ":";
    
    @Override
    public MP3 addMP3(String MP3ID, MP3 MP3) throws MP3DaoException {
        loadList();
        MP3 newMP3 = MP3s.put(MP3ID, MP3);
        writeList();
        return newMP3;
    }
    
    @Override
    public List<MP3> getAllMP3() throws MP3DaoException {
        loadList();
        return new ArrayList<MP3>(MP3s.values());
    }
    
    @Override
    public MP3 getMP3(String MP3ID) throws MP3DaoException {
        loadList();
        return MP3s.get(MP3ID);
    }
    
    @Override
    public MP3 removeMP3(String MP3ID) throws MP3DaoException {
        loadList();
        MP3 removedMP3 = MP3s.remove(MP3ID);
        writeList();
        return removedMP3;
    }
    
    @Override
    public MP3 editMP3(String MP3ID, MP3 MP3) throws MP3DaoException {
        loadList();
        MP3 editedMP3 = MP3s.put(MP3ID, MP3);
        writeList();
        return editedMP3;
    }
    
    private MP3 unmarshallMP3(String MP3AsText){
        String[] MP3Tokens = MP3AsText.split(DELIMITER);
        String MP3ID = MP3Tokens[0];
        MP3 MP3FromFile = new MP3(MP3ID);
        MP3FromFile.setDate(MP3Tokens[1]);
        MP3FromFile.setAlbum(MP3Tokens[2]);
        MP3FromFile.setArtist(MP3Tokens[3]);
        MP3FromFile.setGenre(MP3Tokens[4]);
        MP3FromFile.setNotes(MP3Tokens[5]);
        return MP3FromFile;
    }
    
    private void loadList() throws MP3DaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIST_FILE)));
        } catch (FileNotFoundException e) {
            throw new MP3DaoException("Could not load MP3 data into memory.", e);
        }
        String currentLine;
        MP3 currentMP3;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentMP3 = unmarshallMP3(currentLine);
            MP3s.put(currentMP3.getMP3ID(), currentMP3);
        }
        scanner.close();
    }
    
    private String marshallMP3(MP3 MP3){
        String MP3AsText = MP3.getMP3ID() + DELIMITER;
        MP3AsText += MP3.getDate() + DELIMITER;
        MP3AsText += MP3.getAlbum() + DELIMITER;
        MP3AsText += MP3.getArtist() + DELIMITER;
        MP3AsText += MP3.getGenre() + DELIMITER;
        MP3AsText += MP3.getNotes();
        return MP3AsText;
    }
    
    private void writeList() throws MP3DaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIST_FILE));
        } catch (IOException e) {
            throw new MP3DaoException("Could not save MP3 data.", e);
        }

        String MP3AsText;
        List<MP3> MP3List = this.getAllMP3();
        for (MP3 currentMP3 : MP3List) {
            MP3AsText = marshallMP3(currentMP3);
            out.println(MP3AsText);
            out.flush();
        }
        out.close();
    }
}