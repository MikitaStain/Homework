package by.it_academy.vote.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteStorage {
    private final Map<String, Integer> artist;
    private final Map<String, Integer> genre;
    private final List<String> about;


    public VoteStorage() {
        this.artist = new HashMap<>();
        this.genre=new HashMap<>();
        this.about=new ArrayList<>();
    }

    public Map<String, Integer> getArtist() {
        return artist;
    }

    public Map<String, Integer> getGenre() {
        return genre;
    }

    public List<String> getAbout() {
        return about;
    }
}
