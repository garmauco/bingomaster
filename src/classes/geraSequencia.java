/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Arrays;
import java.util.Random;

/**
 **
 * @author Fernando
 */
public class geraSequencia {

    boolean salvar = false;
    int numero = 0;
    Random nr = new Random();
    int sq[] = new int[5];
    int sequencia;

    public int[] GeraSequencia(int i) {
        int ini;
        ini = i;
        for (int c = 0; c < sq.length; c++) {
            numero = ini + nr.nextInt(15);
            salvar = true;
            for (int cc = 0; cc < sq.length; cc++) {
                if (sq[cc] == numero) {
                    salvar = false;
                    c--;
                }
            }
            if (salvar) {
                sq[c] = numero;
            }
        }
        Arrays.sort(sq);
        return sq;
    }
}
