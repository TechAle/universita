package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.uno;
/*
Scrivere un programma Java che esegua le seguenti operazioni:
•definisca due variabili intere x e y;
•assegni alle variabili i valori 3 e 5;
•stampi a video i valori di x e y.
a) Cosa succede se le variabili intere non vengono inizializzate? -> Errore
b) Cosa succede se le variabili intere vengono inizializzate con i valori 3.0 e 5.0 ? -> Errore
c) Cosa succede se le variabili intere vengono inizializzate con i valori ’a’ e ’b’ ? -> Intero ascii
 */


public class es1 {

    public static void main(String[] args) {
        int x = 'a', y = 'b';
        System.out.printf("X = %d, Y = %d", x, y);
    }
}
