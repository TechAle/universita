package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.comp1;

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
