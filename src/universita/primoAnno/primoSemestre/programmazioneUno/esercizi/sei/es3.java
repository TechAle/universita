/*
Scrivere un programma Java che, letta una semplice espressione aritmetica da riga di comando, ne
calcoli  il  valore  e  lo  stampi  a  video.  Le  espressioni  aritmetiche  riconosciute  come  valide  hanno  le
seguenti caratteristiche:
 gli operatori sono solo  e  (considerati come operatori binari)
 gli operandi sono solo cifre comprese tra 0 e 9
 ogni espressione inizia e finisce con un operando
 operandi e operatori sono intercalati
Esempi di espressioni valide:
 2  3 + 4
 3
 0  1  1  3
Esempi di espressioni non valide:
 2 * 3 + 4  (non contiene solamente + e )
 12 + 4  (l’operando 12 non è una cifra compresa tra 0 e 9)
  3  (non inizia con un operando)
 2 +  5  (operandi e operatori non sono intercalati)
Come si diceva, l’espressione aritmetica viene specificata da riga di comando, quindi ad esempio:
java Programma 3 – 4 + 5
a cui il programma risponderà subito (senza ulteriori interazioni con l’utente): 4.
Se l’espressione specificata non è valida, il programma stamperà a video un messaggio d’errore.
Il programma farà uso (almeno) dei seguenti metodi:
 controllaValiditaEspressione(): prende come argomento un riferimento all’array args  dei
parametri passati al programma da riga di comando, e verifica se l’espressione specificata in
tali parametri è valida secondo le regole  elencate  sopra.  Restituisce  al  chiamante  un  valore
booleano;
 valutaOperando(): prende come argomento una stringa che rappresenta una cifra tra 0 e 9, e
restituisce al chiamante il valore della cifra corrispondente (un int);
 valutaEspression():  prende come argomento un riferimento all’array args  dei  parametri
passati  al  programma  da  riga  di  comando,  e  calcola  il  valore  dell’espressione.  Questo
metodo  va  chiamato  solo  se  il  metodo  controllaValiditaEspressione()  ha  precedentemente
restituito  true,  e  fa  uso  del  metodo  valutaOperando()  per  convertire  gli  operandi  da
String a int.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sei;

import java.util.Scanner;

public class es3 {
    public static void main(String[] args) {
        String stringa = argsToString(args);

        if (metodiEs3.controllaValiditaEspressione(stringa))
            System.out.print(metodiEs3.valutaEspressione(stringa));

    }

    public static String argsToString(String[] args) {
        String output = "";
        for(String value : args)
            output += value;
        return output;
    }
}

class metodiEs3 {
    public static boolean controllaValiditaEspressione(String input) {

        boolean operatore = false;
        for(char value : input.toCharArray()) {

            if (operatore) {
                if (value != '+' && value != '-')
                    return false;
            } else {
                if (value < '0' || value > '9')
                    return false;
            }

            operatore = !operatore;
        }

        return true;
    }


    public static int valutaEspressione(String input) {

        int primoValore = 0;
        char operazione = ' ';
        int stage = 0;
        int output = 0;
        for(char value : input.toCharArray()) {
            switch (stage) {
                case 0:
                    primoValore = valutaOperando(value);
                    stage++;
                    break;
                case 1:
                    operazione = value;
                    stage++;
                    break;
                case 2:
                    output = primoValore + valutaOperando(value) * (operazione == '-' ? -1 : 1);
                    stage--;
                    primoValore = output;
            }
        }


        return output;
    }

    public static int valutaOperando(char value) {
        return value - '0';
    }
}
