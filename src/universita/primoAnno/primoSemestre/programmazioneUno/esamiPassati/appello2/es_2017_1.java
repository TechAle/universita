package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.appello2;

public class es_2017_1 {
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println("Il numero di argomenti è errato");
            System.exit(-1);
        }
        int[] interi = new int[5];
        for(int i = 0; i < 5; i++)
            interi[i] = Integer.parseInt(args[i]);
        int n = Integer.parseInt(args[5]);

        int[] copiaInteri = new int[5];
        for(int i = 0; i < 5; i++)
            copiaInteri[i] = interi[i];

        metodiEs1.modificaArray(copiaInteri, n);

        System.out.print("Array iteri: {");
        for(int i = 0; i < 5; i++)
            System.out.print(interi[i] + " ");
        System.out.println("}");

        System.out.print("Array copiaInteri: {");
        for(int i = 0; i < 5; i++)
            System.out.print(copiaInteri[i] + " ");
        System.out.println("}");

        switch (metodiEs1.valutaDifferenzaArray(interi, copiaInteri)) {
            case -1:
                System.out.println("Errore durante la valutazione della differenza: Lunghezze differenti");
                break;
            case 0:
                System.out.print("Array copiaInteri: {");
                for(int i = 0; i < 5; i++)
                    System.out.print(copiaInteri[i] + " ");
                System.out.println("}");
                break;
            default:
                System.out.print("Array iteri: {");
                for(int i = 0; i < 5; i++)
                    System.out.print(interi[i] + " ");
                System.out.println("}");
                break;
        }
    }
}

class metodiEs1 {
    static void modificaArray(int[] par, int a) {
        int prod = 1, sum = 0;
        for(int i = 0; i < 5; i++) {
            prod *= par[i];
            sum += par[i];
        }
        if (sum == 0)
            prod = 0;

        int min, max;
        boolean compreso = false;
        if (a < (min = prod - sum) & a > (max = prod + sum))
            compreso = true;

        for(int i = 0; i < 5; i++)
            if (compreso) {
                if (par[i] > a)
                    par[i] = max;
            } else {
                if (par[i] < a)
                    par[i] = min;
            }
    }

    static int valutaDifferenzaArray(int[] par1, int[] par2) {
        if (par1.length != par2.length)
            return -1;
        else {
            for(int i = 0; i < 5; i++)
                if (par1[i] != par2[i])
                    return 1;
        }
        return 0;
    }
}