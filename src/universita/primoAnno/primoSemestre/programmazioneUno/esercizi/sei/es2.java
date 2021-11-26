/*
crivere un programma Java che consenta all’utente di giocare a “Indovina la parola”.
Nel  metodo  main(),  il  programma  estrae  anzitutto  a  caso  una  stringa  da  un  array  di  stringhe
prefissato, definito all’interno del metodo estraiStringaCasuale()  della  classe  Metodi  (il  metodo
restituisce  al  chiamante  la  stringa  estratta).  Converte  poi  la  stringa  in  un  array  di  char,  ed  entra
quindi in un ciclo in cui:
 stampa  le  lettere  della  parola  indovinate  finora,  e  un  trattino  al  posto  di  quelle  non  ancora
indovinate. Ad esempio,  se  la  parola  segreta  è  automobile,  e  l’utente  ha  finora
indovinato che la parola contiene delle a, delle t e delle o, il programma stampa:
a-to-o----
Inizialmente,  quando  l’utente  non  ha  ancora  indovinato  nessuna  lettera,  il  programma
stamperà una sequenza di trattini, fornendo così al giocatore un’indicazione su quanto è
lunga la parola da indovinare;
 chiede all’utente di inserire una lettera (per semplicità, supporre che le parole siano tutte
formate solamente da lettere minuscole). Se la lettera non è presente nella parola, stampa un
messaggio appropriato, e poi riesegue il ciclo (stampa lettere e trattini, chiede di inserire una
lettera, ecc.). Similmente, se la lettera è già tra quelle indovinate allora stampa un messaggio
appropriato e riesegue il ciclo.
Il gioco termina quando l’utente ha indovinato la parola, oppure quando ha fatto 20 tentativi.
Per  la  stampa  delle  lettere  indovinate  finora  si  invochi  il  metodo stampaLettereIndovinate(),
passandogli gli opportuni argomenti. Per vedere se una lettera compare all’interno di una parola, e
in  tal  caso  rendere  visibili  tutte  le  occorrenze  della  lettera  nella  parola,  invocare  il  metodo
scopriLettera(), passandogli gli opportuni argomenti.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sei;

import java.util.Random;
import java.util.Scanner;

public class es2 {
    public static void main(String[] args) {

        String stringaCasuale = metodiEs2.estraiStringaCasuale();
        char[] stringaChar = new char[stringaCasuale.length()];
        char[] stringaCoperta = new char[stringaCasuale.length()];
        for(int i = 0; i < stringaChar.length; i++) {
            char carattere =  stringaCasuale.charAt(i);
            stringaChar[i] = carattere;
            stringaCoperta[i] = carattere == ' ' ? ' ' : '-';
        }

        int tentativi = 0;
        boolean ciclo = true;
        Scanner t = new Scanner(System.in);
        do {
            metodiEs2.stampaLettereIndovinate(stringaCoperta);
            System.out.print("\nLettera: ");
            char indovinata = t.nextLine().charAt(0);

            switch (metodiEs2.scopriLettera(stringaChar, stringaCoperta, indovinata)) {
                case 1:
                    System.out.println("Lettera azzeccata");
                    boolean found = true;
                    for(int i = 0; i < stringaCoperta.length; i++)
                        if (stringaCoperta[i] == '-') {
                            found = false;
                            break;
                        }
                    if (found)
                        ciclo = false;
                    break;
                case 0:
                    System.out.println("Lettera non esiste");
                    break;
                case -1:
                    System.out.println("Lettera già inserita");
                    break;
            }
        }while (ciclo && ++tentativi < 20);
        if (tentativi == 20)
            System.out.println("La frase era " + stringaCasuale);



    }
}

class metodiEs2 {

    public static String[] listaStringe = new String[] {
            "Fantasia yeee"
    };


    public static String estraiStringaCasuale() {
        return listaStringe[new Random().nextInt(listaStringe.length)];
    }

    public static void stampaLettereIndovinate(char[] indovinate) {
        for(char val : indovinate)
            System.out.print(val);
    }

    /*
        1 -> Indovinata
        0 -> Non trovata
        -1 -> Già inserita
     */
    public static int scopriLettera(char[] indovinate, char[] frase, char input) {
        boolean found = false;
        for(int i = 0; i < indovinate.length; i++) {
            if (frase[i] == input)
                return -1;
            if (indovinate[i] == input) {
                frase[i] = input;
                found = true;
            }
        }

        return found ? 1 : 0;

    }
}
