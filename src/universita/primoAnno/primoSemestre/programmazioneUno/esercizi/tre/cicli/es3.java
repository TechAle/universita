/*
Scrivere un programma Java che legga da tastiera due numeri interi, base e esponente, il secondo
dei quali deve essere maggiore o uguale a 0, e calcoli l’elevamento del primo numero alla potenza
indicata dal secondo (non utilizzando il metodo Math.pow()). Si noti che base può anche essere
negativo o nullo.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre.cicli;

import java.util.Scanner;

public class es3 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int base = t.nextInt();
        int esponente = t.nextInt();
        if (esponente < 0) {
            System.out.print("l'esponente deve essere >= 0");
            return;
        }
        int risultato = 1;
        while (esponente-- > 0) {
            risultato *= base;
        }
        System.out.print(risultato);

    }
}
