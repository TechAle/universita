/*
Scrivere un programma in Java che legge da tastiera una stringa composta
da lettere minuscole dell’alfabeto e due numeri naturali m e n compresi tra
0  e  k-1,  dove  k  è  la  lunghezza  della  stringa.  Qualora  l’utente,  una  volta
inserita  una  stringa,  inserisse  un  valore  maggiore  della  lunghezza  della
stringa, oppure la stringa inserita non fosse composta solamente da lettere
dell’alfabeto  minuscole,  il  programma  termina  stampando  messaggio
d’errore. Il programma deve costruire una nuova stringa che si ottiene da
quella  inserita  convertendo  in  maiuscolo  le  lettere  che  si  trovano  in
posizione
m
(m+n) mod k
(m+2n) mod k
(m+3n) mod k
...
[cercare di capire quante volte al massimo procedere prima di reincontrare
una posizione già visitata e quindi interrompere la sequenza]
 */
package universita.primoAnno.primoSemestre.programmazioneUno.cartaOro.due;

import java.util.Scanner;

public class es3 {
    public static void main(String[] args) {
        System.out.print("Operazione: ");
        Scanner t = new Scanner(System.in);
        String output = t.nextLine();
        int somma = 0;
        int tempNumero = 0;
        char operazione = '?';

        for(int i = 0; i < output.length(); i++ ) {
            char value = output.charAt(i);
            if (value >= 48 && value <= 57)
                tempNumero = tempNumero * 10 + value - 48;
            else if (value == '+' || value == '-') {
                if (operazione != '?') {
                    somma += tempNumero * (operazione == '+' ? 1 : -1);
                } else somma = tempNumero;
                operazione = value;
                tempNumero = 0;
            }
            else {
                System.out.println("Operazione invalida");
                operazione = '@';
                break;
            }
        }

        if (operazione != '@') {
            somma += tempNumero * (operazione == '+' ? 1 : -1);
            System.out.println(output + " = " + Integer.toString(somma));
        }
    }
}
