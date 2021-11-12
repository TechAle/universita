/*
    "chiedere all utente di inserire 2 stringhe, devono contenere solamente numeri e devono essere della stessa lunghezza.
Se sbaglia, fagli ripetere l inserimento.
Una volta fatto, stampare il numero di cifre che sono uguali sia nella prima che seconda stringa nello stesso indice.
Poi, creare una terza stringa "dispari" dove deve contenere solo i numeri dispari delle 2 stringhe, di questa stringa:
Contare il numero di volte dove il numero cambia (es. 1121111 (cambia 2 volte)) e fare la medie dei vari numeri
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati;

import java.util.Scanner;

public class es5 {
    public static void main(String[] args) {
        String str1, str2;
        Scanner t = new Scanner(System.in);
        boolean ciclo = true;
        do {

            str1 = t.nextLine();
            str2 = t.nextLine();

            if (str1.length() != str2.length()) {
                System.out.println("Devono essere della stessa lunghezza");
            } else {
                boolean numeri = false;
                for(int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) < '0' || str1.charAt(i) > '9')
                        numeri = true;
                    if (str2.charAt(i) < '0' || str2.charAt(i) > '9')
                        numeri = true;
                }
                if (!numeri)
                    ciclo = false;
            }

        }while (ciclo);

        int count = 0;
        for(int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i))
                count++;
        }
        System.out.println("Uguali: " + count);

        String dispari = "";
        for(int i = 0; i < str1.length(); i++) {
            switch (str1.charAt(i)) {
                case '1':
                case '3':
                case '5':
                case '7':
                case '9':
                    //noinspection StringConcatenationInLoop
                    dispari += str1.charAt(i);
            }

            switch (str2.charAt(i)) {
                case '1':
                case '3':
                case '5':
                case '7':
                case '9':
                    //noinspection StringConcatenationInLoop
                    dispari += str2.charAt(i);
            }
        }

        System.out.println("Dispari: " + dispari);

        int differenze = 0;
        for(int i = 0; i < dispari.length() - 1; i++)
            if (dispari.charAt(i) != dispari.charAt(i + 1))
                differenze++;

        System.out.println("Differenze: " + differenze);

        float media = 0;
        for(int i = 0; i < dispari.length(); i++)
            media += dispari.charAt(i) - '0';

        if (dispari.length() != 0)
            media /= dispari.length();

        System.out.println("Media: " + media);
    }
}
