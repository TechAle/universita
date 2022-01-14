package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.appello2;

import java.util.Scanner;

public class es_2017_3 {
    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);
        int n;
        do {
            System.out.print("N: ");
            n = t.nextInt();
        }while (n <= 0);

        int[] interi = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.print("N^" + i + " valore: ");
            interi[i] = t.nextInt();
        }

        int a,b;
        do {
            System.out.print("A: ");
            a = t.nextInt();
            System.out.print("B: ");
            b = t.nextInt();
        }while (a >= b);

        int[] copiaInteri = new int[5];
        for(int i = 0; i < 5; i++)
            copiaInteri[i] = interi[i];

        metodiEs3.occorrenzeElementi(copiaInteri, a, b);

        System.out.print("Array iteri: {");
        for(int i = 0; i < n; i++)
            System.out.print(interi[i] + " ");
        System.out.println("}");

        System.out.print("Array copiaInteri: {");
        for(int i = 0; i < n; i++)
            System.out.print(copiaInteri[i] + " ");
        System.out.println("}");

        int modifiche = 0;
        for(int i = 0; i < n; i++)
            if (interi[i] != copiaInteri[i])
                modifiche++;

        if (modifiche > n / 2) {
            int[] newArray = metodiEs3.modificaElementi(interi, copiaInteri);
            System.out.print("newArray = {");
            for(int i = 0; i < n*2; i++)
                    System.out.print(newArray[i] + " ");
            System.out.print("}");
        }

    }
}

class metodiEs3 {
    public static void occorrenzeElementi(int[] par, int a, int b) {
        for(int i = 0; i < par.length; i++)
            if (par[i] < a)
                par[i] = b;
            else if (par[i] > b)
                par[i] = a;
    }

    public static int[] modificaElementi(int[] par1, int[] par2) {
        int[] newArray = new int[par1.length * 2];
        for(int i = 0; i < par1.length; i++) {
            newArray[i*2] = par1[i];
            newArray[i*2+1] = par2[i];
        }
        return newArray;
    }
}