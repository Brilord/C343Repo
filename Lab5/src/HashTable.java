import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private final int INITIAL_CAPACITY = 11;
    private int capacity = INITIAL_CAPACITY;
    private int size = 0;
    private List<LinkedList<Entry>> entries;

    public HashTable() {
        entries = new ArrayList<>(capacity);
        for(int i = 0; i < capacity;i++) {
            entries.add(new LinkedList<>());
        }
    }

    public List<LinkedList<Entry>> getEntries() {
        return entries;
    }

    public int getSize() {
        return size;
    }

    private int hash(String key) {
        int hash = 0;
        for(int i = 0; i < key.length(); i++) {
            hash = hash * 31 + key.charAt(i);
        }
        return hash % capacity;
    }


    public void put(String key, String value) {
        int hash = hash(key);
        LinkedList<Entry> bucket = entries.get(index);
        for(Entry entry : bucket) {

        }
    }

    public String get(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries.get(index);
        for()
    }

    public void remove(String key) {

    }

    private void rehash() {

    }
}
