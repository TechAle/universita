package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.quattro;

import java.util.Scanner;

public class es5 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int nMax = t.nextInt();

        for(int i = 1; i <= nMax; i++) {
            System.out.printf("Provo la congettura per n = %d: ", i);
            int valTemp = i;
            while (valTemp > 1) {
                valTemp = valTemp % 2 == 0 ? valTemp / 2 : 3*valTemp + 1;
                System.out.print(valTemp + " ");
            }
            System.out.print(" Ok, vale.\n");
        }
    }
}
