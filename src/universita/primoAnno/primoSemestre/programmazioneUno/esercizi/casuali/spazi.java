package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.casuali;

public class spazi {
    public static void main(String[] args) {
        String stringa = "mi    chiamo            roberto";

        while(!stringa.equals(stringa.replace("  ", " "))) {
            stringa = stringa.replace("  ", " ");
        }

        System.out.print(stringa);
    }
}
