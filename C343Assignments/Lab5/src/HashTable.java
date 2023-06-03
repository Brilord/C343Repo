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
        for(int i = 0; i < capacity; i++) {
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
        // simple hash function to get an index for the key
        int hash = key.hashCode() % capacity;
        // insure the index is positive
        return hash < 0 ? hash + capacity : hash;
    }


    public void put(String key, String value) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries.get(index);
        for(Entry entry : bucket) {
            if(entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
        size++;
        if((double)size / capacity >= 0.75) {
            rehash();
        }
    }

    public String get(String key) {
        int collisions = 0;
        int index = hash(key, collisions);
        while(entries.get(index) != null) {
            if(((Entry) entries.get(index)).getKey().equals(key)) {
                return entries.get(index).getValue();
            }
            collisions++;
            index = hash(key, collisions);
        }
        return null;
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
