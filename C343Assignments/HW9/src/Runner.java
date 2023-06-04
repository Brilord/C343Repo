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

    public static void main(String[] args) throws IOException {
        // Read input file name from command line argument
        if (args.length < 1) {
            System.out.println("Usage: java Runner <input_file>");
            System.exit(1);
        }
    
        // Read input file
        String inputFile = args[0];
        File file = new File(inputFile);
        Scanner scanner = new Scanner(file);
    
        // Read the picture from the input file
        Picture picture = new Picture(scanner.next());
    
        // Create a SeamCarver object
        SeamCarver seamCarver = new SeamCarver(picture);
    
        // Read and perform operations
        while (scanner.hasNext()) {
            String operation = scanner.next();
            if (operation.equals("findVerticalSeam")) {
                int[] vSeam = seamCarver.findVerticalSeam();
                System.out.println(Arrays.toString(vSeam));
            } else if (operation.equals("findHorizontalSeam")) {
                int[] hSeam = seamCarver.findHorizontalSeam();
                System.out.println(Arrays.toString(hSeam));
            } else if (operation.equals("removeVerticalSeam")) {
                int[] seam = new int[picture.height()];
                for (int i = 0; i < seam.length; i++) {
                    seam[i] = scanner.nextInt();
                }
                seamCarver.removeVerticalSeam(seam);
            } else if (operation.equals("removeHorizontalSeam")) {
                int[] seam = new int[picture.width()];
                for (int i = 0; i < seam.length; i++) {
                    seam[i] = scanner.nextInt();
                }
                seamCarver.removeHorizontalSeam(seam);
            }
        }
    
        // Close the scanner
        scanner.close();
    }
    
}
