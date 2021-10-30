/*
Scrivere un programma Java che legga da tastiera un intero positivo, rappresentante la capacità in
kg  di uno zaino, e riceva una sequenza di interi positivi rappresentanti i pesi degli oggetti da
inserirvi, fino a che la somma dei pesi non eccede la capacità oppure viene letto da tastiera uno 0.
Al termine il programma deve stampare a video la capacità dello zaino, il numero e il peso totale
degli oggetti in esso contenuti, il peso dell’oggetto più pesante, il peso dell’oggetto più leggero, e il
peso medio degli oggetti presenti nello zaino.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre.cicli;

import java.util.Scanner;

public class es4 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int capacità = t.nextInt();
        int somma = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int temp;
        int values = 0;
        do {
            System.out.print("Val: ");
            temp = t.nextInt();
            values++;
            if (temp == 0)
                break;
            else {
                somma += temp;
                if (temp < min)
                    min = temp;
                if (temp > max)
                    max = temp;
            }
        }while (true);

        System.out.printf("Capacità: %d\nN^ oggetti: %d\nPiù pesante: %d\nPiù leggero: %d\nSomma: %d\nMedia: %.2f", capacità, values, max, min, somma, (double) somma / values);

    }
}
