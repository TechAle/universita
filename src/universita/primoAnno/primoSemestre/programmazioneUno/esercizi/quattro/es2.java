/*
Scrivere un programma Java che, lette da tastiera due stringhe  a  e  b, calcoli la lunghezza del
massimo prefisso comune. Ad esempio, se a = cavallo e b = cavallerizza, il programma
stamperà a video:
Il massimo prefisso comune tra le stringhe “cavallo”
e “cavallerizza” ha lunghezza 6
in quanto cavall è la parte iniziale in comune ad entrambe le stringhe
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.quattro;

import java.util.Scanner;

public class es2 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String  a = t.nextLine(),
                b = t.nextLine();

        int maxLen = Math.min(a.length(), b.length());
        int prefissoMassimo = 0;
        for(int i = 0; i < maxLen; i++) {
            if (a.charAt(i) == b.charAt(i))
                prefissoMassimo++;
            else break;
        }

        System.out.print("La parte in comune è: ");
        for(int i = 0; i < prefissoMassimo; i++)
            System.out.print(a.charAt(i));
    }
}
