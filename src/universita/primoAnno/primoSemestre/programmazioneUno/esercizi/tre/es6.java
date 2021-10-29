/*
Scrivere   un   programma   Java   che   implementi   una   semplice   calcolatrice.   Il   programma   deve
visualizzare un menù per la scelta del tipo di operazione da effettuare:
+  per sommare
  per sottrarre
*  per moltiplicare
/   per dividere
u  per uscire dal programma
Deve  poi  chiedere   in  input   il  tipo   di  operazione   che  si  vuole   effettuare.  Se  l’utente   inserisce  il
carattere ‘u’ allora il programma termina (senza usare il metodo  exit()); se inserisce un carattere
diverso da +, , *, /, u, stampa un messaggio d’errore e mostra nuovamente il menù. Se il carattere
inserito   è   +,  ,   *,   oppure   /,   chiede   all’utente   due   numeri   interi   tra   cui   eseguire   l’operazione
specificata;   in   caso   di   divisione,   verificare   che   l’utente   non   intenda   dividere   per   0.   Eseguita
l’operazione indicata, il programma stampa a video il risultato e ripropone all’utente il menù.*/
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.tre;

import java.util.Scanner;

public class es6 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        boolean calcolatore = true;
        char scelta;
        int value1, value2;
        do {
            System.out.print("Operazione: ");
            scelta = t.nextLine().charAt(0);
            switch (scelta) {
                case '+':
                case '-':
                case '*':
                case '/':
                    System.out.print("Valori: ");
                    value1 = t.nextInt();
                    value2 = t.nextInt();
                    double risultato = Double.MIN_VALUE;
                    switch (scelta) {
                        case '+':
                            risultato = value1 + value2;
                            break;
                        case '-':
                            risultato = value1 - value2;
                            break;
                        case '*':
                            risultato = value1 * value2;
                            break;
                        case '/':
                            if (value2 == 0)
                                System.out.println("Non si può dividere per 0");
                            else risultato = (double) value1 / value2;
                    }
                    if (risultato != Double.MIN_VALUE) {
                        System.out.printf("%d%c%d=%.2f", value1, scelta, value2, risultato);
                    }
                    break;
                case 'u':
                    calcolatore = false;
                    System.out.print("Uscita");
                    break;
                default:
                    System.out.print("Operazione non trovata");
            }
        }while (calcolatore);


    }
}
