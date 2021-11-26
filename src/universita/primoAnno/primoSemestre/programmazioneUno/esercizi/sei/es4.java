/*
Scrivere un programma Java che permetta all’utente di specificare il numero di righe e il numero di
colonne (entrambe comprese tra 1 e 10) di una matrice casuale di elementi interi (compresi tra 0 e
99), la stampi a video e poi ne calcoli e stampi a video la trasposta.
Si ricorda che la trasposta di una matrice M è la matrice MT ottenuta “scambiando” le righe con le
colonne: cioè, le righe di MT sono le colonne di M, e le colonne di MT sono le righe di M.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sei;

import java.util.Random;

public class es4 {
    public static void main(String[] args) {
        int[][] matrice = metodiEs4.generaMatriceCasuale(1, 2);
        metodiEs4.stampaMatrice(matrice);
        int[][] trasporta = metodiEs4.generaTrasporta(matrice);
        System.out.print('\n');
        metodiEs4.stampaMatrice(trasporta);
    }
}

class metodiEs4 {
    public static int[][] generaMatriceCasuale(int righe, int colonne) {
        int[][] output = new int[righe][colonne];
        for(int i = 0; i < righe; i++)
            for(int j = 0; j < colonne; j++)
                output[i][j] = metodiEs4.generaNumeroCasuale();
        return output;
    }

    public static int generaNumeroCasuale() {
        return new Random().nextInt(100);
    }

    public static void stampaMatrice(int[][] matrice) {
        for(int i = 0; i < matrice.length; i++) {
            for(int j = 0; j < matrice[0].length; j++)
                System.out.print(matrice[i][j] + " ");
            System.out.print('\n');
        }
    }

    public static int[][] generaTrasporta(int[][] matrice) {
        int[][] output = new int[matrice[0].length][matrice.length];

        for(int i = 0; i < matrice.length; i++) {
            for(int j = 0; j < matrice[0].length; j++) {
                output[j][i] = matrice[i][j];
            }
        }

        return output;
    }
}
