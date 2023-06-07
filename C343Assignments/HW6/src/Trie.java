import java.util.ArrayList;
import java.util.HashMap;
public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public Trie(TrieNode root){
        this.root = root;
    }

    // Setters & Getters
    public TrieNode getRoot(){
        return this.root;
    }

    public void setRoot(TrieNode root){
        this.root = root;
    }

    // Actual methods -- part of Lab7
    // TODO:
    void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            HashMap<Character, TrieNode> children = currentNode.getChildren();
            if (children.containsKey(c)) {
                currentNode = children.get(c);
            } else {
                TrieNode newNode = new TrieNode();
                children.put(c, newNode);
                currentNode = newNode;
            }
        }
        currentNode.isWord(true);
        currentNode.setFrequency(currentNode.getFrequency() + 1);

    }

    // TODO:
    boolean search(String word) {
        return false;
    }

    /*
    TODO: Remove the TrieNodes associated with the word. There are 3 cases to be concerned with.
        - key is unique: no part of key contains another key nor is the key itself a prefix of another key in the trie: remove all nodes
        - key is prefix key of another key: unmark the leaf node
        - key has at least one other word as a prefix: delete the nodes from the end of the key :p
        This is NOT the delete you implemented in lab.
 */
    void delete(String word){
        delete(root, word, 0);
    }

    private boolean delete(TrieNode currentNode, String word, int level) {
        if (currentNode == null) {
            return false;
        }
        
        if (level == word.length()) {
            if (currentNode.isWord()) {
                currentNode.setWord(false);
                currentNode.setFrequency(0);
                return currentNode.getChildren().isEmpty();
            }
            return false;
        }

        char currentChar = word.charAt(level);
        TrieNode nextNode = currentNode.getChildren().get(currentChar);
        if (nextNode == null) {
            return false;
        }
        
        boolean shouldDeleteCurrentNode = delete(nextNode, word, level + 1);
        if (shouldDeleteCurrentNode) {
            currentNode.getChildren().remove(currentChar);
            return currentNode.getChildren().isEmpty();
        }
        return false;
    }
    // TODO: Gets all possible words with the prefix through traversing the Trie. If it's a word, then turn it into an Entry.
    //       If not, ignore. Put the Entry's into a list and return.
    //       Hint: Look at your MazeSolver with a stack for inspiration for the traversal.
    //       EX: If you have prefix "ca", then it should look at all combinations of the words starting with "ca".
    public ArrayList<Entry> generateWordsFromPrefix(String prefix){
        ArrayList<Entry> words = new ArrayList<>();
        TrieNode prefixNode = findPrefixNode(prefix);
        if (prefixNode != null) {
            traverseTrie(prefixNode, prefix, words);
        }
        return words;

    }
    private TrieNode findPrefixNode(String prefix) {
        TrieNode currentNode = root;
        for (char c : prefix.toCharArray()) {
            HashMap<Character, TrieNode> children = currentNode.getChildren();
            if (children.containsKey(c)) {
                currentNode = children.get(c);
            } else {
                return null;
            }
        }
        return currentNode;
    }
    private void traverseTrie(TrieNode currentNode, String word, ArrayList<Entry> words) {
        if (currentNode.isWord()) {
            //words.add(new Entry(word, currentNode.getFrequency()));
            words.add(new Entry(currentNode.getFrequency(), word));
        }

        HashMap<Character, TrieNode> children = currentNode.getChildren();
        for (char c : children.keySet()) {
            TrieNode childNode = children.get(c);
            traverseTrie(childNode, word + c, words);
        }
    }


}
