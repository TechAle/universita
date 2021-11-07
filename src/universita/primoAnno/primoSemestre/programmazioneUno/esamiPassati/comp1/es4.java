/*
Scrivere un programma Java, denominato EsameD.java che:
 legga da tastiera una stringa formata da lettere maiuscole;
 se la stringa letta contiene dei caratteri che non sono lettere maiuscole, il programma
termina immediatamente l’esecuzione;
 stampi a video tutte le rotazioni a sinistra della stringa letta. Ad esempio, se la stringa letta è
CHIAVE, il programma stamperà a video le seguenti stringhe (rotazioni di CHIAVE): HIAVEC
          IAVECH
          AVECHI
          VECHIA
          ECHIAV
          CHIAVE
 stampi a video quante sono le vocali contenute nella stringa e, per ogni vocale, quante volte compare nella stringa.
Norme di implementazione
Il programma deve essere realizzato utilizzando esclusivamente i concetti di programmazione presentati nella prima parte del corso. L’unico tipo di ciclo consentito è il while. Il programma deve essere realizzato in modo da non generare errori in compilazione.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.comp1;

import java.util.Scanner;

public class es4 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Input: ");
        String input = t.nextLine();
        char temp;
        int i = 0, j = 0, lunghezza = input.length();
        while (i < lunghezza) {
            if ((temp = input.charAt(i)) < 'A' || temp > 'Z') {
                System.out.print("Trovato carattere non maiuscolo");
                System.exit(-1);
            }

            i++;
        }

        i = 1;

        while(i < lunghezza + 1) {
            j = 0;
            while (j < lunghezza) {
                System.out.print(input.charAt((j + i) % lunghezza));
                j++;
            }
            System.out.print('\n');
            i++;
        }

        System.out.println("Le vocali nella stringa sono:");
        i = 0;
        int a = 0, e = 0, iVocale = 0, o = 0, u = 0;
        while(i < lunghezza) {
            switch (input.charAt(i)) {
                case 'a':
                    a++;
                    break;
                case 'i':
                    iVocale++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'u':
                    u++;
                    break;
                case 'e':
                    e++;
                    break;
            }
            i++;
        }
    }
}
