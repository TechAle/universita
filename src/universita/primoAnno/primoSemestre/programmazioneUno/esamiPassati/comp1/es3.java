package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.comp1;

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
