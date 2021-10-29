package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.uno;
/*
Scrivere un programma Java che risolva le seguenti espressioni e ne stampi il risultato:
(a)
(13 + 9 + 6 −7) ∗2
(b)
[(2 + 3) ∗5] + [(2/3 + 5) ∗4] + [3 ∗(7 + 5 −13)]
(c)
[(3.4 + 5 −6.3) ∗4.3 + (3.5 ∗(−4))] ∗6
(d)
(x + y) ∗(x −y)
(e)
x2+ y2
(f)
(x + y) ∗(x −y)
(2x + y)2
Dove necessario, inserire al posto delle variabili dei valori a piacere. Scegliere un tipo di dato
adeguato per il risultato.
 */


public class es7 {

    public static void main(String[] args) {
        double x = 2, y = 10;
        System.out.printf("1) %d\n2) %.2f\n", (13+9+6-7)*2, (((2 + 3)*5)+((2/3.0 + 5) *4) + (3 *(7 + 5-13))));
        System.out.printf("3) %.2f\n4) %.2f\n", ((3.4 + 5 -6.3) *4.3 + (3.5 *(-4))) *6, (x+y)*(x-y));
        System.out.printf("5) %.2f\n6) %.2f", x*x+y*y, ((x+y)*(x-y))/Math.pow(2*x+y, 2));
    }
}
