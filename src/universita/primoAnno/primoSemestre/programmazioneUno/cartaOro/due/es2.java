/*
Scrivere  un  programma  in  Java  che  legge  da  tastiera  due  stringhe  (non
necessariamente  lunghe  uguali)  la  prima  contenente  solo  lettere
dell’alfabeto minuscole, la seconda solo lettere dell’alfabeto maiuscole. Se
le stringhe lette non rispettano quanto richiesto il programma termina con
un messaggio di errore. Altrimenti il programma stampa a video tutte le
possibili  coppie  che  si  ottengono  abbinando  un  carattere  della  prima
stringa ad un carattere della seconda stringa.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.cartaOro.due;

import java.util.Scanner;

public class es2 {
    public static void main(String[] args) {
        System.out.print("Stringa: ");
        Scanner t = new Scanner(System.in);
        String prima = t.nextLine();

        boolean fine = false;
        int k;
        for(int i = 0; i < (k = prima.length()); i++) {
            char val = prima.charAt(i);
            if (val < 97 || val > 122) {
                fine = true;
                break;
            }
        }
        if (fine) {
            System.out.println("Stringa 1 non formattata correttamene");
            return;
        }

        System.out.print("Valore 1: ");
        int m = t.nextInt();
        if (m > k - 1) {
            System.out.println("Valore 1 non può essere più lungo della lunghezza della stringa");
            return;
        }

        System.out.print("Valore 2: ");
        int n = t.nextInt();
        if (n > k - 1) {
            System.out.println("Valore 2 non può essere più lungo della lunghezza della stringa");
            return;
        }


        int i = 0;
        while(true) {

            int pos = (m + n * i++) % k;

            if (pos == m && i != 1)
                break;


            char[] chars = prima.toCharArray();
            chars[pos] -= 32;

            System.out.println("Stringa: " + String.valueOf(chars));


        }
    }
}
