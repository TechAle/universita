package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.quattro;

import java.util.Scanner;

public class es2 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String  a = t.nextLine(),
                b = t.nextLine();

        int maxLen = Math.min(a.length(), b.length());
        int prefissoMassimo = 0;
        for(int i = 0; i < maxLen; i++) {
            if (a.charAt(i) == b.charAt(i))
                prefissoMassimo++;
            else break;
        }

        System.out.print("La parte in comune è: ");
        for(int i = 0; i < prefissoMassimo; i++)
            System.out.print(a.charAt(i));
    }
}
