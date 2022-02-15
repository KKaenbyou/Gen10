// @author Kenji Kaenbyou

package kk.mp3.dto;

public class MP3 {
    
    private String date;
    private String album;
    private String MP3ID;
    private String artist;
    private String genre;
    private String notes;
    
    public MP3(String MP3ID) {
        this.MP3ID = MP3ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getMP3ID() {
        return MP3ID;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
}