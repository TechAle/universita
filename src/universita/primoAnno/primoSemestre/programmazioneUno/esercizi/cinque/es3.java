package universita.primoAnno.primoSemestre.programmazioneUno.esercizi.cinque;

public class es3 {
    public static void main(String[] args) {
        String temp = "ciao ciao si si";
        char ricerca = 'i';
        if (cercaCarattere(temp, ricerca))
            temp = rimuoviCarattere(temp, ricerca);
        System.out.print(temp);
    }

    public static boolean cercaCarattere(String input, char ricercato) {
        return input.indexOf(ricercato) != -1;
    }

    public static String rimuoviCarattere(String input, char ricercato) {
        return input.replaceAll(String.valueOf(ricercato), "");
    }
}
