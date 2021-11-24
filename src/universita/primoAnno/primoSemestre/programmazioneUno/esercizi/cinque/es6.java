/*
Scrivere un programma Java che, lette da tastiera due stringhe genoma e proteina, entrambe
formate dalle lettere A, C, G, T (che indicano rispettivamente Adenina, Citosina, Guanina e Timina,
le quattro basi azotate che compongono il DNA) stampi a video tutte le occorrenze della stringa
proteina all’interno della stringa genoma, usando i metodi substring() e indexOf() della classe
String (a differenza della scorsa esercitazione, in cui si chiedeva di non usarli). Tuttavia, anziché
invocare i metodi della classe String, fare finta che non si possano usare e reimplementarli (nella
stessa classe del metodo main()).
Ad esempio, se genoma = ACCAGTCAGTGCAATC e proteina = AGT, il programma stamperà a
video:
La sequenza AGT compare in ACCAGTCAGTGCAATC nelle
seguenti posizioni: 4, 8
Si noti che la prima posizione ha indice 1.
Altro esempio: se genoma = AAAAAAA e proteina = AAA, il programma stamperà a video:
La sequenza AAA compare in AAAAAAA nelle seguenti
posizioni: 1, 2, 3, 4, 5
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.cinque;

import java.util.Scanner;

public class es6 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String genoma = t.nextLine().toUpperCase(), proteina = t.nextLine().toUpperCase();

        boolean problema = false;
        //noinspection DuplicatedCode
        for(int i = 0; i < genoma.length(); i++) {
            if (!(genoma.charAt(i) == 'A' || genoma.charAt(i) == 'C' || genoma.charAt(i) == 'G' || genoma.charAt(i) == 'T')) {
                problema = true;
                break;
            }


        }

        if (problema) {
            System.out.print("Genoma non corretta");
            return;
        }

        //noinspection DuplicatedCode
        for(int i = 0; i < proteina.length(); i++) {
            if (!(proteina.charAt(i) == 'A' || proteina.charAt(i) == 'C' || proteina.charAt(i) == 'G' || proteina.charAt(i) == 'T')) {
                problema = true;
                break;
            }
        }
        if (problema) {
            System.out.print("Proteina non corretta");
            return;
        }

        int trovati = 0;
        int temp;
        System.out.printf("Sequenza %s compare in %s\nin posizioni: ", genoma, proteina);
        while ((temp = indexOf(genoma, proteina)) != -1) {
            genoma = subString(genoma, 0, temp) + subString(genoma, temp + 1);
            //genoma = genoma.substring(0, temp) + genoma.substring(temp + 1);
            System.out.print(temp + ++trovati + " ");
        }


    }

    public static String subString(String input, int start) {
        String output = "";
        for(int i = start; i < input.length(); i++)
            output += input.charAt(i);
        return output;
    }

    public static String subString(String input, int start, int end) {
        String output = "";
        for(int i = start; i < end; i++)
            output += input.charAt(i);
        return output;
    }

    public static int indexOf(String val, String aim) {
        if (val.length() < aim.length())
            return -1;
        for(int i = 0; i < val.length(); i++) {
            boolean found = true;
            for(int j = 0; j < aim.length(); j++) {
                if (val.charAt(i + j) != aim.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found)
                return i;
        }
        return -1;
    }
}
