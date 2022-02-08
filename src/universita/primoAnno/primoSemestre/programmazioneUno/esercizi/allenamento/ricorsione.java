/*
    Dato N
    Creare un array lungo N
    E ad ogni posizione assegnare (posizione + 1) * 10
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.allenamento;

public class ricorsione {
    public static final int N = 0;
    public static void main(String[] args) {
        int[] test = ricorsioneSchifosa(N);
        System.out.print("Array: {");
        //noinspection ConstantConditions
        for(int i = 0; i < N; i++)
            System.out.printf("%d%s", test[i], i == N - 1 ? "" : ", ");
        System.out.print("}");
    }

    public static int[] ricorsioneSchifosa(int n) {
        if (n == 0) {
            return null;
        } else {
            int[] val = new int[n];
            val[n-1] = n*10;
            int[] nuovo = ricorsioneSchifosa(n - 1);
            //noinspection ManualArrayCopy
            for(int i = 0; i < n - 1; i++)
                //noinspection ConstantConditions
                val[i] = nuovo[i];
            return val;
        }

    }
}
