/*
Scrivere un programma Java che calcoli il massimo comun divisore (MCD) tra due numeri interi
positivi a e b in maniera ricorsiva, sfruttando la definizione induttiva già vista nella quarta
esercitazione:
MCD(x,x) = x
MCD(x,y) = MCD(y,x)
MCD(x,y) = MCD(x – y,y) se x > y
Definire pertanto un metodo ricorsivo mcd(a,b), che restituisce al chiamante il valore del massimo
comun divisore tra a e b. Basandosi sulla definizione induttiva data sopra, impostare la ricorsione
sul primo parametro, scambiando fra loro gli argomenti passati quando è necessario farlo.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sette;

public class es5 {
    public static void main(String[] args) {
        int x = 20;
        int y = 30;
        System.out.print(MCD(x, y));
    }

    public static int MCD(int x, int y) {
        if (x == y)
            return x;
        else if (x > y)
            return MCD(x - y, y);
        else return MCD(y, x);
    }
}
