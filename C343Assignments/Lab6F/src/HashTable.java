import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private final int INITIAL_CAPACITY = 11;
    private List<Entry> entries;
    private int size;
    private int capacity = INITIAL_CAPACITY;

    public HashTable() {
        entries = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++) {
            entries.add(null);
        }
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public int getSize() {
        return size;
    }

    /**
     * Generates the hash (index) for the given key and the number of collisions encountered. This should be computed
     * using double hashing; please implement the function according to the following requirements:
     *  - generate the previous prime from the capacity (given) and call it 'prevPrime'
     *  - 'hash1' is an int that is the hashcode of the key
     *  - 'hash2' is an int that is: 'prevPrime' - (hash1 % 'prevPrime')
     *  - the returned hash is ('hash1' + collisions * 'hash2') % capacity
     */
    private int hash(String key, int collisions) {
        int hash1 = key.hashCode();
        int prevPrime = previousPrime(capacity);
        int hash2 = prevPrime - (hash1 % prevPrime);
        return (hash1 + collisions * hash2) % capacity;
    }

    /**
     * Finds the prime immediately before the given number.
     */
    private int previousPrime(int number) {
        //https://stackoverflow.com/a/62823875
        for(int i = number - 1; i >= 2; i--) {
            boolean prime = true;
            for(int j = 2; j <= Math.sqrt(i); j++ ) {
                if(i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime == true) {
                return i;
            }
        }
        return 2;
    }

    /**
     * Inserts the given key-value pair into the HashTable or updates the value of the current Entry if the key is
     * already stored.
     */
    public void put(String key, String value) {
        int collision = 0;
        int index = hash(key, collision);
        Entry entry = entries.get(index);

        while(entries != null){
            if(entries.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
    }

    /**
     * Gets the value from the Entry in the HashTable containing the given key and returns it. Returns null if the key
     * was not found.
     */
    public String get(String key) {
        int hashCode = key.hashCode();
        int index = hashCode % capacity;
    }

    /**
     * If the key is found in the HashTable, marks the corresponding entry as a deleted (a tombstone).
     */
    public void remove(String key) {
        // TODO
    }

    /**
     * Increase the capacity of the 'entries' ArrayList (double the capacity then find the next prime) and puts the
     * key-value pairs of the smaller 'entries' into the
     */
    private void rehash() {
        int newCapacity = nextPrime(capacity * 2);
        List<Entry> newEntries = new ArrayList<>(newCapacity);
        for(int i = 0; i< newCapacity; i++) {
            newEntries.add(null);
        }
    }

    /**
     * Finds the prime immediately following the given number.
     */
    private int nextPrime(int number) {
        // https://stackoverflow.com/a/57904191
        BigInteger b = new BigInteger(String.valueOf(number));
        return (int) Long.parseLong(b.nextProbablePrime().toString());
    }
}
