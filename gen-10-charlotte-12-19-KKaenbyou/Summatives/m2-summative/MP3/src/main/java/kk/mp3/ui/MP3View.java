// @author Kenji Kaenbyou

package kk.mp3.ui;
import java.util.List;
import kk.mp3.dto.MP3;

public class MP3View {
    
    private UserIO io;
    public MP3View(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List MP3s by title");
        io.print("2. Add new MP3");
        io.print("3. View an MP3");
        io.print("4. Remove an MP3");
        io.print("5. Edit an MP3");
        io.print("6. Exit program");
        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public MP3 getNewMP3Info() {
        String MP3ID = io.readString("Please enter MP3 title");
        String date = io.readString("Please enter the release year");
        String album = io.readString("Please enter the album name");
        String artist = io.readString("Please enter the artist name");
        String genre = io.readString("Please enter the genre");
        String notes = io.readString("Please enter any notes");
        MP3 currentMP3 = new MP3(MP3ID);
        currentMP3.setDate(" " + date + " ");
        currentMP3.setAlbum(" " + album + " ");
        currentMP3.setArtist(" " + artist + " ");
        currentMP3.setGenre(" " + genre + " ");
        currentMP3.setNotes(" " + notes + " ");
        return currentMP3;
    }
    
    public void editMP3Info(MP3 MP3) {
        if (MP3 != null) {
            String date = io.readString("Please enter the release year");
            String album = io.readString("Please enter the album name");
            String artist = io.readString("Please enter the artist name");
            String genre = io.readString("Please enter the genre");
            String notes = io.readString("Please enter any notes");
            MP3.setDate(" " + date + " ");
            MP3.setAlbum(" " + album + " ");
            MP3.setArtist(" " + artist + " ");
            MP3.setGenre(" " + genre + " ");
            MP3.setNotes(" " + notes + " ");
        } else {
            io.print("No such MP3.");
            io.readString("Please hit enter to continue.");
        }
    }
    
    public void displayCreateMP3Banner() {
        io.print("=== Create MP3 ===");
    }
    
    public void displayCreateSuccessBanner() {
        io.readString(
                "MP3 successfully added.  Please hit enter to continue");
    }
    
    public void displayMP3List(List<MP3> MP3List) {
        for (MP3 currentMP3 : MP3List) {
            io.print(currentMP3.getMP3ID() + " | Year released: "
                    + currentMP3.getDate() + " | Album: "
                    + currentMP3.getAlbum() + " | Artist: "
                    + currentMP3.getArtist() + " | Genre: "
                    + currentMP3.getGenre() + " | Notes: "
                    + currentMP3.getNotes());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All MP3s ===");
    }
    
    public void displayDisplayMP3Banner () {
        io.print("=== Display MP3 ===");
    }
    
    public String getMP3IDChoice() {
        return io.readString("Please enter the MP3 Title.");
    }
    
    public void displayMP3(MP3 MP3) {
        if (MP3 != null) {
            io.print(MP3.getMP3ID() + " | Year released: "
                    + MP3.getDate() + " | Album: "
                    + MP3.getAlbum() + " | Artist: "
                    + MP3.getArtist() + " | Genre: "
                    + MP3.getGenre() + " | Notes: "
                    + MP3.getNotes());
        } else {
            io.print("No such MP3.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveMP3Banner() {
        io.print("=== Remove MP3 ===");
    }
    
    public void displayRemoveSuccessBanner() {
        io.readString("MP3 successfully removed. Please hit enter to continue.");
    }
    
    public void displayEditMP3Banner() {
        io.print("=== Edit MP3 ===");
    }
    
    public void displayEditSuccessBanner() {
        io.readString("MP3 successfully edited. Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("=== Program Terminated ===");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("=== Unknown Command ===");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}