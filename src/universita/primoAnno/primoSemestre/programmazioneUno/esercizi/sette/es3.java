/*
Scrivere un programma Java che simuli le operazioni di accesso e modifica di un elemento in una
matrice bidimensionale, usando un array unidimensionale. In altre parole, il programma lavora su
un array unidimensionale array[] di interi, e i metodi scriviElemento() e leggiElemento()
specificati sotto danno l’illusione di lavorare con una matrice bidimensionale matrice[][] di
interi.
I metodi da implementare nella classe Metodi sono i seguenti, mentre il metodo main() della classe
Programma viene utilizzato per testare tali operazioni:
 creaMatrice(n,m): crea un array unidimensionale di n × m elementi interi, che verrà usato
per simulare una matrice di n righe ed m colonne, e ne restituisce un riferimento al
chiamante;
 scriviElemento(array,n,m,i,j,elemento): dato il riferimento ad un array unidimensionale di
n × m elementi, considerarlo come una matrice di n righe ed m colonne i cui elementi sono
memorizzati una riga dopo l'altra, e simulare l’operazione di assegnamento array[i][j]
= elemento. Il metodo non restituisce nulla al chiamante. Verificare che la lunghezza
dell’array sia effettivamente uguale a n × m, e che gli indici i e j non vadano fuori dalla
matrice; in caso contrario, stampare un messaggio d’errore e uscire dal programma;
 leggiElemento(array,n,m,i,j): i parametri sono da interpretare come nel metodo precedente.
Viene restituito al chiamante il valore dell’elemento array[i][j]. Anche in questo caso,
verificare che la lunghezza dell’array sia effettivamente uguale a n × m, e che gli indici i e j
non vadano fuori dalla matrice; in caso contrario, stampare un messaggio d’errore e uscire
dal programma;
 stampaMatrice(array,n,m): stampa gli elementi della matrice, una riga dopo l’altra, andando
a capo al termine di ogni riga. Per accedere agli elementi della matrice, questo metodo fa
uso del metodo leggiElemento(array,n,m,i,j)
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sette;

import java.util.Scanner;

public class es3 {

    static final int righe = 10;
    static final int colonne = 10;
    public static void main(String[] args) {
        int[][] array = metodiEs3.creaMatrice();
        boolean ciclo = true;
        do {
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    array = metodiEs3.creaMatrice();
                    break;
                case 2:
                    metodiEs3.aggiungiElemento(array, new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt());
                    break;
                case 3:
                    metodiEs3.rimuoviElemento(array, new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt());
                    break;
                case 4:
                    metodiEs3.leggiMatrice(array);
                    break;
                case 5:
                    ciclo = false;
            }
        }while (ciclo);

    }
}

class metodiEs3 {
    static int posizione;
    static int[][] creaMatrice() {
        posizione = 0;
        return new int[es3.righe][es3.colonne];
    }

    static void aggiungiElemento(int[][] reference, int i, int j, int val) {
        reference[i][j] = val;
    }

    /*
    Non capisco cosa dobbiamo fare.
    Qui faccio una fuznione che rimuove un elemento n volte e fà uno shift alla fine
     */
    static void rimuoviElemento(int[][] reference, int i, int j) {
        reference[i][j] = 0;
    }

    static int leggiElemento(int[][] reference, int i, int j) {
        return reference[i][j];
    }

    static void leggiMatrice(int[][] reference) {
        for(int i = 0; i < es3.righe; i++) {
            for (int j = 0; j < es3.colonne; j++)
                System.out.print(reference[i][j] + " ");
            System.out.println();
        }
    }
}