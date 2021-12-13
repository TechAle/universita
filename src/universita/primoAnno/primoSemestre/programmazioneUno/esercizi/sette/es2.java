/*
Scrivere un programma Java che consenta all’utente di specificare a un robot i passi da fare per
raggiungere (eventualmente) un obiettivo. La posizione dell’obiettivo e i passi da effettuare
vengono specificati da riga di comando, come nel seguente esempio:
java Programma 5 4 ssseeeenno
che indica che l’obiettivo da raggiungere si trova alla riga 5, colonna 4, e i passi che deve fare il
robot sono: andare verso sud 3 volte, andare verso est 4 volte, andare verso nord 2 volte e infine
andare verso ovest 1 volta.
Nel metodo main(), il programma crea anzitutto un mondo virtuale costituito da una matrice di 20
righe e 20 colonne. Posiziona poi l’obiettivo alle coordinate specificate dai primi due argomenti
forniti sulla riga di comando. Quindi, posiziona 10 ostacoli in posizioni casuali: se al momento di
posizionare un ostacolo, la posizione dovesse essere già occupata – da un altro ostacolo o
dall’obiettivo – riprovare con un’altra posizione; alla fine, gli ostacoli posizionati devono essere 10.
Infine, segna le posizioni occupate dal robot durante il percorso indicato da riga di comando,
partendo dalla riga 0, colonna 0. Il percorso di interrompe se il robot va a finire nella posizione
occupata dall’obiettivo, oppure in una posizione occupata da un ostacolo, oppure tenta di andare
oltre a uno dei bordi del mondo. Stampa quindi a video il mondo virtuale con indicati obiettivo,
ostacoli e percorso del robot, e stampa un messaggio che dice se il robot ha raggiunto l’obiettivo,
oppure è finito contro un ostacolo o se ha cercato di attraversare uno dei bordi del mondo.
I metodi da implementare nella classe Metodi sono i seguenti:
 creaMondo(): alloca una matrice di 20 × 20 interi, e restituisce al chiamante un riferimento a
tale matrice. Il mondo appena creato ha tutte le posizioni vuote, cioè la matrice contiene 0 in
ogni elemento;
 aggiungiObiettivo(mondo,riga,colonna): se la posizione specificata da riga e colonna è
libera (contiene 0), aggiunge l’obiettivo (rappresentato dal numero 1) e restituisce true al
chiamante. Se la posizione specificata è invece occupata, oppure è fuori dalla matrice, lascia
il mondo inalterato e restituisce false al chiamante;
 aggiungiOstacolo(mondo): aggiunge un ostacolo (rappresentato dal numero 2) in una
posizione casuale del mondo. Se la posizione tirata a caso è occupata, riprova fino a che non
trova una posizione libera;
 aggiungiPosizioniRobot(mondo,percorso): segna nella matrice corrispondente al mondo
virtuale, usando il numero 3, le posizioni occupate dal robot durante il suo cammino. Il robot
parte sempre dalla posizione (0,0); se va a sud si incrementa il numero di riga, se va a est si
incrementa il numero di colonna. L’argomento percorso è una stringa formata dai
caratteri s (sud), n (nord), e (est) e o (ovest). Il percorso si interrompe se il robot va a
occupare una posizione occupata da un ostacolo o dall’obiettivo, oppure se va contro uno
dei bordi del mondo (cioè se cerca di uscire dalla matrice). Il metodo restituisce al
chiamante: 1 se il robot ha raggiunto l’obiettivo, 2 se è finito contro un ostacolo, 3 se ha
cercato di uscire dalla matrice, 0 se nessuna di queste condizioni si è verificata;
 stampaMondo(mondo): stampa a video una rappresentazione grafica del mondo virtuale,
come segue:
**********************
*O OO # *
*O #O *
*OOOOO *
* # *
* *
* X *
* # # *
* *
* *
* # *
* *
* *
* *
* *
* # # *
* *
* *
* # *
* # *
* *
**********************
dove i bordi del mondo sono rappresentati da asterischi, le posizioni vuote da spazi, gli
ostacoli da #, l’obiettivo da X e il percorso del robot da O. Si noti che la posizione
dell’obiettivo e il percorso corrispondono agli argomenti passati da riga di comando,
nell’esempio dato sopra.
 */
