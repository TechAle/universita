package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.quattro;

import java.util.Scanner;

public class es3 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int val = t.nextInt();

        if (val < 1) {
            System.out.print("Il valore deve essere positivo");
            return;
        }
        if (val == 1) {
            System.out.print("Risultato: 1");
            return;
        }
        int inizio = 1;
        int volte;
        while(val > 1) {

            volte = 0;
            inizio++;

            while (val % inizio == 0) {
                volte++;
                val /= inizio;
            }

            if (volte > 0) {
                System.out.printf("Numero: %d Volte: %d\n", inizio, volte);
            }


        }
    }
}
