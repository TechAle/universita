/*
Scrivere   un   programma   Java   che   simuli   il   gioco   della   morra   cinese,   questa   volta   per   un   solo
giocatore che giochi contro il computer. Il computer deciderà se scegliere "forbice", "carta"
o "pietra" generando un numero casuale da 0 a 2 mediante l'espressione:
(int)(Math.random()*3)
In particolare:
se il numero estratto è 0 il computer sceglierà forbice;
se il numero estratto è 1 il computer sceglierà carta;
se il numero estratto è 2 il computer sceglierà pietra.
Una volta deciso il proprio simbolo, il computer domanderà all'utente di inserire il suo e dichiarerà
quindi il vincitore. Chiederà poi se si intende fare un’altra giocata (come nell’esercizio precedente),
e terminerà quando l’utente risponderà di no.*/
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre;

import java.util.Scanner;

public class es5 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String nome1, nome2, scelta1, scelta2;

        boolean partita = true;

        do {
            System.out.print("Giocata 1: ");
            scelta1 = t.nextLine().toLowerCase();


            if (!(scelta1.equals("carta") || scelta1.equals("sasso") || scelta1.equals("forbice"))) {
                System.out.print("E' stata trovata una parola non identificata.");
                continue;
            }

            switch ((int) (Math.random() * 3)) {
                case 0:
                    scelta2 = "forbice";
                    break;
                case 1:
                    scelta2 = "carta";
                    break;
                default:
                    scelta2 = "sasso";
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
                System.out.println("Hai " + (vinto?"vinto":"perso"));
            }

            String scelta;
            do {
                System.out.print("Continuare a giocare? (si/no)");
                scelta = t.nextLine();
            }while (!scelta.equals("si") && !scelta.equals("no"));

            partita = scelta.equals("si");

        }while (partita);


    }
}
