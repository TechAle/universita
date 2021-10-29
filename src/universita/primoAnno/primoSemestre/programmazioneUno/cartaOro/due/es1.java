/*
Scrivere un programma in Java che legge da tastiera una stringa che deve
avere il seguente formato:

una prima sequenza di cifre che rappresenta un numero naturale

seguita da
carattere + oppure carattere –
seguito da

un'altra sequenza di cifre che rappresenta un altro numero naturale
...
...
fino ad un’ultima sequenza di cifre che rappresenta un ultimo naturale.

Se la stringa letta non rispetta il formato richiesto il programma termina
con  un  messaggio  di  errore.  Se  invece  lo  rispetta,  il  programma  deve
calcolare, stampandolo a video, il valore dell’espressione:
numero rappresentato dalla I sequenza di cifre
+ (oppure -, a seconda del carattere che appare nella stringa)
numero rappresentato dalla II sequenza di cifre
+ (oppure -, a seconda del carattere che appare nella stringa)
...
numero rappresentato dall’ultima sequenza di cifre

Esempio. Se la stringa letta è
“101+14-31+47-59-74”
il programma deve calcolare il valore
 */
package universita.primoAnno.primoSemestre.programmazioneUno.cartaOro.due;

import java.util.Scanner;

public class es1 {
    public static void main(String[] args) {
        System.out.print("Stringa 1: ");
        Scanner t = new Scanner(System.in);
        String prima = t.nextLine();
        System.out.print("Stringa 2: ");
        String seconda = t.nextLine();
        boolean end = false;

        for(int i = 0; i < prima.length(); i++) {
            char value;
            if ((value = prima.charAt(i)) < 97 || value > 121) {
                end = true;
                break;
            }
        }

        if (end) {
            System.out.println("La stringa 1 non rispetta la formattazione data");
            return;
        }

        for(int i = 0; i < seconda.length(); i++) {
            char value;
            if ((value = seconda.charAt(i)) < 41 || value > 90) {
                end = true;
                break;
            }
        }

        if (end) {
            System.out.println("La stringa 2 non rispetta la formattazione data");
            return;
        }

        System.out.println("Tutte le possibilità: ");
        for(int i = 0; i < prima.length(); i++) {
            char car = prima.charAt(i);
            for(int j = 0; j < seconda.length(); j++)
                System.out.println(car + "" + seconda.charAt(j));
        }
    }
}
