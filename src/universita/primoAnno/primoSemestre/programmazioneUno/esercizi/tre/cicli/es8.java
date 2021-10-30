/*
Scrivere un programma Java che, letti da tastiera due numeri interi positivi  n  ed  m, calcoli il
massimo comun divisore  MCD(n,m) usando l’algoritmo di Euclide, che si basa sulle seguenti
proprietà:
MCD(x,x) = x
MCD(x,y) = MCD(y,x)
MCD(x,y) = MCD(x-y,y)  se x > y
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre.cicli;

import java.util.Scanner;

public class es8 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int n = t.nextInt();
        int m = t.nextInt();
        int massimo = 1;
        if (n < m) {
            int temp = m;
            m = n;
            n = temp;
        }
        for(int i = 2; i <= m; i++) {
            if (m % i == 0 && n % i == 0) {
                massimo = i;
            }
        }

        System.out.print(massimo);


    }
}
