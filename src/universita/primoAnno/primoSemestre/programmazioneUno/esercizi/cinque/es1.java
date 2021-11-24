/*
Scrivere un programma Java che stampi a video gli elementi di posizione pari di una sequenza di
numeri interi positivi  inserita dall’utente. Il primo numero positivo avrà posizione 1, il secondo
posizione 2, ecc.; i numeri negativi vengono ignorati, e non incrementano la posizione; la sequenza
termina quando l’utente inserisce 0.
Il programma non deve usare array; costruirà invece la stringa di output man mano che l’utente
inserisce i numeri. Inoltre, il programma deve essere composto da due metodi:
➢il  main(), in cui si leggono i numeri interi, rifiutando quelli negativi con un messaggio
d’errore, e si mantiene la stringa che andrà stampata alla fine dell’esecuzione;
➢il metodo  aggiornaStringa(), che prende come argomento un numero intero positivo e la
stringa attuale di output, e restituisce al chiamante la nuova stringa di output, con il numero
aggiunto in fondo.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.cinque;

import java.util.Scanner;

public class es1 {

    public static String aggiornaStringa(String input, int val) {

        if (val > 0)
            input += val;

        return input;
    }

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String output = "";
        int temp;
        do {
            temp = t.nextInt();
            if (temp != 0)
                output = aggiornaStringa(output, temp);
            else break;
        }while (true);
        System.out.print(output);
    }
}
