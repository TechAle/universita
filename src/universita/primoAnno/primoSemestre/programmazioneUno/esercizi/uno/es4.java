package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.uno;
/*
Scrivere un programma Java che esegua le seguenti operazioni:
•definisca due variabili carattere x e y;
•assegni alla variabile x il valore ’a’, alla variabile y il valore ’b’;
•stampi a video la stringa ab.
NOTA: utilizzando solo l’operatore + il risultato `e numerico, in quanto i caratteri
vengono codificati come numeri.
 */


public class es4 {

    public static void main(String[] args) {
        char x = 'a', y = 'b';
        System.out.print(x+""+y);
                        //  \-> Necessario perchè senò fa addizione
    }
}
