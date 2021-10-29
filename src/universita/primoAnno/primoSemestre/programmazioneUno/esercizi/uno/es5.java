package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.uno;
/*
Scrivere un programma Java che esegua le seguenti operazioni:
•inizializzi due variabili intere x e y;
•assegni alle variabili due valori a scelta;
•calcoli l’area del rettangolo di lati x e y;
•stampi a video le misure dei lati e l’area del rettangolo, in modo che l’output abbia la
forma seguente:
> Lato1 = (valore di x)
> Lato2 = (valore di y)
> Area = (area calcolata)
 */


public class es5 {

    public static void main(String[] args) {
        int x = 4, y = 2;
        double area = x*y;
        System.out.printf(">Lato1 = %d\n>Lato2 = %d\n>Lato3 = %.2f", x, y, area);
    }
}
