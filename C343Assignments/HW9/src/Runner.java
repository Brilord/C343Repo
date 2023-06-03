import java.util.*;
import java.io.*;
/*
 * Author: Brian Won
 * Bloomington Indiana
 * 
 */
/*
 * In the runner class, we read the input file name from the command line 
 * argument andthen read the operation from the file. Based on the operation, we call the corresponding methods 
 * on the 'SeamCarver' object and print the results. The operaton includes 
 * finding vertical and horizonal seams, as well as removing vertical and horizonal seams.
 * 
 */
public class Runner {

    public static void main(String[] args) throws IOException{
        // TODO: write the runner so that it follows the same format as the directions
        // read input file name from command line argument
        if(args.length < 1) {
            System.out.println("Usage: java Runner <input_file>");
            System.exit(1);
        }

        // read input file
        String inputFile = args[0];
        File file = new File(inputFile);
        Scanner scanner = new Scanner(file);
        // read the picture from the input file
        Picture picture = new Picture(scanner.next());

        // create a SeamCarver object
        SeamCarver seeamCarver = new SeamCarver(picture);
        
        // read and perform the operation.
        while(scanner.hasNext()) {
            String operation = scanner.next();
            
        }
    }
}
