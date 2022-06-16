package universita.primoAnno.secondoSemestre.programmazioneDue.Allenamento;

public class Cyclette extends Esercizio {
    @SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
    private static int MOLTIPLICATORE_INTENSA = 2, MOLTIPLICATORE_LEGGERA = 3;
    private final int durata;

    public Cyclette(int anno, int mese, int giorno, int durata) throws DataException {
        super(anno, mese, giorno);
        this.durata = durata;
    }


    @Override
    public int calorie() {
        return durata * (durata > 20 ? MOLTIPLICATORE_LEGGERA : MOLTIPLICATORE_INTENSA) ;
    }
}
