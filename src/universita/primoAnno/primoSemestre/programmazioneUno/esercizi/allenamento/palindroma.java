package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.allenamento;

public class palindroma {
    public static void main(String[] args) {
        // Non abbiamo tutti gli argomenti
        if (args.length == 0) {
            System.out.println("Non ci sono abbastanza parametri");
            System.exit(-1);
        }
        // Il nostro input e dove lo conterremo
        String inputString = "";
        for(int i = 0; i < args.length; i++)
            //noinspection StringConcatenationInLoop
            inputString += args[i];
        int[] input = new int[trueLunghezza(inputString)];
        // Siccome accettiamo - abbiamo index diversi
        int index = 0;
        for(int i = 0; i < inputString.length(); i++) {
            // Controlliamo i valori
            int[] output = controllaNumero(input, inputString, index, i, false);
            // Prendiamo i vari output
            index = output[0];
            i = output[1];
            // Doppio negativo
            if (i == -1) {
                System.out.println("Doppio negativo non esiste");
                System.exit(-1);
            // Carattere
            } else if (i == -2) {
                System.out.println("E' stato dato un carattere");
                System.exit(-1);
            }
        }

        // Controlliamo palindroma in maniera ricorsiva
        System.out.printf("L'array %s è palindroma", isPalindroma(input) ? "" : "non");

    }

    public static int[] controllaNumero(int[] input, String inputString, int index, int i, boolean negativo) {
        int value = inputString.charAt(i) - '0';
        if (value < 0 || value > 9) {
            // Valore: -
            if (value == -3) {
                if (!negativo)
                    return controllaNumero(input, inputString, index, i + 1, true);
                else return new int[]{-1, -1};
            // Valore: spazio
            } else {
                return new int[]{-2, -2};
            }
        } else input[index++] = value * (negativo ? -1 : 1);
        return new int[]{index, i};
    }

    public static int trueLunghezza(String inputString) {
        int len = 0;
        for(int i = 0; i < inputString.length(); i++) {
            char value = inputString.charAt(i);
            if (value != '-')
                len++;
        }
        return len;
    }

    public static boolean isPalindroma(int[] array) {
        // Se l'array è di lunghezza minore (uguale) di 1 vuol dire che non abbiamo nulla da controllare
        if (array.length <= 1)
            return true;
        else {
            // Controlla il primo e ultimo valore
            if (array[0] == array[array.length - 1]) {
                // Crea nuovo array con i valori interni
                int[] valori = new int[array.length - 2];
                //noinspection ManualArrayCopy
                for(int i = 1; i < array.length - 1; i++)
                    valori[i - 1] = array[i];
                // Ricorsiva
                return isPalindroma(valori);
            }
            return false;
        }
    }
}
