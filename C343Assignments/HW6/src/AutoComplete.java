import java.io.IOException;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AutoComplete {
    private Trie trie;
    private String file = "dataset.txt"; // hardcoded for our testing purposes :p

    public AutoComplete() throws IOException {
        this.trie = new Trie();
        buildTrie();
    }

    public AutoComplete(String file) throws IOException {
        this.trie = new Trie();
        this.file = file;
        buildTrie();
    }

    public Trie getTrie(){
        return this.trie;
    }


    // TODO: Build the trie from the words from the file.
    /*
     * This method reads theword from the specific file, inserts them into
     * the trie, and measures the time taken for the operation.
     */
    public void buildTrie() throws IOException {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            System.out.print(file + " loaded. ");
            Instant start = Instant.now();
            String line;
            int wordCount = 0;
            while((line = reader.readLine()) != null){
                String text = line.toLowerCase();
                text = text.replaceAll("\\p{Punct}", "");
                String[] words = text.split("\\s+"); // splits by whitespace
                for(String word: words){
                    // TODO: add here 
                    trie.insert(word);
                    wordCount++;
                }
            }
            Instant end = Instant.now();
            long time = Duration.between(start, end).toMillis();
            System.out.print(wordCount + " words loaded into Trie in " + time + " ms\n");
        } catch (IOException e){
            throw e;
        }

    }


    // TODO: Returns a list of the top 6 ranked (frequency) words starting with the
    //       given prefix (must use BubbleSort)
    //       Hint: don't overthink this.
    
    /*
     * This method returns a list of the top 6 ranked (by frequencu) words 
     * starting with the given prefix. It traverses the trie and collects the 
     * relevent entries, and then applies bubblesort to sort them by frequency.
     * 
     */
    public ArrayList<Entry> autoComplete(String prefix){
        ArrayList<Entry> entries = new ArrayList<>();
        TrieNode prefixNode = trie.findPrefixNode(prefix);
        if (prefixNode != null) {
            traverseTrie(prefixNode, prefix, entries);
        }
        bubbleSort(entries);
        return entries;
    }

    private void traverseTrie(TrieNode currentNode, String word, ArrayList<Entry> entries) {
        if (currentNode.isWord()) {
            //entries.add(new Entry(word, currentNode.getFrequency()));

            entries.add(new Entry(currentNode.getFrequency(), word));
        }

        if (entries.size() >= 6) {
            return; // Stop traversing further if we have 6 entries already
        }

        List<Character> sortedKeys = new ArrayList<>(currentNode.getChildren().keySet());
        Collections.sort(sortedKeys);
        for (char c : sortedKeys) {
            TrieNode childNode = currentNode.getChildren().get(c);
            traverseTrie(childNode, word + c, entries);
        }
    }

    // TODO: Implement BubbleSort. Sort by frequency of the Entry. Return the list of entries sorted.
    //     Hint: https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2014/02/bubble-sort1.png
    /*
     * This method implements
     */
    public ArrayList<Entry> bubbleSort(ArrayList<Entry> ls){
        return ls;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file = input.nextLine();
        AutoComplete a = new AutoComplete(file);
        String answer = "y";
        while (answer.equals("y")) {
            System.out.print("Enter word to find prefix (0 to quit program): ");
            String term = input.nextLine();
            if(term.equals("0")){
                System.out.println("buh bye");
                break;
            }
            for(Entry e : a.autoComplete(term)){
                System.out.println(e);
            }
            System.out.println("==========================================");
        }
        input.close();

    }
}
