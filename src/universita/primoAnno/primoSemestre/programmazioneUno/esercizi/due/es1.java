// Scrivere un programma Java che calcola il valore assoluto di un numero intero, letto da tastiera.
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.due;
import java.util.Scanner;


public class es1 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int value = t.nextInt();
        // Math.abs(value)
        System.out.print(value < 0 ? -value : value);
    }
}
