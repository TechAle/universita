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