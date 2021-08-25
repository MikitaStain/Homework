package by.it_academy.vote.service;

import by.it_academy.vote.storage.VoteStorage;

import java.util.List;
import java.util.Map;

public class VoteService {
    private VoteStorage storage;

    public VoteService(VoteStorage storage) {
        this.storage = storage;
    }

    public void addVote(String artist, String[] genres, String about) {
        this.storage.getAbout().add(about);

        Integer artistPosition = this.storage.getArtist().getOrDefault(artist, 0);
        this.storage.getArtist().put(artist, ++artistPosition);

        if (genres != null) {
            for (String genre : genres) {
                Integer genrePosition = this.storage.getGenre().getOrDefault(genre, 0);
                this.storage.getGenre().put(genre, ++genrePosition);
            }
        }
    }

    public Map<String, Integer> getArtist(){
        Map<String, Integer> artist = this.storage.getArtist();
        return artist;
    }
    public Map<String, Integer> getGenre(){
        Map<String, Integer> genre = this.storage.getGenre();
        return genre;
    }
    public List<String> getAbout(){
        List<String> about = this.storage.getAbout();
        return about;
    }


}
