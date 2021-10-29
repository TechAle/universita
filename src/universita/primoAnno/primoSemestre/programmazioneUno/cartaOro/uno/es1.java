package universita.primoAnno.primoSemestre.programmazioneUno.cartaOro.uno;
import java.util.Scanner;
/*
1)
Scrivere un programma in Java che legge da tastiera un numero naturale
n maggiore di zero e stampa a video il valore di an dove an è la
successione definita ricorsivamente come segue:

a0 = 2
an+1 = 3*an – 2

Esempio. Se n=5 il programma dovrà calcolare, a partire dal valore a0 = 2, i
seguenti valori:

a1= 3*a0 -2 = 3*2 -2= 4
a2= 3*a1 -2 = 3*4 -2= 10
a3= 3*a2 -2 = 3*10 -2= 28
a4= 3*a3 -2 = 3*28 -2= 82
a5= 3*a4 -2 = 3*82 -2= 244
 */

class es1 {
    public static void main(String[] args) {
        int n = -1;

        while(n < 0) {
            System.out.print("N: ");
            Scanner s = new Scanner(System.in);
            n = s.nextInt();

            if (n <= 0)
                System.out.println("Il numero deve essere maggiore uguale a 0.");

        }

        int a0 = 2;

        for(int i = 0; i < n; i++)
            System.out.println("a1=" + (a0 = 3*a0 - 2));
    }
}