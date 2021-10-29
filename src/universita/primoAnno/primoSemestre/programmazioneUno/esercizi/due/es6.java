/*
Scrivere un programma Java che legga da tastiera due stringhe di 5 caratteri ciascuna, formate dai caratteri
+ e -. Ad esempio:
Inserisci la prima stringa: +++--
Inserisci la seconda stringa: -+--+
Se le stringhe inserite non sono entrambe di 5 caratteri, o se i caratteri sono diversi da + e -, il programma
stampa un messaggio d’errore e termina l’esecuzione.
Siano poi a e b due variabili intere, inizializzate rispettivamente con i valori 0 e 4.
La prima stringa indica le operazioni di incremento e di decremento da fare al valore della variabile  a;
analogamente, la seconda stringa indica le operazioni di incremento e decremento da applicare al valore della
variabile  b.   Il   programma   deve   applicare   il   primo   incremento/decremento   specificato   per   entrambe   le
variabili, poi il secondo incremento/decremento ad entrambe, e così via, stampando ogni volta a video i
valori  ottenuti  per  le  due  variabili.  Se dopo un incremento/decremento di entrambe  le variabili dovesse
capitare che a e b assumono lo stesso valore, stampare un messaggio a video e terminare l’esecuzione del
programma.
Segue un esempio di output prodotto dal programma, dopo aver inserito le due stringhe dell’esempio dato
sopra:
Il valore di a e’ 1, il valore di b e’ 3.
Il valore di a e’ 2, il valore di b e’ 4.
Il valore di a e’ 3, il valore di b e’ 3.
Le variabili a e b hanno assunto lo stesso valore!
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.due;

import java.util.Scanner;

public class es6 {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String  str1 = t.next(),
                str2 = t.next();
        boolean isDone = false;
        if (str1.length() == 5 && str2.length() == 5) {
            isDone = true;
            char tempA, tempB;
            int a = 0,
                b = 4;
            for(int i = 0; i < 5; i++) {
                if (!((tempA = str1.charAt(i)) == '+' || tempA == '-')
                    || !((tempB = str2.charAt(i)) == '+' || tempB == '-')) {
                    isDone = false;
                    break;
                } else {
                    a += tempA == '+' ? 1 : -1;
                    b += tempB == '+' ? 1 : -1;
                }
            }

            if (isDone) {
                if (a != b)
                    System.out.printf("Valore a: %d, Valore b: %d", a, b);
                else System.out.print("Le variabili a e b hanno assunto lo stesso valore!");
            }

        }

        if (!isDone) {
            System.out.print("Non hai inserito bene gli input");
        }

    }


}
