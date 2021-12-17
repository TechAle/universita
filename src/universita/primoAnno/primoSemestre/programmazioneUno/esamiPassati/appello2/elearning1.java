/*
Scrivere un programma, composto da due classi, una denominata Programma contenente il main(), l’altra i metodi necessari allo svolgimento delle operazioni, denominata Metodi, che svolga quanto segue:

Classe Programma

    Riceve due stringhe di caratteri da linea di comando (nel parametro String[] args) e le copia nelle stringhe espressione (la prima) e valori (la seconda)
    la prima stringa è un'espressione tipo “A+2-B”, di sole lettere A-E o cifre 0-9, separati da operatori + e -;
    passa espressione al metodo checkEspr(): se ritorna false uscire dal programma;
    passa valori al metodo checkValori(): se ritorna false uscire dal programma;
    crea un array tabella di 5 interi e lo inizializza con valori tutti a 0;
    in tabella andranno i valori da dare alle lettere A-E dell'espressione, posizionati negli elementi di tabella da [0] a [4];
    esegue l'invocazione estraiValori(valori,tabella);
    esegue l'invocazione sostituisci(espressione,tabella) e memorizza il risultato nella stringa daCalc;
    Stampa a video il risultato dell'invocazione del metodo calcola(daCalc).


Classe Metodi, definire I seguenti metodi:

    boolean checkEspr(), che riceve una stringa e ritorna true solo se la stringa è una sequenza che alterna correttamente lettera A-E o cifra 0-9 ed un operatore + o - (“A-C+2”->true, “AB-2”->false);
    boolean checkValori(), che riceve una stringa e ritorna true solo se la stringa è una sequenza che alterna correttamente lettera A-E e cifra 0-9 separati da : (“A:2B:9”->true, “A1B-2”->false);
    void estraiValori(), che riceve una stringa come primo argomento e un array di 5 interi come secondo, e estrae dalla stringa i valori da dare alle lettere e li mette nelle corrette caselle dell'array: “A:2E:1”->2/0/0/0/1;
    String sostituisci(), che riceve una stringa come primo argomento e un array di 5 interi come secondo, e restituisce una stringa ottenuta dalla prima sostituendo le lettere con I giusti valori presi dall'array di interi: “A+B” con array visto sopra → “2+0”;
    int calcola(), che riceve una stringa prodotta da sostituisci() e restituisce l'intero ottenuto calcolando il valore di tale espressione: “2+0”->2.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esamiPassati.appello2;

public class elearning1 {
    public static void main(String[] args) {
        if (args.length > 1) {
            String espressione = args[0];
            if (!Metodi.checkEspr(espressione)) {
                System.out.println("L'espressione è stata codificata malamente");
                System.exit(-1);
            }
            String valori = args[1];
            if (!Metodi.checkValori(valori)) {
                System.out.println("I valori sono stati codificati malamente");
                System.exit(-1);
            }

            int[] tabella = new int[5];
            for(int i = 0; i < 5; i++)
                tabella[i] = 0;

            Metodi.estraiValori(valori, tabella);

            String daCalc = Metodi.sostituisci(espressione, tabella);

            System.out.println(Metodi.calcola(daCalc));

        } else System.out.println("Non sono stati ricevuti abbastanza parametri");
    }
}

class Metodi {
    public static boolean checkEspr(String espressione) {
        for(int i = 0; i < espressione.length(); i++) {
            // Controlla che sia un numero/lettera
            char valore = espressione.charAt(i);
            if (i % 2 == 0) {
                if ((valore < 'A' || valore > 'E') && (valore < '0' || valore > '9')) {
                    return false;
                }
            // Controlla che sia un operazione
            } else {
                if (valore != '+' && valore != '-')
                    return false;
            }
        }
        // Tutt'apposto
        return true;
    }
    public static boolean checkValori(String valori) {
        for(int i = 0; i < valori.length(); i++) {
            char valore = valori.charAt(i);
            switch (i % 3) {
                case 0:
                    if (valore < 'A' || valore > 'E')
                        return false;
                    break;
                case 1:
                    if (valore != ':')
                        return false;
                    break;
                case 2:
                    if (valore < '0' || valore > '9')
                        return false;
                    break;
            }
        }

        return true;
    }
    public static void estraiValori(String valori, int[] tabella) {
        for(int i = 0; i < valori.length() / 3; i++) {
            tabella[valori.charAt(i*3) - 'A'] = valori.charAt(i*3+2) - '0';
        }
    }
    public static String sostituisci(String input, int[] tabella) {
        String output = "";

        for(int i = 0; i < input.length(); i++) {
            char daAggiungere = input.charAt(i);

            if (daAggiungere >= 'A' && daAggiungere <= 'Z')
                daAggiungere = (char) ('0' + tabella[daAggiungere - 'A']);

            //noinspection StringConcatenationInLoop
            output += daAggiungere;
        }

        return output;
    }
    public static int calcola(String input) {
        int output = 0;

        for(int i = 0; i < input.length() / 3; i++)
            output += (input.charAt(i*3) - '0') + (input.charAt(i*3+2) - '0') * (input.charAt(i*3+1) == '+' ? 1 : -1);

        return output;
    }
}