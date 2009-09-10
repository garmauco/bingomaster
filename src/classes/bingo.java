/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Fernando
 */
public class bingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        geraCartelas gc = new geraCartelas();
        gc.geraCartelas(10);

    }
}
