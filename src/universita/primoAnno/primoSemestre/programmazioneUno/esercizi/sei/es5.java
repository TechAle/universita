/*
Scrivere  un  programma Java che permetta all’utente di cifrare e decifrare dei messaggi usando il
famoso  cifrario  di  Vigenère  (pubblicato  nell’anno  1586).  Il  metodo  main()  invoca  il  metodo
sceltaMenu(),  che  stampa  a  video  il  seguente  menù  e  restituisce  al  chiamante  la  scelta  fatta
dall’utente:
 1 – Inserisci/cambia la parola chiave
 2 – Cifra un messaggio
 3 – Decifra un messaggio
 0 – Esci dal programma
Per  semplicità  supponiamo  che  i  messaggi  e  le  parole  chiave  siano  formate  solamente  da  lettere
minuscole. Inizialmente la parola chiave non è ancora stata specificata, ed è quindi la stringa vuota.
Tuttavia, non si possono cifrare o decifrare messaggi se prima non si è specificata una parola chiave;
se l’utente prova a farlo, il programma deve stampare a video un messaggio d’errore.
Per cifrare un messaggio, il cifrario di Vigenère opera come segue.
Supponiamo che il messaggio da cifrare sia programmazione, e che la parola chiave sia cane.
Ogni lettera del messaggio viene cifrata usando una lettera della parola chiave, e precisamente:
 la p di programmazione con la c di cane
 la r di programmazione con la a di cane
 la o di programmazione con la n di cane
 la g di programmazione con la e di cane
 la r di programmazione con la c di cane
 la a di programmazione con la a di cane
 la m di programmazione con la n di cane
 ... e così via, finché non è stato cifrato tutto il messaggio.
In  pratica,  le  lettere  della  parola  chiave  vengono  usate  a  rotazione,  finché  non  è  terminato  il
messaggio da cifrare.
Per  cifrare  una  lettera  del  messaggio  (supponiamo  p)  usando  una  lettera  della  parola  chiave
(supponiamo c), si usa la seguente matrice: in particolare, si incrociano la riga che inizia con p e la
colonna  che  inizia  per  c,  e  la lettera contenuta nella casella così individuata (r)  costituisce  la
cifratura di p con la chiave c.

La cifratura del messaggio programmazione con la parola chiave cane risulta quindi essere:
Lettere del messaggio:  programmazione
Lettere della parola chiave:   canecanecaneca
Lettere del messaggio cifrato:  rrbktazqczvspe
Per  decifrare  il  messaggio  rrbktazqczvspe  con  la  parola  chiave  cane,  ancora  una  volta  si
usano i caratteri della parola chiave, a rotazione:
Lettere del messaggio cifrato:  rrbktazqczvspe
Lettere della parola chiave:   canecanecaneca
Lettere del messaggio decifrato: programmazione
Per  decifrare  una  lettera  del  messaggio  cifrato  (supponiamo  r)  usando  una  lettera  della  parola
chiave (supponiamo c), si usa ancora la matrice di cui sopra. In particolare, nella colonna che inizia
per  c  si  cerca  il  carattere  r  da  decifrare; il carattere decifrato è quello che si trova all’inizio della
riga corrispondente (p).
Il programma dovrà utilizzare i seguenti metodi:
 cambiaParolaChiave(),  che  chiede  all’utente  di  specificare  una  nuova  parola  chiave,
controlla che sia formata da caratteri minuscoli e la restituisce al chiamante;
 creaMatrice(), che crea la matrice riportata sopra e ne restituisce un riferimento al chiamante;
 cifraLettera(), a cui si passa come argomenti il carattere da cifrare e il carattere della parola
chiave da usare, e restituisce al chiamante il carattere cifrato;
 decifraLettera(),  a  cui  si  passa  come  argomenti  il  carattere  da  decifrare  e  il  carattere  della
parola chiave da usare, e restituisce al chiamante il carattere decifrato;
 cifraMessaggio(), a cui si passa come argomenti il messaggio da cifrare e la parola chiave, e
restituisce al chiamante il messaggio cifrato;
 decifraMessaggio(),  a  cui  si  passa  come  argomenti  il  messaggio  da  decifrare  e  la  parola
chiave, e restituisce al chiamante il messaggio decifrato.
Il  programma  dovrà  consentire  all’utente  di  cifrare  e  decifrare  messaggi,  e  cambiare  la  parola
chiave, fino a che selezionerà la voce “0 – Esci dal programma” nel menù.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sei;

import java.util.Scanner;

public class es5 {

    public static void main(String[] args) {
        boolean ciclo = true;
        Scanner t = new Scanner(System.in);
        metodiEs5.creaMatrice();
        String key = "cane";
        do {

            stampaMetodi();
            int scelta = t.nextInt();

            switch (scelta) {
                case 1:
                    key = cambiaParolaChiave();
                    break;
                case 2:
                    System.out.println(metodiEs5.cifraMessaggio(richiediMessaggio(), key));
                    break;
                case 3:
                    System.out.println(metodiEs5.decifraMessaggio(richiediMessaggio(), key));
                    break;
                case 0:
                    ciclo = false;
                    break;
            }


        }while (ciclo);
    }

    public static String richiediMessaggio() {
        System.out.print("Messaggio: ");
        return new Scanner(System.in).nextLine();
    }

    public static String cambiaParolaChiave() {
        System.out.print("Nuova parola chiave: ");
        return new Scanner(System.in).nextLine();
    }

    static void stampaMetodi() {
        System.out.println("1 – Inserisci/cambia la parola chiave \n" +
                " 2 – Cifra un messaggio \n" +
                " 3 – Decifra un messaggio \n" +
                " 0 – Esci dal programma \nScelta: ");
    }

}

class metodiEs5 {
    public static char[][] matrice;

    public static void creaMatrice() {
        matrice = new char[26][26];
        for(int i = 0; i < 26; i++)
            for(int j = 0; j < 26; j++) {
                matrice[i][j] = (char) ('a' + (i+j)%26);
            }
        System.out.println("Matrice creata con successo");
    }

    public static char cifraLettera(char carattere, char key) {
        return matrice[carattere - 'a'][key - 'a'];
    }
    public static char decifraLettera(char carattere, char key) {
        for(int i = 0; i < 26; i++)
            if (matrice[i][key - 'a'] == carattere)
                return matrice[i][0];
        return 'b';
    }

    public static String cifraMessaggio(String messaggio, String key) {
        String output = "";

        for(int i = 0; i < messaggio.length(); i++)
            output += cifraLettera(messaggio.charAt(i), key.charAt(i % key.length()));

        return output;
    }


    public static String decifraMessaggio(String messaggio, String key) {
        String output = "";

        for(int i = 0; i < messaggio.length(); i++)
            output += decifraLettera(messaggio.charAt(i), key.charAt(i % key.length()));

        return output;
    }

}
