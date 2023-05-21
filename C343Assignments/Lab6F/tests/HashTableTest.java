import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashTableTest {
    private HashTable<String, Integer> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    void testAdd() {
        hashTable.add("key1", 10);
        hashTable.add("key2", 20);
        hashTable.add("key3", 30);

        Assertions.assertEquals(3, hashTable.size());
        Assertions.assertEquals(10, hashTable.get("key1"));
        Assertions.assertEquals(20, hashTable.get("key2"));
        Assertions.assertEquals(30, hashTable.get("key3"));
    }

    @Test
    void testRemove() {
        hashTable.add("key1", 10);
        hashTable.add("key2", 20);
        hashTable.add("key3", 30);

        hashTable.remove("key2");

        Assertions.assertEquals(2, hashTable.size());
        Assertions.assertEquals(10, hashTable.get("key1"));
        Assertions.assertNull(hashTable.get("key2"));
        Assertions.assertEquals(30, hashTable.get("key3"));
    }

    @Test
    void testRehash() {
        hashTable.add("key1", 10);
        hashTable.add("key2", 20);
        hashTable.add("key3", 30);
        hashTable.add("key4", 40);
        hashTable.add("key5", 50);
        hashTable.add("key6", 60);

        Assertions.assertEquals(6, hashTable.size());

        hashTable.add("key7", 70);

        Assertions.assertEquals(7, hashTable.size());
        Assertions.assertEquals(70, hashTable.get("key7"));
    }

    @Test
    void testCollision() {
        hashTable.add("key1", 10);
        hashTable.add("key9", 90);
        hashTable.add("key17", 170);

        Assertions.assertEquals(3, hashTable.size());

        Assertions.assertEquals(10, hashTable.get("key1"));
        Assertions.assertEquals(90, hashTable.get("key9"));
        Assertions.assertEquals(170, hashTable.get("key17"));
    }
}
