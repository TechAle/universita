/*
Scrivere   un   programma   Java   formato   da   due   classi:  Programma  e  Metodi.   La   classe
Programma contiene solamente il metodo main(), che mostra a video il seguente menù:
a) somma di due numeri interi
b) divisione intera e resto tra due numeri interi
c) media tra due numeri double
d) valore assoluto di un numero intero
e) lunghezza della stringa che rappresenta un numero intero
t) termina il programma
e legge una delle lettere a, b, c, d, e, t (indifferentemente in minuscolo o maiuscolo), rifiutando
con un messaggio d’errore qualsiasi altro carattere. Determinata la funzione che l’utente vuole
eseguire, legge uno o due numeri (interi o double, a seconda della funzione scelta) e richiama gli
opportuni metodi della classe Metodi per calcolare il risultato (o risultati) da stampare a video.
La classe Metodi, pertanto, conterrà i seguenti metodi, di cui vanno specificati opportunamente i
parametri formali e il tipo di dati restituito al chiamante:
➢sommaDueInteri(): restituisce al chiamante la somma dei due numeri interi passati come
argomenti;
➢divisioneIntera(): restituisce al chiamante il valore della divisione intera tra due numeri
interi passati come argomenti. Questo metodo va chiamato solamente se il divisore è diverso
da 0;
➢restoDivisioneIntera(): restituisce al chiamante il resto della divisione intera tra due numeri
interi passati come argomenti. Anche in questo caso, il divisore dovrebbe essere diverso da
0;
➢mediaTraDueDouble(): restituisce al chiamante la media aritmetica tra due numeri double
passati come argomenti;
➢valoreAssolutoIntero(): restituisce al chiamante il valore assoluto di un numero intero
passato come argomento;
➢lunghezzaStringaIntero(): restituisce al chiamante la lunghezza della stringa che rappresenta
il numero intero passato come argomento.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.cinque;

import java.util.Scanner;

// Questa è la nostra classe Programma
@SuppressWarnings("ALL")
public class es2 {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        boolean ciclo = true;
        do {
            String temp = t.nextLine();
            if (temp.length() > 0) {
                char scelta = temp.charAt(0);
                switch (scelta) {
                    case 'a':
                        System.out.println(Metodi.sommaDueInteri(1,1));
                        break;
                    case 'b':
                        System.out.println(Metodi.divisioneIntera(1,1));
                        break;
                    case 'c':
                        System.out.println(Metodi.restoDivisioneIntera(1,1));
                        break;
                    case 'd':
                        System.out.println(Metodi.mediaTraDueDouble(1.0,1.0));
                        break;
                    case 'e':
                        System.out.println(Metodi.valoreAssolutoIntero(-10));
                        break;
                    case 't':
                        System.out.println(Metodi.lunghezzaStringaIntero("ciao"));
                        break;
                    case 'x':
                        ciclo = false;
                        break;
                }
            }
        }while (ciclo);
    }
}

@SuppressWarnings("ALL")
class Metodi {
    public static int sommaDueInteri(int a, int b) {
        return a+b;
    }
    public static int divisioneIntera(int a, int b) {
        return a/b;
    }
    public static int restoDivisioneIntera(int a, int b) {
        return a%b;
    }
    public static double mediaTraDueDouble(double a, double b) {
        return (a+b)/2;
    }
    public static int valoreAssolutoIntero(int a) {
        return Math.abs(a);
    }
    public static int lunghezzaStringaIntero(String val) {
        return val.length();
    }
}



