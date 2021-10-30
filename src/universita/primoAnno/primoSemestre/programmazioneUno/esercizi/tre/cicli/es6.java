/*
Scrivere un programma Java che, lette da tastiera due stringhe formate da 0 e 1 di uguale lunghezza,
consideri tali stringhe come rappresentanti gli elementi di due insiemi. Ad esempio, se le stringhe
inserite dall’utente sono 01101 e 10110, abbiamo che:
il primo insieme, rappresentato dalla stringa 01101, contiene il secondo, terzo e quinto
elemento;
il secondo insieme, rappresentato dalla stringa 10110, contiene il primo, terzo e quarto
elemento.
Dopo aver verificato la validità delle stringhe inserite (devono essere composte solamente da 0 e 1,
e devono avere la stessa lunghezza), stampare a video le due stringhe corrispondenti all’unione e
all’intersezione dei due insiemi. Quindi, se l’utente inserisce le due stringhe 01101 e 10110 indicate
sopra, il programma stamperà la stringa 11111 come rappresentante dell’unione, e 00100 come
rappresentante dell’intersezione.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre.cicli;

import java.util.Scanner;

public class es6 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String str1 = t.next();
        String str2 = t.next();
        boolean isOk = true;
        if (str1.length() == str2.length()) {
            for(char i : str1.toCharArray())
                if (i != '0' && i != '1') {
                    isOk = false;
                    break;
                }
            if (isOk) {
                for(char i : str2.toCharArray())
                    if (i != '0' && i != '1') {
                        isOk = false;
                        break;
                    }
            }

            if (isOk) {
                System.out.print("Unione: ");
                for(int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) == '1' || str2.charAt(i) == '1')
                        System.out.print('1');
                    else System.out.print('0');
                }
                System.out.print("\nIntersezione: ");
                for(int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) == '1' && str2.charAt(i) == '1')
                        System.out.print('1');
                    else System.out.print('0');
                }
            }
        } else isOk = false;
        if (!isOk) {
            System.out.print("Le stringhe non sono corrette");
        }
    }
}
