/*
    Scrivere   un   programma   Java   che   faccia   inserire   all’utente   un   numero   intero   positivo  n,   e
successivamente una sequenza di numeri interi positivi. La sequenza non termina finché non viene
reinserito il numero n.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre.cicli;

import java.util.Scanner;

public class es1 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int n = t.nextInt();
        int scelta;

        do {
            scelta = t.nextInt();
        }while (scelta != n);
    }
}
