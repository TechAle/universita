package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.sette;

import java.util.Random;
import java.util.Scanner;

public class es6 {
    public static void main(String[] args) {
        int[] tabellaGioco = new int[9];
        int gioco = 0;
        boolean giocatore = new Scanner(System.in).nextInt() == 1;
        boolean croce = giocatore;
        do {
            tris.stampaConfigurazioneGioco(tabellaGioco);
            if (giocatore) {

                tabellaGioco[tris.mossaGiocatore(tabellaGioco)] = croce ? 1 : 2;

            } else {

                tabellaGioco[tris.mossaBot(tabellaGioco, croce ? 1 : 2 )] = croce ? 2 : 1;

            }

            gioco = tris.verificaVittoria(croce ? 1 : 2, tabellaGioco);

            if (tris.ePieno(tabellaGioco))
                break;

            giocatore = !giocatore;

            for(int i = 0; i < 10; i++)
                System.out.println();
        }while (gioco == 0);

        switch (gioco) {
            case 0:
                System.out.println("Nessuno ha vinto");
                break;
            case 1:
                System.out.println("Il giocatore ha vinto");
                break;
            case -1:
                System.out.println("Il bot ha vinto");
        }
    }
}

class tris {


    public static void stampaConfigurazioneGioco(int[] tabella) {
        for(int i = 0; i < 9; i++) {
            if (i > 0 && i % 3 == 0) {
                System.out.println();
                for (int j = 0; j < 5; j++)
                    System.out.print("_");
                System.out.println();
            }
            if (i % 3 != 0)
                System.out.print("|");
            switch (tabella[i]) {
                case 0:
                    System.out.print(" ");
                    break;
                case 1:
                    System.out.print("X");
                    break;
                case 2:
                    System.out.print("O");
            }

        }
    }

    public static boolean possibileGiocata(int[] tabella, int scelta) {
        return tabella[scelta] != 0;
    }

    public static int mossaGiocatore(int[] tabellaGioco) {
        int scelta;
        do {
            scelta = new Scanner(System.in).nextInt();
        }while (tris.possibileGiocata(tabellaGioco, scelta));
        return scelta;
    }

    public static int mossaBot(int[] tabellaGioco, int avversario) {
        if (tabellaGioco[0] == tabellaGioco[2])
            if (tabellaGioco[1] == 0)
                return 1;
        if (tabellaGioco[0] == tabellaGioco[6])
            if (tabellaGioco[3] == 0)
                return 3;
        if (tabellaGioco[2] == tabellaGioco[8])
            if (tabellaGioco[5] == 0)
                return 5;
        if (tabellaGioco[6] == tabellaGioco[8])
            if (tabellaGioco[7] == 0)
                return 7;
        if (tabellaGioco[0] == tabellaGioco[8] || tabellaGioco[2] == tabellaGioco[6])
            if (tabellaGioco[4] == 0)
                return 4;
        if (tabellaGioco[0] == avversario)
            if (tabellaGioco[8] == 0)
                return 8;
        if (tabellaGioco[2] == avversario)
            if (tabellaGioco[6] == 0)
                return 6;
        if (tabellaGioco[6] == avversario)
            if (tabellaGioco[2] == 0)
                return 2;
        if (tabellaGioco[8] == avversario)
            if (tabellaGioco[8] == 0)
                return 0;
        if (tabellaGioco[4] == 0 || tabellaGioco[0] == 0 || tabellaGioco[2] == 0 || tabellaGioco[6] == 0 || tabellaGioco[8] == 0)
            if (tabellaGioco[4] == 0)
                return 4;
        int val;
        //noinspection StatementWithEmptyBody
        while (tabellaGioco[(val = new Random().nextInt(9))] != 0) {}
        return val;
    }

    public static int verificaVittoria(int giocatore, int[] tabellaGioco) {
        for(int i = 0; i < 3; i++) {
            if (tabellaGioco[i*3] != 0 &&  tabellaGioco[i * 3] == tabellaGioco[i * 3 + 1] && tabellaGioco[i * 3] == tabellaGioco[i * 3 + 2])
                return tabellaGioco[i * 3] == giocatore ? 1 : -1;
            if (tabellaGioco[i] != 0 && tabellaGioco[i] == tabellaGioco[i + 3] && tabellaGioco[i] == tabellaGioco[i + 6])
                return tabellaGioco[i * 3] == giocatore ? 1 : -1;
        }

        if (tabellaGioco[0] != 0 && tabellaGioco[0] == tabellaGioco[4] && tabellaGioco[0] == tabellaGioco[8])
            return tabellaGioco[0] == giocatore ? 1 : -1;
        if (tabellaGioco[2] != 0 && tabellaGioco[2] == tabellaGioco[4] && tabellaGioco[2] == tabellaGioco[6])
            return tabellaGioco[2] == giocatore ? 1 : -1;

        return 0;
    }

    public static boolean ePieno(int[] tabellaGioco) {
        for(int i = 0; i < 9; i++)
            if (tabellaGioco[i] == 0)
                return false;
        return true;
    }
}
