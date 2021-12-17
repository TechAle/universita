/*
Scrivere un programma Java denominato EsameB.java che:
 legga da tastiera un numero intero positivo n (rifiutando quindi eventuali numeri negativi o
nulli, e chiedendo nuovamente di inserire un intero positivo);
 legga da tastiera una sequenza di numeri interi positivi (rifiutando quindi numeri minori o
uguali a 0) fino a che non viene inserito nuovamente il numero n;
 per ogni numero letto, escluso n, aggiorni il prodotto prod, il massimo max e il minimo
min dei numeri letti;
 una volta fatto ciò, stampi a video i valori delle variabili prod, min e max;
 poi, calcoli la media (in virgola mobile) di tutte le somme i+j, con i intero che varia fra
max e prod e j intero che varia fra min e max;
 visualizzi infine il risultato dell’elaborazione, stampando a video il valore della media.
Norme di implementazione
Il programma deve essere realizzato utilizzando esclusivamente i concetti di programmazione presentati nella prima parte del corso. L’unico tipo di ciclo consentito è il while. Il programma deve essere realizzato in modo da non generare errori in compilazione.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.appello1;

import java.util.Scanner;

public class es2 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int n = -1;

        while(n < 1) {
            System.out.print("N: ");
            n = t.nextInt();
            if (n < 1)
                System.out.println("Il numero deve essere positivo");
        }

        int newNum = -1, min = -1, max = 0, prodotto = 0;
        while(newNum < 1 || newNum != n) {
            System.out.print("Nuovo numero: ");
            newNum = t.nextInt();

            if (newNum < 1)
                System.out.print("Il numero deve essere positivo");
            else if (newNum != n) {
                if (min == -1 || min > newNum) {
                    min = newNum;
                    prodotto = 1;
                }

                if (max < newNum)
                    max = newNum;
                prodotto *= newNum;
            }
        }

        System.out.printf("Min: %d\nMax: %d\nProdotto: %d", min, max, prodotto);

        int i = max, j = min, media = 0, cont = 0;
        while(i < prodotto) {
            while (j < max) {
                media += i + j;
                cont++;
                j++;
            }
            i++;
        }
        System.out.printf("Media: %.2f", (double) media/cont);
    }
}
