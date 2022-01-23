package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.allenamento;

import java.util.ArrayList;

public class fondamenti {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nessun valore è stato messo come parametro");
            System.exit(-1);
        }
        String input = "";
        //noinspection ForLoopReplaceableByForEach
        for(int i = 0; i < args.length; i++)
            //noinspection StringConcatenationInLoop
            input += args[i];

        char[][] relazioni = getRelazioni(input);

        System.out.printf("La relazione%s è riflessiva\n", isRiflessiva(relazioni) ? "" : " non");
        System.out.printf("La relazione%s è Antiriflessiva\n", isAntiRiflessiva(relazioni) ? "" : " non");
        System.out.printf("La relazione%s è simmetrica\n", isSimmetrica(relazioni) ? "" : " non");
        System.out.printf("La relazione%s è Antisimmetrica\n", isAntiSimmetrica(relazioni) ? "" : " non");
        System.out.printf("La relazione%s è Antisimmetrica\n", isAssimmetrica(relazioni) ? "" : " non");
        System.out.printf("La relazione%s è Transitiva\n", isTransitiva(relazioni) ? "" : " non");
    }

    public static char[][] getRelazioni(String input) {
        // Prendi il numero di '<' -> Rappresenta il numero di relazioni
        int len = 0;
        for(int i = 0; i < input.length(); i++)
            if (input.charAt(i) == '<')
                len++;

        char[][] output = new char[len][2];
        int index = 0;
        boolean first = false;

        for(int i = 0; i < input.length(); i++) {
            char value = input.charAt(i);
            if (value >= 'a' && value <= 'z') {
                output[index][first ? 1 : 0] = value;
                if (first)
                    index++;
                first = !first;
            }
        }

        return output;
    }

    public static boolean isRiflessiva(char[][] input) {
        // Raccogli tutte le possibili relazioni, uso un arrayList siccome non c'ho voglia di fare cose lunghe con
        ArrayList<Character> unici = getValoriUnici(input);

        for(Character valoreCheck : unici) {
            boolean found = false;
            for(char[] coppia : input)
                if (coppia[0] == valoreCheck && coppia[0] == coppia[1]) {
                    found = true;
                    break;
                }
            if (!found)
                return false;
        }
        return true;

    }
    public static boolean isAntiRiflessiva(char[][] input) {
        // Raccogli tutte le possibili relazioni, uso un arrayList siccome non c'ho voglia di fare cose lunghe con
        ArrayList<Character> unici = getValoriUnici(input);

        for(Character valoreCheck : unici) {
            for(char[] coppia : input)
                if (coppia[0] == valoreCheck && coppia[0] == coppia[1]) {
                    return false;
                }
        }
        return true;

    }

    public static boolean isSimmetrica(char[][] input) {

        for(char[] coppia : input) {
            boolean found = false;

            for(char[] coppiaCheck : input)
                if (coppiaCheck[0] == coppia[2] && coppiaCheck[2] == coppia[0]) {
                    found = true;
                    break;
                }

            if (!found)
                return false;
        }

        return true;
    }
    public static boolean isAntiSimmetrica(char[][] input) {

        for(char[] coppia : input) {

            for(char[] coppiaCheck : input)
                if (coppiaCheck[0] == coppia[2] && coppiaCheck[2] == coppia[0]) {
                    return false;
                }

        }

        return true;
    }
    public static boolean isAssimmetrica(char[][] input) {

        for(char[] coppia : input) {

            for(char[] coppiaCheck : input)
                if ((coppiaCheck[0] == coppia[2] && coppiaCheck[2] == coppia[0]) || (coppia[0] == coppia[2])) {
                    return false;
                }

        }

        return true;
    }

    public static boolean isTransitiva(char[][] input) {

        for(char[] coppia : input) {
            ArrayList<Character> collegamenti = getCollegamenti(input, coppia[1]);
            if (!isConnected(input, collegamenti, coppia[0]))
                return false;

        }

        return true;
    }

    public static ArrayList<Character> getCollegamenti(char[][] input, char nodo) {
        ArrayList<Character> variCollegamenti = new ArrayList<>();

        for(char[] coppia : input)
            if (coppia[0] == nodo)
                variCollegamenti.add(coppia[1]);

        return variCollegamenti;
    }
    public static boolean isConnected(char[][] input, ArrayList<Character> toCheck, char nodo) {
        for(char car : toCheck) {
            boolean found = false;
            for(char[] coppia : input)
                if (coppia[0] == nodo && coppia[1] == car) {
                    found = true;
                    break;
                }
            if (!found)
                return false;
        }
        return true;
    }

    public static ArrayList<Character> getValoriUnici(char[][] input) {
        ArrayList<Character> valori = new ArrayList<>();
        for(char[] coppia : input)
            for(char valore : coppia)
                if (!valori.contains(valore))
                    valori.add(valore);
        return valori;
    }
}
