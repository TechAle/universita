package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.casuali;

import java.util.Scanner;

public class impiccato {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String parola = t.nextLine();
        String nuovaParola = "";
        for(int i = 0; i < parola.length(); i++)
            nuovaParola += parola.charAt(i) == ' ' ? ' ' : '_';
        int maxTurns = 10;
        int turn = 0;
        char lettera;

        do {

            System.out.printf("Turno: %d\nParola. %s\nLettera: ", turn++, nuovaParola);
            lettera = t.nextLine().charAt(0);

            for(int i = 0; i < parola.length(); i++) {
                if (parola.charAt(i) == lettera)
                    nuovaParola = nuovaParola.substring(0, i) + lettera + nuovaParola.substring(i + 1);
            }



        }while (turn < maxTurns && !nuovaParola.equals(parola));


        System.out.print("Parola " + (nuovaParola.equals(parola) ? "" : "non ") + "indovinata");

    }
}
