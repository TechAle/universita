/*
    Copiato un pò da
    https://github.com/BrockDeveloper/Algoritmo-K-Means/tree/main
    Siccome, mio dio il pdf non spiega molto bene.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.allenamento;

import java.util.Random;
import java.util.Scanner;

public class kMeans {

    /*
        M -> Numero di oggetti
        N -> Numero di caratteristiche
        K -> Numero di cluster
        alpha -> Soglia di terminazione dell'algoritmo
        iter -> Numero massimo iterazioni
     */
    public static boolean DEBUG = true;
    public static final int K = 4;
    public static final double alpha = 0.1;
    public static final int iter = 1000;


    public static void main(String[] args) {
        int[] MandN = kMeansMetodi.getMandN();
        int M = MandN[0];
        int N = MandN[1];

        /// Inizializzazione
        // Variabili
        double[][] dati = new double[M][N];
        kMeansMetodi.inizializzaDati(dati);
        System.out.println("Array: ");
        kMeansMetodi.stampaMatrice(dati);
        int[] cluster = new int[N];
        double[][] centri = new double[K][N];
        kMeansMetodi.inizializzaCluster(centri, dati);
        double obiettivo = 0;
        double lastObiettivo = 0;
        double precisione = 0;
        int i = 0;

        do {
            kMeansMetodi.calcolaCluster(cluster, dati, centri);
            kMeansMetodi.aggiornaCentri(cluster, dati, centri);
            double tempObiettivo = kMeansMetodi.calcolaObiettivo(cluster, dati, centri);
            precisione = Math.abs(obiettivo - tempObiettivo);
            lastObiettivo = obiettivo;
            obiettivo = tempObiettivo;
        } while ((precisione > alpha) && (++i < iter));

        System.out.println("Cluster: ");
        kMeansMetodi.stampaArray(cluster);
        System.out.println("Iterazioni fatte: " + i);
        System.out.printf("Obiettivo nelle ultime 2 iterazioni: %f %f", obiettivo, lastObiettivo);
        System.out.println("Precisione: " + precisione);
        if (precisione <= alpha)
            System.out.println("Precisione raggiunta");
        else System.out.println("Iterazione massima");
    }

}

class kMeansMetodi {
    public static int[] getMandN() {
        if (kMeans.DEBUG) {
            return new int[]{10, 10};
        }
        int M, N;
        Scanner t = new Scanner(System.in);
        do {
            System.out.print("N: ");
            N = t.nextInt();
        } while (N <= 0);

        do {
            System.out.print("N: ");
            M = t.nextInt();
        } while (M <= 0);

        return new int[]{M, N};
    }

    public static void inizializzaDati(double[][] dati) {
        Random r = kMeans.DEBUG ? new Random(0) : new Random();
        for (int i = 0; i < dati.length; i++)
            for (int j = 0; j < dati[0].length; j++)
                dati[i][j] = r.nextDouble();
    }

    public static void inizializzaCluster(double[][] centro, double[][] dati) {
        Random r = kMeans.DEBUG ? new Random(0) : new Random();
        for (int i = 0; i < centro.length; i++)
            for (int j = 0; j < centro.length; j++)
                centro[i][j] = dati[r.nextInt(dati.length)][r.nextInt(dati[0].length)];
    }

    public static void stampaMatrice(double[][] array) {
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }
    }

    public static void stampaArray(int[] array) {
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /*
      per ogni oggetto calcola il cluster di appartenenza e memorizza il risultato in clusAter
      = Assegna ad ogni indice di cluster i dati più vicini
     */
    public static void calcolaCluster(int[] cluster, double[][] dati, double[][] centri) {
        for (int i = 0; i < dati.length; i++) {
            // Calcolo la prima distanza
            double distanzaMinore = distanzaEuclidea(dati[i], centri[0]);
            int indexMinore = 0;

            // Itera per ogni K
            for (int j = 1; j < kMeans.K; j++) {
                // Calcola distanza
                double distanza = distanzaEuclidea(dati[i], centri[j]);

                // Se minore, nuova distanza
                if (distanza < distanzaMinore) {
                    distanzaMinore = distanza;
                    indexMinore = j;
                }
            }

            // Nuovo index
            cluster[i] = indexMinore;
        }
    }

    /*
      che calcola i valori del centro di ogni cluster
      Il valore di ogni caratteristica ci del centro c di un dato cluster C si calcola come
      la media delle caratteristiche degli elementi del cluster:
     */
    public static void aggiornaCentri(int[] cluster, double[][] dati, double[][] centri) {
        /*
            Riassunto, dobbiamo fare la media dei vari cluster
         */
        for (int i = 0; i < centri.length; i++) {
            double[] somma = new double[cluster.length];
            int nValori = 0;

            // Iteriamo per ogni valore di dati e, se combacia con il cluster, iniziamo la media
            for (int j = 0; j < dati.length; j++) {
                if (cluster[j] == i) {
                    nValori++;

                    // Ora si salvano tutti i dati
                    for (int k = 0; k < dati[0].length; k++)
                        somma[k] = dati[j][k];
                }
            }

            // Calcolo media
            for (int j = 0; j < somma.length; j++)
                somma[j] /= nValori;

            // Aggiorno i centri
            for (int j = 0; j < somma.length; j++)
                centri[i][j] = somma[j];
        }

    }

    public static double distanzaEuclidea(double[] m1, double[] m2) {
        int somma = 0;
        // Sommatoria da 1 a N di (m1 - m2)^2
        for (int i = 0; i < m1.length; i++)
            somma += Math.pow((m1[i] - m2[i]), 2);

        // E poi si fà la radice
        return Math.sqrt(somma);
    }


    public static double calcolaObiettivo(int[] cluster, double[][] dati, double[][] centri) {
        /*
            La formula è la somma di tutte le distanze euclidiane fra i nostri dati e i centri
         */
        double distanza = 0;
        for(int i = 0; i < dati.length; i++) {
            distanza += distanzaEuclidea(dati[i], centri[cluster[i]]);
        }

        return distanza;
    }
}
