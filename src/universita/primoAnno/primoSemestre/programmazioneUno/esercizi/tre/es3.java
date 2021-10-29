/*
Scrivere un programma Java che calcoli il risultato di uno studente all’esame di Programmazione 1.
Il programma leggerà da tastiera:
il voto ottenuto nella parte di teoria (da 8 a +8 punti);
il voto ottenuto nella prova pratica (da 0 a 24 punti).
Memorizzati questi dati, procederà al calcolo del risultato in trentesimi, procedendo come segue. Il
risultato finale è la somma dei risultati. L’algoritmo di calcolo, però, prevede una protezione “anti-
smanettone”, per cui se il voto finale è maggiore o uguale a 18 ma il voto della prova teorica è
inferiore a 1 lo studente sarà comunque bocciato. Infatti:
se  il   voto   di   teoria   è  minore   o  uguale   a  zero,   e   la   somma   dei   voti   di  teoria   e   pratica   è
maggiore o uguale a 18, il programma stampa: “Bocciato, devi studiare di più la teoria”;
se il voto di teoria è minore o uguale a zero, e il voto di pratica è minore di 18, il programma
stampa: “Bocciato, devi studiare ed esercitarti di più”;
se il voto di teoria è maggiore di zero, e la somma dei voti di teoria e pratica è minore di 18,
il programma stampa: “Bocciato: devi esercitarti di più”;
se   la   somma   dei   voti   di   teoria   e   pratica   vale   31   o   32,   il   programma   stampa:
“Congratulazioni: 30 e lode!”.
In tutti gli altri casi il programma stampa “Il tuo voto è ”, seguito dal totale derivante dalla somma
dei punti di teoria e pratica.
Nota: questo non è l’algoritmo usato da noi per determinare veramente il voto all’esame!
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre;

import java.util.Scanner;

public class es3 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int     teoria = t.nextInt(),
                pratica = t.nextInt();

        int somma = teoria + pratica;
        // Anti smanettone.. Mi stai mica descrivendo!?!?!
        if (somma >= 18) {
            if (somma > 30) {
                System.out.print("30 e lode!");
            } else if (teoria <= 0) {
                System.out.print("Bocciato, devi studiare più teoria.");
            }
            else System.out.print("Passato con " + somma);
        } else {
            if (pratica < 18)
                System.out.print("Bocciato, devi esercitarti di più");
            else System.out.print("Bocciato.");
        }


    }
}
