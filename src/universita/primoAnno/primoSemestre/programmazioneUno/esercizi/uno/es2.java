package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.uno;
/*
Scrivere un programma Java che esegua le seguenti operazioni:
•definisca due variabili double x e y;
•assegni alle variabili i valori 125.0 e 85.3;
•stampi a video i valori di x e y, il loro prodotto e la loro divisione.
a) Cosa succede se le variabili vengono inizializzate con i valori 125 e 85 ? -> Nulla
 */


public class es2 {

    public static void main(String[] args) {
        double x = 125.0, y = 85.3;
        System.out.printf("X = %.2f, Y = %.2f, X*Y = %.2f, X/Y = %.2f ", x, y, x*y, x/y);
    }
}
