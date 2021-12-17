/*
Scrivere un programma Java denominato EsameA.java che:
 legga da tastiera una sequenza di numeri interi maggiori o uguali a 0 (rifiutando quindi i
numeri negativi), fino a che non viene inserito lo 0;
 per ogni numero positivo ricevuto, escluso quindi lo 0 finale, aggiorni la somma sum, il
massimo max e il minimo min dei numeri letti;
 una volta fatto ciò, stampi a video il valore delle variabili sum, min e max;
 poi, calcoli la media (in virgola mobile) di tutti i prodotti i*j, con i intero che varia fra
max e sum e j intero che varia fra min e max;
 visualizzi infine il risultato dell’elaborazione, stampando a video il valore della media.
Norme di implementazione
Il programma deve essere realizzato utilizzando esclusivamente i concetti di programmazione presentati nella prima parte del corso. L’unico tipo di ciclo consentito è il while. Il programma deve essere realizzato in modo da non generare errori in compilazione.

 */
package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.appello1;

import java.util.Scanner;

public class es1 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int sum = 0, max = 0, min = -1;
        int temp;

        System.out.print("Numero: ");
        temp = t.nextInt();
        boolean isFirst = true;

        while (temp != 0 || isFirst) {
            if (temp > 0) {
                if (isFirst) {
                    max = temp;
                    min = temp;
                    isFirst = false;
                } else {
                    if (temp > max)
                        max = temp;
                    else if (temp < min)
                        min = temp;
                }
                sum += temp;
            } else if (temp < 0)
                System.out.println("Il numero deve essere maggiore di 0");

            if (temp != 0) {
                System.out.print("Numero: ");
                temp = t.nextInt();
            }
        }

        System.out.printf("Somma: %d\nMax: %d\nMin: %d\n", sum, max, min);

        double media = 0;
        int val = 0;
        int i = max, j = min;
        while(i < sum) {
            while (j < max) {
                media += i * j;
                val++;
                j++;
            }
            i++;
        }
        media /= val;



        System.out.printf("Media: %.2f\n", media);




    }
}
