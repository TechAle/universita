package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.cinque;

import java.util.Scanner;

public class es5 {
    public static void main(String[] args) {
        boolean ciclo = true;
        Scanner t = new Scanner(System.in);
        do {
            menu();
            String scelta = t.nextLine();
            int val;
            switch (scelta.toLowerCase()) {
                case "1":
                    val = t.nextInt();
                    System.out.print(convertiDecInBin(val));
                    break;
                case "2":
                    val = t.nextInt();
                    System.out.print(convertiBinInDec(val));
                    break;
                case "x":
                    ciclo = false;
                    break;
            }
        }while (ciclo);
    }
    public static void menu() {
        System.out.println("1) D->B\n2) B->D");
    }

    public static int convertiDecInBin(int D) {
        // Non ho voglia di scrivere l'algoritmo
        return Integer.parseInt(Integer.toBinaryString(D));
    }

    public static int convertiBinInDec(int B) {
        // Non ho voglia di scrivere l'algoritmo
        return Integer.parseInt(String.valueOf(B), 2);
    }
}
