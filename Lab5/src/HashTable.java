import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private final int INITIAL_CAPACITY = 11;
    private int capacity = INITIAL_CAPACITY;
    private int size = 0;
    private List<LinkedList<Entry>> entries;

    public HashTable() {

    }

    public List<LinkedList<Entry>> getEntries() {
        return entries;
    }

    public int getSize() {
        return size;
    }

    private int hash(String key) {
        return -1;
    }


    public void put(String key, String value) {

    }

    public String get(String key) {
        return null;
    }

    public void remove(String key) {

    }

    private void rehash() {

    }
}
