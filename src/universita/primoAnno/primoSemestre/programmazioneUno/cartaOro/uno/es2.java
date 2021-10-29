package universita.primoAnno.primoSemestre.programmazioneUno.cartaOro.uno;

import java.util.Scanner;

public class es2 {

    public static void main(String[] args) {
        double e = -1;

        while(e < 0) {
            System.out.print("e: ");
            Scanner s = new Scanner(System.in);
            e = s.nextDouble();

            if (e <= 0)
                System.out.println("Il numero deve essere maggiore di 0.");

        }

        int n = 0;

        while (!(1 - e < n / (n + 1.0))
                || !(n / (n + 1.0) <= 1)) {
            n++;
        }

        System.out.printf("e: %f n: %d", e, n);
    }

}
