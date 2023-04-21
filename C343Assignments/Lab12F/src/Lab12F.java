import java.util.Arrays;

public class Lab12F {

    /** UNIQUE PATHS BOTTOM UP
     *
     * You are standing at the top left of an m x n grid.
     * Your friend bet you a sizable amount of money that
     * they could count all the unique paths from the top
     * left of the grid to the bottom right faster than you.
     *
     * They do not know that you are an expert in
     * dynamic programming and will easily win this bet!
     *
     * TL;DR count the number of unique paths from the top
     * left square in a grid to the bottom right square.
     *
     * ex:
     *  in a 3 x 2 grid there are 3 unique paths
     *  [x marks a square in the path.]
     *
     *  x o       x x        x o
     *  x o       o x        x x
     *  x x       o x        o x
     *
     * IMPORTANT: This must be BOTTOM UP. That means NO recursion.
     *
     * @param n height of the grid
     * @param m width of the grid
     * @return number of unique paths
     */
    static int numberOfPaths(int n, int m) {
        //TODO
    }


    /** MAKE CHANGE TOP DOWN AND BOTTOM UP
     *
     * You destroyed your friend in the bet and now they
     * gotta pay up.
     *
     * The problem is they only have a single coin worth
     * more than the amount promised in the bet!
     *
     * So, just to flex, you decided to count the number
     * of unique permutations of change using your coins.
     * (That's kind of mean.)
     *
     * TL;DR Return the number of unique permutations of
     * different ways you could make change.
     *
     * ex:
     *  coins = [1, 2, 5]
     *  n = 3
     *  balance = 5
     *
     *  returns: 4
     *
     *  If you're curious, the permutations are:
     *  [1, 1, 1, 1, 1]
     *  [1, 1, 1, 2]
     *  [1, 2, 2]
     *  [5]
     *
     *  Note: Order does not matter. [1, 2, 3] is the same as [3, 2, 1]
     *
     * IMPORTANT: You must implement BOTH a TOP DOWN (Recursive) and
     * a BOTTOM UP (iterative) solution.
     *
     * @param coins array of the different types of coins
     * @param n length of the coins array
     * @param balance remaining balance left to make change for
     * @return the total number of possible permutations of change
     */
    static int makeChangeTopDown(int[] coins, int n, int balance) {
        //TODO
    }

    static int makeChangeBottomUp(int[] coins, int n, int balance) {
        //TODO
    }
}
