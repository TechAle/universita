/*
Scrivere un programma Java che calcoli la somma a+b tra due numeri interi non negativi (cioè
maggiori o uguali a 0) a e b in maniera ricorsiva, sfruttando la seguente definizione induttiva della
somma:
a + 0 = a
a + b = (a + 1) + (b – 1) per b > 0
Definire pertanto un metodo ricorsivo somma(a,b), che restituisce al chiamante il valore della
somma a+b. Basandosi sulla definizione induttiva data sopra, impostare la ricorsione sul secondo
parametro
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sette;

import java.util.Scanner;

public class es4 {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt(),
            b = new Scanner(System.in).nextInt();
        System.out.print(somma(a, b));
    }

    public static int somma(int a, int b) {
        if (b > 0)
            return somma(a + 1, b - 1);
        else return a;

    }
}
