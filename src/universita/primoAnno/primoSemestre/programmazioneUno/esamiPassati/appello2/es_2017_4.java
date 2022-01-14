package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.appello2;

public class es_2017_4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Il numero di argomenti è errato");
            System.exit(-1);
        }
        String stringa = args[0];

        boolean ePari = stringa.length() % 2 == 0;
        int lunghezza = stringa.length();
        char[] dispari = new char[lunghezza / 2];
        char[] dispariBackup = new char[lunghezza / 2];
        char[] pari = new char[lunghezza / 2+ (ePari ? 0 : 1)];
        for(int i = 0; i < lunghezza / 2 + (ePari ? 0 : 1); i++) {
            pari[i] = (char) (stringa.charAt(i*2) - '0');
            if (ePari || i < lunghezza / 2) {
                char value = (char) (stringa.charAt(i * 2 + 1) - '0');
                dispari[i] = value;
                dispariBackup[i] = value;
            }
        }
        metodiEs4.modificaArray(pari, dispari);

        boolean modificato = false;
        for(int i = 0; i < dispari.length; i++)
            if (dispari[i] != dispariBackup[i])
                modificato = true;

        if (modificato) {
            char[] output = metodiEs4.unisciArray(pari, dispari);
            System.out.print("Output : {");
            for(int i = 0; i < output.length; i++)
                System.out.print(output[i] + " ");
            System.out.println("}");
        }

    }
}

class metodiEs4 {
    public static void modificaArray(char[] pari, char[] dispari) {
        if (pari.length > dispari.length) {
            for(int i = 0; i < pari.length; i++) {
                if (pari[i] == 'a' || pari[i] == 'e' || pari[i] == 'i' || pari[i] == 'o' || pari[i] == 'u')
                    pari[i] = (char) (pari[i] + 'A' - 'a');
            }
        } else if (pari.length < dispari.length) {
            for(int i = 0; i < dispari.length; i++) {
                if (dispari[i] == 'a' && dispari[i] == 'e' && dispari[i] == 'i' && dispari[i] == 'o' && dispari[i] == 'u')
                    dispari[i] = (char) (dispari[i] + 'A' - 'a');
            }
        }
    }

    public static char[] unisciArray(char[] par1, char[] par2) {
        char[] output = new char[par1.length + par2.length];
        for(int i = 0; i < par1.length; i++)
            output[i] = par1[i];
        for(int i = 0; i < par2.length; i++)
            output[i + par1.length] = par2[i];
        return output;
    }
}