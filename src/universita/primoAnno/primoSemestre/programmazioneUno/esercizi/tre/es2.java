/*
Scrivere   un   programma   Java   che   chieda   all’utente   di   inserire   una   frase   tramite   tastiera   e,
utilizzando gli opportuni metodi sulle stringhe, esegua le seguenti operazioni:
se la frase contiene 2 o più parole:
◦stampi a video che la frase contiene due o più parole;
◦stampi a video la prima parola e la sua lunghezza;
◦stampi a video l’ultima parola e la sua lunghezza;
se la frase contiene una sola parola:
◦stampi a video che la frase contiene una sola parola;
◦stampi a video la parola e la sua lunghezza;
se la frase inserita è vuota:
◦stampi a video che la frase non contiene parole.
Per semplicità, si assuma che la frase non inizi e non finisca con degli spazi, e che ogni parola sia
separata   dalla   successiva   usando   un   solo   spazio.   Grazie   a   questa   assunzione,   le   parole   sono
individuabili semplicemente cercando gli spazi.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre;

import java.util.Scanner;

public class es2 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String frase = t.nextLine();

        if (frase.length() == 0) {
            System.out.print("Frase vuota");
        }

        String prima = "";
        String now = "";
        char ora;
        for(int i = 0; i < frase.length(); i++) {
            if ((ora = frase.charAt(i)) == ' ') {
                prima = now;
                now = "";
            } else {
                now = now + ora;
            }
        }

        if (prima.equals("")) {
            System.out.printf("1 sola frase trovata: %s lunghezza: %d", frase, frase.length());
        } else {
            System.out.printf("Trovate più frasi\n1 frase: %s Lunghezza: %d\nUltima frase: %s Lunghezza: %d", prima, prima.length(), now, now.length());
        }

    }
}
