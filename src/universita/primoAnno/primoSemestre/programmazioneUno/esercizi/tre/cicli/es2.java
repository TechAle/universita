/*
    Scrivere un programma Java che chieda all’utente di inserire da tastiera un numero intero n non
negativo (cioè positivo o nullo), e calcoli (usando un opportuno ciclo while) il fattoriale di n, cioè
il prodotto di tutti i numeri compresi tra 1 e n. Si ricorda che, per definizione, il fattoriale di 0 è 1.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre.cicli;

import java.util.Scanner;

public class es2 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int value;
        do {
            value = t.nextInt();
        }while (value < 1);
        int fattoriale = 1;
        while (value > 1) {
            fattoriale *= value--;
        }
        System.out.print(fattoriale);
    }
}
