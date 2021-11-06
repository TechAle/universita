package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.comp1;

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
