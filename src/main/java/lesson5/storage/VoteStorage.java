package lesson5.storage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteStorage implements Serializable {
    private static VoteStorage instance;

    static {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("quiz_storage"))) {
            instance = (VoteStorage) ois.readObject();
        } catch (FileNotFoundException e) {
            instance = new VoteStorage();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final Map<String, Integer> artist;
    private final Map<String, Integer> genre;
    private final List<String> about;

    private VoteStorage() {
        this.artist = new HashMap<>();
        this.genre = new HashMap<>();
        this.about = new ArrayList<>();
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

    public static VoteStorage getInstance() {
        return instance;
    }

    public void saveResult() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("quiz_storage"))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}