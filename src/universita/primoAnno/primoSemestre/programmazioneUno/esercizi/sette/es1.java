/*
Scrivere un programma Java che consenta all’utente di effettuare operazioni su un array di interi
parzialmente riempito. L’array può contenere da zero a un massimo di 100 elementi interi; il
numero di interi contenuto in un certo momento è indicato dalla variabile intera
numeroElementi. Le operazioni sono implementate come metodi della classe Metodi, mentre
il metodo main() della classe Programma viene utilizzato per testare tali operazioni.
Le operazioni da implementare nella classe Metodi sono le seguenti:
 creaArray(): alloca un array di 100 elementi interi, e ne restituisce un riferimento al
chiamante;
 aggiungiElemento(array,numeroElementi,elemento): aggiunge all’array specificato
(contenente attualmente numeroElementi valori, presenti dall’indice 0 all’indice
numeroElementi – 1) l’elemento specificato, se non c’è già, e in tal caso restituisce il
valore booleano true al chiamante. Se l’elemento è già presente nell’array, lascia l’array
inalterato e restituisce false. Si noti che se numeroElementi vale 100 non è possibile
inserire l’elemento specificato, anche se non è presente nell’array: in tal caso lasciare l’array
inalterato e restituire false al chiamante;
 rimuoviElemento(array,numeroElementi,elemento): rimuove dall’array, contenente
numeroElementi valori, l’elemento specificato, se c’è, e in tal caso restituisce il valore
booleano true al chiamante. Se l’elemento non è presente nell’array, lascia l’array
inalterato e restituisce false. Si noti che rimuovendo un elemento si può creare un “buco”
nella sequenza dei valori; gestire la cosa, facendo in modo che all’uscita del metodo i valori
validi presenti nell’array siano quelli con indice compreso tra 0 e numeroElementi – 2.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sette;

import java.util.Scanner;

public class es1 {
    /*
    Non capisco tanto il senso di questo programma-
    Ecco la mia interpretazione:
    Abbiamo un array e inseriamo un elemento n volte dall'ultimo indice
    nel caso non l'abbiamo già aggiunto.
    Qui ci metterò dei commenti siccome, come detto prima è una mia interpretazione.

    ATTENZIONE
    il codice fà veramente schifo.
     */
    static final int numeroElementi = 100;
    public static void main(String[] args) {
        int[] array = metodiEs1.creaArray();
        boolean ciclo = true;
        do {
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    array = metodiEs1.creaArray();
                    break;
                case 2:
                    if (metodiEs1.aggiungiElemento(array, new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt())) {
                        System.out.println("Aggiunto senza problemi");
                    } else {
                        System.out.println("Problemi trovati");
                    }
                    break;
                case 3:
                    if (metodiEs1.rimuoviElemento(array, new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt())) {
                        System.out.println("Rimosso senza problemi");
                    } else {
                        System.out.println("Problemi trovati");
                    }
                    break;
                case 4:
                    ciclo = false;
            }
        }while (ciclo);

    }
}

class metodiEs1 {
    static int posizione;
    static int[] creaArray() {
        posizione = 0;
        return new int[es1.numeroElementi];
    }

    static boolean aggiungiElemento(int[] reference, int nElementi, int elemento) {
        // Controllo che non esiste
        for(int i = 0; i < posizione; i++)
            if (reference[i] == elemento)
                return false;

        // Inizio ad aggiungere
        for(int i = 0; i < nElementi; i++) {
            if (posizione + i >= es1.numeroElementi)
                return false;
            reference[i] = elemento;
            posizione++;
        }

        return true;
    }

    /*
    Non capisco cosa dobbiamo fare.
    Qui faccio una fuznione che rimuove un elemento n volte e fà uno shift alla fine
     */
    static boolean rimuoviElemento(int[] reference, int nElementi, int elemento) {
        int fatti = 0;
        for(int i = 0; i < 100; i++) {
            if (i > posizione)
                return false;
            if (reference[i] == elemento) {
                // Faccio lo shifting
                //noinspection ManualArrayCopy
                for(int j = i; j < 99; j++) {
                    reference[j] = reference[j + 1];
                }
                reference[99] = 0;
                posizione--;
            }
        }
        return true;
    }
}