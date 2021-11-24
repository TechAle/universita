/*
Scrivere un programma Java che permetta all’utente di convertire temperature da Fahrenheit a
Celsius o viceversa, fino a quando decide di uscire dal programma (gestire quindi un menù a 3
scelte: Fahrenheit → Celsius, Celsius → Fahrenheit, Uscita). Il programma dovrà contenere i
seguenti metodi:
➢menu(): stampa a video il menù per l’utente, e restituisce al chiamante la scelta effettuata;
➢convertiFinC(): prende come argomento una temperatura espressa in gradi Fahrenheit, e
restituisce al chiamante la temperatura corrispondente in gradi Celsius;
➢convertiCinF():   prende   come   argomento   una   temperatura   espressa   in   gradi   Celsius,   e
restituisce al chiamante la temperatura corrispondente in gradi Fahrenheit.
Si ricorda che le formule di conversione da Fahrenheit a Celsius, e viceversa, sono le seguenti:
➢C = (F – 32) / 1,8
➢F = 1,8*C + 32
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.cinque;

import java.util.Locale;
import java.util.Scanner;

public class es4 {
    public static void main(String[] args) {
        boolean ciclo = true;
        Scanner t = new Scanner(System.in);
        do {
            menu();
            String scelta = t.nextLine();
            double val;
            switch (scelta.toLowerCase()) {
                case "1":
                    val = t.nextDouble();
                    System.out.println(convertiFinC(val));
                    break;
                case "2":
                    val = t.nextDouble();
                    System.out.println(convertiCinF(val));
                    break;
                case "x":
                    ciclo = false;
                    break;
            }
        }while (ciclo);
    }
    public static void menu() {
        System.out.println("1) F->C\n2) C->F");
    }

    public static double convertiFinC(double F) {
        return (F - 32) / 1.8;
    }

    public static double convertiCinF(double C) {
        return 1.8*C+32;
    }


}
