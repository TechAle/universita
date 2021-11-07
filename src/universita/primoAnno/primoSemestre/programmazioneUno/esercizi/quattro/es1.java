/*
Scrivere un programma Java che legga da tastiera un intero positivo  n  e stampi a video la più
piccola potenza di 2 maggiore di n
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.quattro;

import java.util.Scanner;

public class es1 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int n;

        do {
            n = t.nextInt();
        }while (n <= 0);

        int maxValue = 0
                ;

        while (Math.pow(2, ++maxValue) < n) {}

        System.out.print(--maxValue);
    }
}
