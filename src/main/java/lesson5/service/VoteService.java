package lesson5.service;

import lesson5.storage.VoteStorage;

import java.util.List;
import java.util.Map;

public class VoteService {

    private final static VoteService instance = new VoteService();
    private final VoteStorage storage;

    private VoteService() {
        this.storage = VoteStorage.getInstance();
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
        storage.saveResult();
    }

    public Map<String, Integer> getArtistResult() {
        return this.storage.getArtist();
    }

    public Map<String, Integer> getGenreResult() {
        return this.storage.getGenre();
    }

    public List<String> getAboutResult() {
        return this.storage.getAbout();
    }

    public static VoteService getInstance() {
        return instance;
    }
}