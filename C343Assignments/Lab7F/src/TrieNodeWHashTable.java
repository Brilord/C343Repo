import java.util.HashMap;

public class TrieNodeWHashTable {
    boolean isWord;
    HashMap<Character, TrieNodeWHashTable> children;

    public TrieNodeWHashTable() {
        //TODO
        isWord = false;
        children = new HashMap<>();
    }

    public void setWordEnd(boolean b) {
        
    }
}

//In the context of hash tables, a trinode refers to a data structure that is used to represent a bucket in a hash
// table that contains three items or less.
//
//In a hash table, each element is stored in a bucket whose index is calculated by applying a
// hash function to the key of the element. If multiple elements have the same index, they are
// stored in the same bucket. In the case where a bucket contains only a few elements (typically three or less),
// it is often more efficient to represent the bucket using a trinode instead of a regular linked list.
//
//A trinode consists of three fields: a key field, a value field, and a next field. The key and value fields
// store the key-value pair of the element, while the next field is a pointer to the next element in the bucket.
// Because there are only a few elements in the bucket, using a trinode instead of a regular linked list can save memory
// and reduce the number of pointer dereferences required to access elements.
//
//When a bucket contains more than three elements, the trinode is typically expanded into a regular linked list, which can
// handle an arbitrary number of elements.