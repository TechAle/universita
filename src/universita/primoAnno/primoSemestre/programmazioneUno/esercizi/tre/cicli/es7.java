/*
Scrivere un programma Java che, letto da tastiera un numero  n maggiore o uguale a 0, calcoli
(usando un opportuno ciclo while) l’n-esimo numero della sequenza 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
di Fibonacci. Si ricorda che l’n-esimo numero di Fibonacci può essere definito come segue:
fib(0) = 0
fib(1) = 1
fib(n) = fib(n-1) + fib(n-2)  per n > 1
Tuttavia, questa è una definizione ricorsiva, mentre noi vogliamo un metodo iterativo per calcolare
il valore di fib(n)
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre.cicli;

import java.util.Scanner;

public class es7 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

        int n = t.nextInt();

        if (n < 0) {
            System.out.print("Numero non valido");
            return;
        }

        /*
            Pseudo code:
            def f(n):
                if n == 0:
                    return 1
                if n == 1:
                    return 3
                grandparent = 1
                parent = 3
                for i = 2 to n:
                    me = 3 * parent - grandparent
                    grandparent = parent
                    parent = me
                return me

         */

        int temp;
        int dopo = 3;
        int prima = 1;

        if (n > 1)
            for(int i = 0; i < n; i++) {
                temp = dopo;
                dopo = 3 * dopo -prima;
                prima = temp;
            }
        else if (n == 1) prima = 3;

        System.out.print("Fibunacci: " + prima);
    }
}
