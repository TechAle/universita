/*
Scrivere un programma Java che, letti da tastiera due numeri interi positivi  n  ed  m, calcoli il
quoziente e il resto della divisione intera tra n ed m usando solo sottrazioni successive (senza usare,
quindi, gli operatori / e %)
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre.cicli;

import java.util.Scanner;

public class es5 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int D1 = t.nextInt();
        int D2 = t.nextInt();

        int q = 0;
        int r = D1;
        while (r >= D2) {
            r = r - D2;
            q++;
        }
    }
}
