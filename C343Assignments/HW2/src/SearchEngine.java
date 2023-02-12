import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


// Pls can i get a partial credit. I am falling behind;(
public class SearchEngine {

    int mode;
    private List<Node> nodeList;
    Node node;
    String url;

    // TODO: build the SearchEngine's nodelist according to mode (1 = ArrayList; 2 = SortedArrayList); build the searchEngine
    public SearchEngine( int mode) throws IOException {
        //this.url = directory;
        if(mode == 1) {
            nodeList = new ArrayList<>();
            this.mode = 1;
        } else if(mode == 2) {
            nodeList = new SortedArrayList<>();
            this.mode = 2;
        }
    }

    public List<Node> getNodeList(){
        return this.nodeList;
    }

    // TODO: Go through the dataset and then create a new Node if the word hasn't been seen before. Add the current URL to its references
    // if it hasn't been seen. If the node has been created already, add the current URL to its references. Add the Node to the the
    // SearchEngine's nodeList
    public void buildList() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("dataset.txt"));
        //String url;
        while((url = reader.readLine()) != null){
            Document doc = Jsoup.connect(url).get();
            String text = doc.body().text().toLowerCase();
            String[] words = text.split("\\s+"); // splits by whitespace
            // logic here
            for(int i = 0; i < words.length-1; i++) {
                if(node == null) {
                    node = new Node(words[i],mode);
                    nodeList.add(node);
                }

                node.insertReference(words[i]);
            }
        }
        reader.close();
        System.out.println("Finished reading through all URLs");
    }

    // TODO: Return the node's reference list - if the term isn't found, return an empty list
    public List<Node> search(String term) throws IOException {
        System.out.println("Searching for " + term + " using data structure mode " + mode + "...");
        // Search logic goes here for reading url

        // Example code for displaying results
        buildList();

        if (nodeList == null) {
            System.out.println("No results found for " + term);
            return nodeList;
        } else {
            System.out.println("Displaying results for " + term + ":");
            for (int i = 0; i < nodeList.size(); i++) {
                // what should we print out? examples
                System.out.println(node.getKeyword() + ": " + node.getReferences());

            }
            return nodeList;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter mode as in what data structure to use:");
        System.out.println("    1. Array List ");
        System.out.println("    2. Sorted Array List");
        int mode = input.nextInt();

        System.out.println("Building Search Engine...");
        SearchEngine engine = new SearchEngine(mode);

        String answer = "y";
        while (answer.equals("y")) {
            System.out.println("    1. Array List ");
            System.out.println("    2. Sorted Array List");
            input.nextLine(); // consume the remaining newline character
            System.out.print("Search (enter a term to query): ");
            String term = input.nextLine();
            engine.search(term);
            System.out.print("Would you like to search another term (y/n)? ");
            answer = input.nextLine();
        }
        input.close();
    }
}
