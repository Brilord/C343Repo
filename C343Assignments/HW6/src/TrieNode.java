import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;
    int frequency;

    // TODO: initialize the TrieNode's properties
    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
        frequency = 0;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean isWord) {
        this.isWord = isWord;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String toString() {
        return children.toString();
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isWord(boolean b) {
        return isWord;
    }

    

    

}
