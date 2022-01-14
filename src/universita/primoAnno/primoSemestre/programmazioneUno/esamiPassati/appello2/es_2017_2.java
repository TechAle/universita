package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.appello2;

public class es_2017_2 {
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println("Il numero di argomenti è errato");
            System.exit(-1);
        }
        char[] caratteri = new char[5];
        for(int i = 0; i < 5; i++) {
            caratteri[i] = args[i].charAt(0);
        }
        char c = args[5].charAt(0);

        char[] copiaCaratteri = new char[5];
        for(int i = 0; i < 5; i++)
            copiaCaratteri[i] = caratteri[i];

        metodiEs2.modificaArray(copiaCaratteri, c);

        System.out.print("Array iteri: {");
        for(int i = 0; i < 5; i++)
            System.out.print(caratteri[i] + " ");
        System.out.println("}");

        System.out.print("Array copiaInteri: {");
        for(int i = 0; i < 5; i++)
            System.out.print(copiaCaratteri[i] + " ");
        System.out.println("}");


        switch (metodiEs2.valutaDifferenzaArray(caratteri, copiaCaratteri)) {
            case -1:
                System.out.println("Errore durante la valutazione della differenza: Lunghezze differenti");
                break;
            case 0:
                System.out.print("Array copiaInteri: {");
                for(int i = 0; i < 5; i++)
                    System.out.print(copiaCaratteri[i] + " ");
                System.out.println("}");
                break;
            default:
                System.out.print("Array iteri: {");
                for(int i = 0; i < 5; i++)
                    System.out.print(caratteri[i] + " ");
                System.out.println("}");
                break;
        }
    }
}

class metodiEs2 {
    static void modificaArray(char[] par, char c) {
        int nFound = 0;
        for(int i = 0; i < 5; i++)
            if (par[i] == c)
                nFound++;

        if (nFound == 0)
            for(int i = 0; i < 5 / 2; i++)
                par[i*2] = c;
        else if (nFound < 5)
            for(int i = 0; i < 5/2; i++)
                par[i*2+1] = c;


    }

    static int valutaDifferenzaArray(char[] par1, char[] par2) {
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