/*
Scrivere un programma Java che consenta all’utente di giocare a “Indovina il numero”.
Nel  metodo  main(),  il  programma  estrae  anzitutto  a  caso  un  numero  intero  compreso  tra  1  e  100,
invocando  il  metodo  estraiNumeroCasuale()  della  classe  Metodi.  Entra  poi  in  un  ciclo,  in  cui
chiede all’utente di indovinare il numero estratto a caso: chiede quindi di inserire da tastiera un
numero intero compreso tra 1 e 100, e dice all’utente se il numero inserito è corretto, è più piccolo o
è più grande di quello da indovinare.
Per rendere più intelligente il programma, memorizzare ad ogni iterazione:
 il  numero  più  piccolo,  tra quelli inseriti dall’utente,  che  sono  più  grandi  del  numero  da
indovinare;
 il  numero  più  grande,  tra quelli inseriti dall’utente,  che  sono  più  piccoli  del  numero  da
indovinare.
Così, se il numero da indovinare è 53, e l’utente inserisce i numeri 10, 80, 20, 83, il programma
potrà rispondere come segue:
 Il numero 10 e’ piu’ piccolo di quello da indovinare.
 Il numero 80 e’ piu’ grande di quello da indovinare.
 Il numero 20 e’ piu’ piccolo di quello da indovinare.
 Hai inserito 83, ma se gia’ ti avevo detto che il numero
   da indovinare e’ piu’ piccolo di 80...
Il  confronto  tra  il  numero  inserito  e  quello  da  indovinare  andrebbe  fatto  invocando  il  metodo
confrontaNumeri(numeroInserito,numeroDaIndovinare),  che  restituisce  1,  0,  1  a  seconda  che  il
numero inserito sia minore, uguale o maggiore del numero da indovinare.
Inoltre:
 per ogni numero da indovinare, il giocatore ha a disposizione al più 10 tentativi;
 al termine della partita riporta le seguenti informazioni relative alle ultime 5 partite:
o qual era il numero da indovinare
o se l’utente l’ha indovinato oppure no
o se l’utente ha indovinato il numero, con quanti tentativi lo ha fatto
 chiede poi all’utente se vuole giocare ancora, oppure se si vuole terminare il programma.
Suggerimento:  le  informazioni  relative  alle  ultime  5  partite  possono  essere  memorizzate  in  tre
array:  numeriDaIndovinare  (di  interi),  indovinato  (di  boolean),  e  numeroTentativi
(di interi). Gestire  l’aggiornamento  del contenuto di questi array tramite il metodo
aggiornaInformazioniPartite().
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sei;

import java.util.Random;
import java.util.Scanner;

public class es1 {
    public static void main(String[] args) {

        int[] numeriDaIndovinare = new int[5];
        boolean[] indovinato = new boolean[5];
        int[] nTentativi = new int[5];

        int partiteFatte = 0;

        do {
            int numeroCasuale = metodiEs1.estraiNumeroCasuale();
            System.out.print(numeroCasuale);
            int min = Integer.MIN_VALUE,
                    max = Integer.MAX_VALUE;
            boolean ciclo = true;
            int tentativi = 0;

            do {
                System.out.print("Numero: ");
                int inserito = new Scanner(System.in).nextInt();

                switch (metodiEs1.confrontaNumeri(inserito, numeroCasuale)) {
                    case 1:
                        if (inserito < max) {
                            max = inserito;
                            System.out.printf("Il numero %d è più grande\n", max);
                        }
                        else
                            System.out.printf("Hai inserito %d, ma se gia’ ti avevo detto che il numero %d è più grande...\n", inserito, max);
                        tentativi++;
                        break;
                    case -1:
                        if (inserito > min) {
                            min = inserito;
                            System.out.printf("Il numero %d è più piccolo\n", min);
                        }
                        else
                            System.out.printf("Hai inserito %d, ma se gia’ ti avevo detto che il numero %d è più piccolo...\n", inserito, min);
                        tentativi++;
                        break;
                    case 0:
                        ciclo = false;
                }

            } while (ciclo && tentativi < 10);

            System.out.print("Numero da indovinare: " + numeroCasuale);
            if (tentativi == 10)
                System.out.print(" numero non indovinato.");
            else System.out.printf(" numero indovinato con %d tentativi", tentativi );

            metodiEs1.aggiornaInformazionePartite(numeriDaIndovinare, indovinato, nTentativi, (partiteFatte < 5 ? partiteFatte++ : partiteFatte),
                    tentativi, numeroCasuale, tentativi != 10);


            System.out.print("\nVuoi continuare a giocare? (y/n)");
            String temp;
            if ((temp = new Scanner(System.in).nextLine()).length() > 0 && temp.charAt(0) != 'y')
                break;
        }while (true);

        System.out.print("Resoconto partite:\n");
        for(int i = 0; i < partiteFatte; i++)
            System.out.printf("Partita n^%d, Numero: %d, Tentativi: %d, Vinto: %s\n", i, numeriDaIndovinare[i], nTentativi[i], indovinato[i]);

    }
}

class metodiEs1 {
    public static int estraiNumeroCasuale() {
        return new Random().nextInt(100) + 1;
    }

    public static int confrontaNumeri(int numeroInserito, int numeroDaIndovinare) {
        //noinspection UseCompareMethod
        return    (numeroInserito > numeroDaIndovinare) ? 1
                : (numeroInserito < numeroDaIndovinare) ? -1
                : 0;
    }

    public static void aggiornaInformazionePartite(int[] daIndovinare, boolean[] indovinato, int[] tentativi, int partite,
                                                   int nTentativi, int nCasuale, boolean vinto) {
        int idx = 4;

        if (partite < 5)
            idx = partite;
        else {
            for(int i = 1; i  < 5; i++) {
                daIndovinare[i - 1] = daIndovinare[i];
                indovinato[i - 1] = indovinato[i];
                tentativi[i - 1] = tentativi[i];
            }
        }

        daIndovinare[idx] = nCasuale;
        indovinato[idx] = vinto;
        tentativi[idx] = nTentativi;
    }
}