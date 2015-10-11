/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicsquare_lab9;

/**
 *
 * @author Ashley Bertrand
 */
public class MagicSquare {

    private int[][] magicSquare;
    private boolean[] available;

    public MagicSquare() {
        magicSquare = new int[3][3];
        available = new boolean[9];
        
        //initializing all indices in available to true
        for (int i = 0; i < available.length; i++) {
            available[i] = true;
        }
    }

    public void solve(int row, int col) {
        for (int i = 1; i <= 9; i++) {
            if (isAvailable(i)) {
                magicSquare[row][col] = i;
                available[i - 1] = false;
                //valid solution
                if (isFilledBoard()) {
                    if (isValidSolution()) {
                        printSolution();
                    }
                } else {
                    //moving to the next column
                    if (col != 2) {
                        solve(row, col + 1);
                    //moving to the next row
                    } else if (row != 2) {
                        solve(row + 1, 0);
                    }
                }
                //backtracking
                magicSquare[row][col] = 0;
                available[i - 1] = true;
            }
        }
    }

    //keeps track of which numbers have not been used
    public boolean isAvailable(int value) {
        if (available[value - 1] == true) {
            return true;
        }
        return false;
    }

    //returns true if a row adds to 15
    public boolean isValidRow(int row) {
        if (magicSquare[row][0] + magicSquare[row][1] + magicSquare[row][2] == 15) {
            return true;
        }
        return false;
    }

    //returns true if a column adds to 15
    public boolean isValidColumn(int col) {
        if (magicSquare[0][col] + magicSquare[1][col] + magicSquare[2][col] == 15) {
            return true;
        }
        return false;
    }

    //returns true if the diagonals add to 15
    public boolean isValidOnDiagonals() {
        if ((magicSquare[0][0] + magicSquare[1][1] + magicSquare[2][2] == 15) && (magicSquare[2][0] + magicSquare[1][1] + magicSquare[0][2] == 15)) {
            return true;
        }
        return false;
    }

    //factors in all summations
    public boolean isValidSolution() {
        for (int i = 0; i < magicSquare.length; i++) {
            if (!isValidRow(i) || !isValidColumn(i)) {
                return false;
            }
        }
        return isValidOnDiagonals();
    }

    //returns true once all numbers have been added to magicSquare
    public boolean isFilledBoard() {
        for (int i = 0; i < available.length; i++) {
            if (available[i]) {
                return false;
            }
        }
        return true;
    }

    public void printSolution() {
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare[i].length; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
