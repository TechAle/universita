/*
Scrivere un programma Java che, letti in input due numeri interi, calcola la divisione tra interi.
Utilizzando il metodo exit(), il programma deve evitare la divisione per zero
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.due;

import java.util.Scanner;

public class es2 {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

        int     value1 = t.nextInt(),
                value2 = t.nextInt();

        if (value2 == 0)
            System.exit(-1);
        else System.out.print((double) value1 / value2);
    }

}
