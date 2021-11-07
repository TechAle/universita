/*
Scrivere un programma Java che, lette da tastiera due stringhe genoma e proteina, entrambe
formate dalle lettere A, C, G, T (che indicano rispettivamente Adenina, Citosina, Guanina e Timina,
le quattro basi azotate che compongono il DNA) stampi a video tutte le occorrenze della stringa
proteina all’interno della stringa genoma, senza usare i metodi substring() e indexOf() della
classe String.
Ad esempio, se genoma = ACCAGTCAGTGCAATC e proteina = AGT, il programma stamperà a
video:
La sequenza AGT compare in ACCAGTCAGTGCAATC nelle
seguenti posizioni: 4, 8
Si noti che la prima posizione ha indice 1.
Altro esempio: se genoma = AAAAAAA e proteina = AAA, il programma stamperà a video:
La sequenza AAA compare in AAAAAAA nelle seguenti
posizioni: 1, 2, 3, 4, 5
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.quattro;

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

        System.out.printf("Sequenza %s compare in %s\nin posizioni: ", genoma, proteina);

        for(int i = 0; i < genoma.length() - proteina.length(); i++) {
            boolean correct = true;
            for(int j = 0; j < proteina.length(); j++) {
                if (genoma.charAt(i + j) != proteina.charAt(j)) {
                    correct = false;
                    break;
                }
            }
            if (correct)
                System.out.print(i + 1 + " ");
        }

    }
}
