package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.uno;
/*
Scrivere un programma Java che esegua le seguenti operazioni:
•inizializzi tre variabili intere x, y e h;
•calcoli l’area del trapezio di basi x e y e altezza h;
•stampi a video le misure delle basi e dell’altezza e l’area del trapezio, in modo che
l’output abbia la forma seguente:
> Base1 = (valore di x) Base2 = (valore di y) Altezza = (valore di h)
> Area = (area calcolata)
 */


public class es6 {

    public static void main(String[] args) {
        int x = 4, y = 2, h = 1;
        double area = x*h/2.0;
        System.out.printf(">Lato1 = %d\n>Lato2 = %d\n>Lato3 = %d\n>Area: %.2f", x, y, h, area);
    }
}
