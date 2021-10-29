/*
In tutti gli altri casi il programma stampa “Il tuo voto è ”, seguito dal totale derivante dalla somma
dei punti di teoria e pratica.
Nota: questo non è l’algoritmo usato da noi per determinare veramente il voto all’esame!
Esercizio 4  (Gioco della morra cinese a due giocatori)
Scrivere un programma Java che simuli il gioco della morra cinese. Il programma dovrà prendere in
ingresso due nomi con cui identificherà i due giocatori. I nomi verranno memorizzati in variabili di
tipo  String.  Per  ogni   giocata,  viene   chiesto   ad  entrambi  i   giocatori  di   inserire  una   parola   tra
"forbice",  "carta"  o  "pietra";   il   programma   dovrà   stampare   a   video   il   nome   del
vincitore. Se la parola in ingresso non è una delle tre previste, il programma dovrà avvisare che è
stato commesso un errore. Si ricordi che:
forbice vince su carta;
carta vince su pietra;
pietra vince su forbice.
Nel caso in cui entrambi i giocatori scelgono la stessa stringa, la giocata è pari.
Terminata una giocata, il programma dovrà chiedere se si intende farne un’altra. In caso  negativo,
terminerà immediatamente l’esecuzione (senza usare il metodo exit()); in caso affermativo, chiederà
nuovamente   ad   entrambi   i   giocatori   di   inserire   una   parola   tra  "forbice",  "carta"  o
"pietra", stamperà a video il nome del vincitore, e così via. */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre;

import java.util.Scanner;

public class es4 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String nome1, nome2, scelta1, scelta2;

        boolean partita = true;

        do {
            System.out.print("Nome 1: ");
            nome1 = t.nextLine();
            System.out.print("Nome 2: ");
            nome2 = t.nextLine();
            System.out.print("Giocata 1: ");
            scelta1 = t.nextLine().toLowerCase();
            System.out.print("Giocata 2: ");
            scelta2 = t.nextLine().toLowerCase();


            if (!(scelta1.equals("carta") || scelta1.equals("sasso") || scelta1.equals("forbice"))
                    || !(scelta2.equals("carta") || scelta2.equals("sasso") || scelta2.equals("forbice"))) {
                System.out.print("E' stata trovata una parola non identificata.");
                continue;
            }

            if (scelta1.equals(scelta2))
                System.out.print("La partita è finita in parità");
            else {
                boolean vinto = false;
                switch (scelta1) {
                    case "forbice":
                        if (scelta2.equals("carta"))
                            vinto = true;
                        break;
                    case "carta":
                        if (scelta2.equals("sasso"))
                            vinto = true;
                        break;
                    case "sasso":
                        if (scelta2.equals("forbice"))
                            vinto = true;
                        break;
                }
                System.out.println("Vincitore: " + (vinto ? nome1 : nome2));
            }

            String scelta;
            do {
                System.out.print("Continuare a giocare? (y/n)");
                scelta = t.nextLine();
            }while (scelta.charAt(0) != 'y' && scelta.charAt(0) != 'n');

            partita = scelta.charAt(0) == 'y';

        }while (partita);


    }
}
