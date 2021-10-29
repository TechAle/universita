/*
Scrivere un programma Java che legga da tastiera una stringa di 4 caratteri. Se la stringa non è di 4
caratteri, stampa un messaggio d’errore e termina l’esecuzione. Se ogni carattere è una cifra tra 0 e
9, calcola il numero intero rappresentato da tale stringa, altrimenti stampa un messaggio di errore.
Di   seguito   vengono   presentati   tre   esempi   di   I/O   risultanti   dall'esecuzione   del   programma   Java
implementato:
Inserisci una stringa di 4 caratteri: 123
La stringa non e’ di 4 caratteri!
Inserisci una stringa di 4 caratteri: 8192
Il numero corrispondente e’: 8192
Inserisci una stringa di 4 caratteri: 81a2
La stringa contiene caratteri non validi!
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.due;

import java.util.Scanner;

public class es4 {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String  messaggio = t.next();
        char temp;
        int risultato = 0;
        if (messaggio.length() == 4) {
            for(int i = 0; i < 4; i++)
                if ((temp = messaggio.charAt(i)) < '0' || temp > '9') {
                    System.out.print("Trovato un non numero lol");
                    System.exit(-1);
                } else risultato += temp - '0';

        } else {
            System.exit(-1);
        }

        System.out.print("Rsultato: " + risultato);
    }


}
