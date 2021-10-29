/*
Scrivere un programma Java che legga da tastiera:
una stringa, e la salvi nella variabile messaggio;
un numero intero, e lo salvi nella variabile posizione;
una seconda stringa, e la salvi nella variabile stringa;
e   costruisca   un   nuovo   messaggio,   da   stampare   in   output,   ottenuto   inserendo   nella   stringa
messaggio, a partire dalla posizione posizione, la stringa stringa.
Di   seguito   viene   presentato   un   esempio   di   I/O   risultante   dall'esecuzione   del   programma   Java
implementato:
Inserisci una stringa: gelo a Milano
Inserisci un numero: 3
Inserisci un’altra stringa: at
Il messaggio e’: gelato a Milano
Si implementino inoltre i seguenti controlli:
le stringhe inserite non devono essere vuote;
la posizione specificata deve essere compresa tra 0 e la lunghezza di messaggio – 1.
Se uno di questi controlli dovesse fallire, il programma deve stampare un messaggio di errore e
terminare l’esecuzione, usando il metodo exit()
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.due;

import java.util.Scanner;

public class es3 {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String  messaggio = t.next(),
                stringa = t.next();
        int posizione = t.nextInt();

        if (messaggio.equals("") || stringa.equals(""))
            System.exit(-1);
        if (posizione < 0 || posizione > messaggio.length())
            System.exit(-1);

        String nuovoMessaggio = messaggio.substring(0,posizione) + stringa +
                messaggio.substring(posizione);

        System.out.println("Il messaggio costruito e': " + nuovoMessaggio);
    }


}
