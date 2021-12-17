/*
Scrivere un programma Java, denominato EsameC.java che:
 legga da tastiera una stringa formata da lettere minuscole;
 se la stringa letta contiene dei caratteri che non sono lettere minuscole, il programma
termina immediatamente l’esecuzione;
 stampi a video quante sono le vocali contenute nella stringa;
 crei e stampi a video una stringa identica a quella che è stata inserita dall’utente, ma con le
consonanti in maiuscolo;
 calcoli e stampi a video la somma dei codici Unicode di ciascun carattere che compone la
stringa inserita dall’utente;
 calcoli e stampi a video la media (in virgola mobile) dei codici Unicode di ciascun carattere
che compone la stringa inserita dall’utente.
Norme di implementazione
Il programma deve essere realizzato utilizzando esclusivamente i concetti di programmazione presentati nella prima parte del corso. L’unico tipo di ciclo consentito è il while. Il programma deve essere realizzato in modo da non generare errori in compilazione.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.appello1;

import java.util.Scanner;

public class es3 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);

        System.out.print("Stringa: ");
        String input = t.nextLine();

        int i = 0, contVocali = 0, unicode = 0;
        char temp;
        String newStringa = "";
        while(i < input.length()) {

            if ((temp = input.charAt(i)) < 'a' || temp > 'z') {
                System.out.print("Trovata una lettere che non è minuscola");
                System.exit(-1);
            } else {
                /*
                switch (stringa.charAt(i)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u': numVocali++;
                 }
                 */
                if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                    contVocali++;
                    //noinspection StringConcatenationInLoop
                    newStringa += temp;
                } else {
                    //noinspection StringConcatenationInLoop
                    newStringa += (char)(temp - ('a' - 'A'));
                }
                unicode += temp;
            }
            i++;
        }

        System.out.printf("N^ Vocali: %d\nConsontanti minuscole: %s\nUnicode: %d\nMedia unicode: %.2f", contVocali, newStringa, unicode, (double) unicode / newStringa.length());


    }
}
