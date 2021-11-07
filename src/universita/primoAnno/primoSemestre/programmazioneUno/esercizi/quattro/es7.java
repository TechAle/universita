/*
Scrivere un programma Java che, lette da tastiera due stringhe composte dalle cifre da 0 a 9, che
rappresentano due numeri interi  n  e  m, calcoli il prodotto  n*m  usando l’algoritmo imparato alle
scuole elementari (e stampandone a video i passaggi). Ad esempio, se n = 2431 e m = 523, abbiamo:
    2431
    523
   ----
   7293
  4862
12155
-------
1271413
Quindi il programma stamperà a video (non necessariamente allineate come mostrato sopra) le
stringhe: 7293, 4862, 12155, 1271413.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.quattro;

import java.util.Scanner;

public class es7 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String s1 = t.next(), s2 = t.next();

        boolean problem = false;
        //noinspection DuplicatedCode
        for(int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) < '0' || s1.charAt(i) > '9') {
                problem = true;
                break;
            }
        if (problem) {
            System.out.print("Ci sono non numeri");
            return;
        }

        //noinspection DuplicatedCode
        for(int i = 0; i < s2.length(); i++)
            if (s2.charAt(i) < '0' || s2.charAt(i) > '9') {
                problem = true;
                break;
            }
        if (problem) {
            System.out.print("Ci sono non numeri");
            return;
        }



        // Trasformo stringa -> Intero senza l'utilizzo di comode funzione (uff)
        // Probabilmente questo metodo è stra insufficente lol
        int fattore1 = 0;
        int moltiplicazione = 1;
        for(int i = 0; i < s1.length(); i++)
            moltiplicazione*=10;
        moltiplicazione/=10;
        for(int i = 0; i < s1.length(); i++) {
            fattore1 += (s1.charAt(i) - '0')*moltiplicazione;
            moltiplicazione/=10;
        }

        // Questo serve solo per il calcolo della lunghezza totale
        int fattore2 = 0;
        moltiplicazione = 1;
        //noinspection DuplicatedCode
        for(int i = 0; i < s2.length(); i++)
            moltiplicazione*=10;
        moltiplicazione/=10;
        for(int i = 0; i < s2.length(); i++) {
            fattore2 += (s2.charAt(i) - '0')*moltiplicazione;
            moltiplicazione/=10;
        }


        // Calcoliamo la lunghezza totale della nostra divisione
        int moltiplicazioneTotale = fattore1 * fattore2;
        int lunghezzaTotale = 1;
        while (moltiplicazioneTotale > 9) {
            lunghezzaTotale++;
            moltiplicazioneTotale /= 10;
        }


        // Stampo fattore 1 e 2
        for(int i = 0; i < lunghezzaTotale - s1.length(); i++)
            System.out.print(' ');
        System.out.println(s1);

        // Stampo fattore 1 e 2
        for(int i = 0; i < lunghezzaTotale - s2.length(); i++)
            System.out.print(' ');
        System.out.println(s2);

        int len1 = s1.length(), len2 = s2.length();

        //noinspection ManualMinMaxCalculation
        int maxFat = len1 > len2 ? len1 : len2;
        for(int i = 0; i < lunghezzaTotale - maxFat; i++)
            System.out.print(' ');
        for(int i = 0; i < maxFat; i++)
            System.out.print('-');
        System.out.print('\n');



        // Il risultato precedente
        int prevResult = 0;
        // Aggiungiamo 0
        int addNewResult = 1;
        for(int i = 0; i < s2.length(); i++) {
            // Prendi il valore su cui iniziamo
            int value = s2.charAt(s2.length() - 1 - i) - '0';
            // Incrementa la moltiplicazione
            if (i != 0)
                addNewResult *= 10;

            int privaVal = value * fattore1;
            int tempPrivaVal = privaVal;

            int lenNumero = 1;
            while (tempPrivaVal > 9) {
                lenNumero++;
                tempPrivaVal /= 10;
            }
            lenNumero+=i;
            for(int j = 0; j < lunghezzaTotale - lenNumero; j++)
                System.out.print(' ');
            System.out.println(privaVal);



            // Risultato
            prevResult += value * fattore1 * addNewResult;

        }


        for(int i = 0; i < lunghezzaTotale; i++)
            System.out.print("-");
        System.out.println("\n" + prevResult);

    }
}
