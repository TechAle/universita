package universita.primoAnno.primoSemestre.programmazioneUno.teoria;

// Libreria per l'utilizzo della tastiera
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("ALL") // Ignorate questo
// Introduzione del Programma:
public class metodi {

    // Introduzione del Programma:
    public static void main(String[] args) {
        /// Basi
        // Inizializzazione variabile
        int var;
        // Assegnazione di una variabile
        var = 10;
        // Inizializzo una tastiera
        Scanner tastiera = new Scanner(System.in);
        // Nuovo valore a var dato da tastiera
        var = tastiera.nextInt();
        char t = tastiera.next().charAt(0);

        // Stampe
        System.out.print("");
        System.out.println(""); // -> Print con \n alla fine
        System.out.printf("%d : %c\n", var, t);

        // Cast implicito
        double dub = var;
        // Cast esplicito
        float flo = (float) dub;

        /// Stringhe
        // Inizializzo stringa
        String parola = "ciao come stai"; // tastiera.nextLine();
        // Ricavo lunghezza
        int len = parola.length();
        // Prendo carattere alla posizione 0
        t = parola.charAt(0);
        // Prendo la stringa dopo il 3 carattere
        String nuovaStringa = parola.substring(3);
        // Prendo dal 2 carattere fino al 5
        nuovaStringa = parola.substring(2, 5 + 1);
        // Trasformo stringa in maiuscolo
        nuovaStringa = nuovaStringa.toUpperCase();
        // Trasformo stringa in minuscolo
        nuovaStringa = nuovaStringa.toLowerCase();
        // Trasformo primo carattere in maiuscolo attraverso la tabella ascii
        char primoCarattere = (char) (nuovaStringa.charAt(0) - ('a' - 'A'));
        // Trasformo in minuscolo
        primoCarattere = (char) (primoCarattere + ('a' - 'A'));
        // Posizione della parola "ia" nella stringa
        len = nuovaStringa.indexOf("ia");
        // Ultima posizione della parola "ia"
        len = nuovaStringa.lastIndexOf("ia");
        // Controlla se una stringa è uguale
        boolean uguale = nuovaStringa.equals("si");
        // Controllo in modalità case insensitive
        uguale = nuovaStringa.equalsIgnoreCase("si");
        /*
            Controllo che dà:
            - x = 0 -> Stringe uguali
            - x < 0 -> la prima stringa è minore
            - x > 0 -> La prima stringa è maggiore
         */
        int controllo = nuovaStringa.compareTo("si");

        // If else (le parentesi possono essere omesse se abbiamo solamente 1 operazione
        if (1 == 1) // {
            System.out.print("vero");
        // }
        else // {
            System.out.print("falso");
        // }

        /// If
        // If annidato
        if (10 > 1) {
            if (10 > 5) {
                if (10 > 10) {

                }
            }
        }

        // If multi-ramo
        if (1 < 10) {
        } else if (1 < 5) {
            } else if (1 < 2) {
                } else if (1 < 0) {
                    } else {
                    }


        /*
            Operatori (messi in ordine di precedenza)
                1) +, -, ++, --, ! |-> Operatori unari
                         \----|   \-> Negazione
                              \-> Operatore di incremento/decremento, 2 tipologie:
                                    a. Pre-Incremento -> ++a; -> Viene incrementato prima dell'operazione
                                    b. Post-Incremento -> a++; -> Viene incrementato dopo l'operazione
                2) * , / , % |-> Operatori binari
                3) +, - |-> Operatori binari
                4) < , <= , > , >= |-> Operatori di confronto
                5) == , != |-> Operatori di confronto
                6) & |-> And senza il shortcut (cioè, verranno svolte tutte le due operazioni
                7) | |-> Or senza il shortcut
                8) && |-> And con il shortcut
                9) || |-> Or con il shortcut
         */
        // Operatore ternario
        int value = (1 == 1) ? 1 : 0;
        // Semplifica un if:
        int valore;
        if (1 == 1)
            valore = 1;
        else valore = 0;

        // Switch
        switch (valore) {
            // valore == 0
            case 0:
                break;
            case 1:
            case 2:
            // valore == 1 || valore == 2, praticamente uniamo i case
                break;
            // Else
            default:
                break;
        }

        /// Cicli che iterano fino a 10
        // For            /-> Se questo è false, finisci
        for(int i = 0; i < 10; i++) {
        }
        // Nota, puoi avere un for anche così:
        for(int i = 0, m = 10; i < 10; i++, m = m + 20) {
        }

        // While
        int indice = 0;
        while (indice < 10) { // Se questo è false, finishi
        }

        // doWhile
        indice = 0;
        do {
        }while (indice < 10);
        //        \-> Se questo è false, finishi

        // Random               /-> Abbiamo "settato" il seed, senza questo il seed sarà random
        Random r = new Random(10);
        // Random dà un valore che è compreso fra [0, 1) se nextFloat
        float valoreRandom = r.nextFloat();
        // con nextInt, un valore intero casuale in tutto il suo raggio
        int valCas = r.nextInt();
        // Se vogliamo un intero casuale fra 1 e 2 compreso,
        int binario = (int) (r.nextFloat() * 2 + 1); // Facendo * 2 diventa [0, 2), sommando 1 divneta [0, 3)
    }
}
