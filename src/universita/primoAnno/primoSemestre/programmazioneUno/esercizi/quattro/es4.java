/*
Scrivere un programma Java che calcoli la somma di due numeri interi positivi letti da tastiera,
utilizzando solo operazioni di post-incremento e post-decremento.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.quattro;

import java.util.Scanner;

public class es4 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int n1 = t.nextInt(), n2 = t.nextInt();

        while (n2-- > 0)
            ++n1;

        System.out.print(n1);
    }
}
