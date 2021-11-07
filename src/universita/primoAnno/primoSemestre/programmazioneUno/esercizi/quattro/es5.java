/*
La congettura di Collatz è un famoso problema matematico tuttora irrisolto. Tale congettura afferma
che,  partendo  da  un qualsiasi  numero  intero  positivo  n,  applicando  ripetutamente  le  seguenti
operazioni si ottiene una sequenza di interi che termina sempre con 1:
➢se n = 1, termina
➢se n è pari, poni n = n / 2
➢se n è dispari (maggiore di 1), poni n = 3n+1
Scrivere un programma Java che, letto da tastiera un intero positivo n, stampi a video la sequenza di
numeri ottenuti applicando ripetutamente le operazioni indicate sopra. Si noti che il programma
termina solo se la congettura di Collatz vale per il numero n inserito.
Ad esempio, se n = 10, il programma stamperà a video la sequenza: 10, 5, 16, 8, 4, 2, 1.
Variante:  Scrivere   un   programma   Java   che,   letto   da   tastiera   un   numero   intero   positivo
numeroMassimo, determini se la congettura di Collatz vale per ogni numero compreso tra 1 e
numeroMassimo.
Ad esempio, se numeroMassimo = 5, il programma stamperà a video:
Provo la congettura per n = 1 ... Ok, vale.
Provo la congettura per n = 2 ... Ok, vale.
Provo la congettura per n = 3 ... Ok, vale.
Provo la congettura per n = 4 ... Ok, vale.
Provo la congettura per n = 5 ... Ok, vale.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.quattro;

import java.util.Scanner;

public class es5 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int nMax = t.nextInt();

        for(int i = 1; i <= nMax; i++) {
            System.out.printf("Provo la congettura per n = %d: ", i);
            int valTemp = i;
            while (valTemp > 1) {
                valTemp = valTemp % 2 == 0 ? valTemp / 2 : 3*valTemp + 1;
                System.out.print(valTemp + " ");
            }
            System.out.print(" Ok, vale.\n");
        }
    }
}