package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sette;

import java.util.Random;
import java.util.Scanner;

/*
Anche questo esercizio è poco chiaro lol
Cerco di fare il possibile
 */
public class es2 {
    static final int inizioOstacoli = 5;

    public static void main(String[] args) {
        int a = 0;
        mondoUtils.creaMondo(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        robotUtils.setCoordinate(mondoUtils.obiettivo[0], mondoUtils.obiettivo[1], args[2]);
        for(int i = 0; i < 10; i++)
            mondoUtils.aggiungiOstacolo(mondoUtils.mondo);

        do {
            mondoUtils.stampaMondo(mondoUtils.mondo);
            robotUtils.setCoordinate(new Scanner(System.in).nextLine().charAt(0));
        }while (true);
    }


}

class mondoUtils {
    static final int righe = 5,
                     colonne = 5;
    static int[][] mondo;
    static int[] obiettivo;

    static void creaMondo(int startX, int startY) {
        // Nuovo mondo
        mondo = new int[righe][colonne];
        // Cerchiamo il posto
        obiettivo = new int[]{startX, startY};
        mondo[obiettivo[0]][obiettivo[1]] = 2;
    }

    static boolean posizioneLegale(int[] start, int varX, int varY) {
        // Se andiamo oltre i limiti oppure nessuna variazione
        return (varX != 0 || varY != 0) && start[0] + varX >= 0 && start[0] + varX <= righe && start[1] + varY >= 0 && start[1] + varY <= colonne;
    }

    static void stampaMondo(int[][] mondo) {
        for(int i = 0; i < righe - 1; i++)
            System.out.print("***");
        System.out.println();
        for(int i = 0; i < righe; i++) {
            for(int j = 0; j < colonne; j++) {
                if (j == 0)
                    System.out.print('*');
                String toPrint;
                switch (mondo[i][j]) {
                    case 1:
                        toPrint = "# ";
                        break;
                    case 2:
                        toPrint = "X ";
                        break;
                    case 3:
                        toPrint = "O ";
                        break;
                    default:
                        toPrint = "  ";
                        break;
                }
                System.out.print(toPrint);
                if (j == colonne - 1)
                    System.out.print('*');
            }
            System.out.println();
        }
        for(int i = 0; i < righe - 1; i++)
            System.out.print("***");
    }

    static void aggiungiOstacolo(int[][] mondo) {
        Random r = new Random();
        //noinspection StatementWithEmptyBody
        while (!aggiungiOstacolo(mondo, r.nextInt(righe), r.nextInt(colonne))){}
    }

    static boolean aggiungiOstacolo(int[][] mondo, int x, int y) {
        if (mondo[x][y] == 0) {
            mondo[x][y] = 1;
            return true;
        }
        else return false;
    }


}

class robotUtils {
    static int[] coordinate;
    static void setCoordinate(int x, int y, String movimenti) {
        coordinate = new int[]{x, y};
        for(int i = 0; i < movimenti.length(); i++) {

            setCoordinate(movimenti.charAt(i));

        }


    }

    static void setCoordinate(char mov) {
        int     varX = 0,
                varY = 0;
        switch (mov) {
            case 's':
                varY = -1;
                break;
            case 'e':
                varX = -1;
                break;
            case 'n':
                varY = 1;
                break;
            case 'o':
                varX = 1;
                break;
        }

        if (mondoUtils.posizioneLegale(coordinate, varX, varY)) {
            if (mondoUtils.mondo[coordinate[0]][coordinate[1]] == 3)
                mondoUtils.mondo[coordinate[0]][coordinate[1]] = 0;
            coordinate[0] += varX;
            coordinate[1] += varY;
            mondoUtils.mondo[coordinate[0]][coordinate[1]] = 3;
        }
    }



}