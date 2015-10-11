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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MagicSquare magicSquare = new MagicSquare();
        System.out.println("Magic Square Solutions:");
        magicSquare.solve(0, 0);
    }
}
