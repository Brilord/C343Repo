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

    }


    public void put(String key, String value) {

    }

    public String get(String key) {

    }

    public void remove(String key) {

    }

    private void rehash() {
        capacity = capacity * 2 + 1;
        List<LinkedList<Entry>> newEntries = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++) {
            newEntries.add(new LinkedList<>());
        }
        for(LinkedList<Entry> bucket : entries) {
            for(Entry entry : bucket) {

            }
        }
    }
}
