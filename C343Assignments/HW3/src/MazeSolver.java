import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Feel free to reuse from HW1

public class MazeSolver {
    static char[][] maze;
    static int m, n; // dimensions of the maze

    /*
    TODO: setMaze - sets up the board
    This method will take in a String, file, which is the path of the file we want to look at.
    Using BufferedReader and FileReader, write this method so that it sets the rows, m, and columns, n,
    to the first line of input. Then it fills the maze with the maze from the file.
     */
    public static void setMaze(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // Read the first line to get the dimensions
        String dimensions = reader.readLine();
        String[] dimensionsArr = dimensions.split(" ");
        m = Integer.parseInt(dimensionsArr[0]);
        n = Integer.parseInt(dimensionsArr[1]);
        // Initialize the maze array
        maze = new char[m][n];

        // Read the maze from the file
        for (int i = 0; i < m; i++) {
            String line = reader.readLine();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
        }
    }

    reader.close();
    }

    /*
    TODO: isValid - checks if a position on the board has not been visited and is within bounds
     */
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != '#';
    }


    /*
    TODO: Using a stack, solve the maze WITHOUT recursion.
    Pseudo:
    1) Push start position onto Stack.
    2) While it's not empty;
        3) Pop from the stack to get the current considered location
        4) If it's already explored ignore
        5) If it's the goal, return true
        6) If it's not the goal, then explore it.
        7) You will need to compute all the possible neighbors. Then push those on the stack
    8) Return false
     */

    public static boolean solveMazeStack(int x, int y)  throws EmptyStackE {
        return false;
    }

    // TODO: Using a queue, solve the maze. Be sure to explain your algorithm for full points.
    public static boolean solveMazeQueue(int x, int y) throws EmptyQueueE{
        Stack<int[]> stack = new Stack<>();
    boolean[][] visited = new boolean[m][n];

    // Push the starting position onto the stack
    stack.push(new int[]{x, y});

    while (!stack.isEmpty()) {
        int[] currPos = stack.pop();
        int currX = currPos[0];
        int currY = currPos[1];

        // If already visited, ignore
        if (visited[currX][currY])
            continue;

        // Mark as visited
        visited[currX][currY] = true;

        // If it's the goal, return true
        if (maze[currX][currY] == 'G')
            return true;

        // Explore neighbors and push them onto the stack
        if (isValid(currX - 1, currY))
            stack.push(new int[]{currX - 1, currY});
        if (isValid(currX + 1, currY))
            stack.push(new int[]{currX + 1, currY});
        if (isValid(currX, currY - 1))
            stack.push(new int[]{currX, currY - 1});
        if (isValid(currX, currY + 1))
            stack.push(new int[]{currX, currY + 1});
    }

    return false;
    }

    // TODO: Solve the board. Mode 1 = stack solving. Mode 2 = queue solving.
    // 1: stack
    // 2: queue
    public static boolean solve(String file, int mode) throws IOException, EmptyStackE, EmptyQueueE {
        setMaze(file);

    // Find the starting point (S)
    int startX = -1;
    int startY = -1;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (maze[i][j] == 'S') {
                startX = i;
                startY = j;
                break;
            }
        }
    }

    // Check if the maze can be solved based on the chosen mode
    boolean solved = false;
    if (mode == 1) {
        solved = solveMazeStack(startX, startY);
    } else if (mode == 2) {
        solved = solveMazeQueue(startX, startY);
    }

    System.out.println("Maze can be solved: " + solved);
    return solved;
    }


}