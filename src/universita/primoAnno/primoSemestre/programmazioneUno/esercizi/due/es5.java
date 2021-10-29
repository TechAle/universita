/*
Scrivere un programma Java che legga da tastiera un numero intero  n  compreso tra 0 e 127, e
stampi a video la sua rappresentazione in binario, usando sempre 7 bit. Se il numero inserito non è
compreso   tra   0   e   127,   il   programma   deve   stampare   un   messaggio   d’errore   e   terminare   subito
l’esecuzione.
Di seguito vengono presentati quattro esempi di I/O risultanti dall'esecuzione del programma Java
implementato:
Inserisci un numero: 123
La rappresentazione binaria di 123 e’: 1111011
Inserisci un numero: -123
Errore: il numero inserito deve essere compreso tra 0 e 127!
Inserisci un numero: 432
Errore: il numero inserito deve essere compreso tra 0 e 127!
Inserisci un numero: 3
La rappresentazione binaria di 3 e’: 0000011
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.due;

import java.util.Scanner;

public class es5 {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int value = t.nextInt();
        if (value < 0 || value > 127) {
            System.out.print("Non è in range");
            return;
        }

        StringBuilder risultato = new StringBuilder();
        while (value > 0) {
            if (value % 2 == 0)
                risultato.insert(0, '0');
            else risultato.insert(0, '1');
            value /= 2;
        }

        while (risultato.length() != 7)
            risultato.insert(0, '0');

        System.out.print(risultato);

    }


}
