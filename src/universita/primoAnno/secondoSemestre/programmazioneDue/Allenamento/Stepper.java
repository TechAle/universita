package universita.primoAnno.secondoSemestre.programmazioneDue.Allenamento;

public class Stepper extends Esercizio {

    private final int numeroPassi;
    private static int KCAL_PASSO = 2;

    public Stepper(int anno, int mese, int giorno, int numeroPassi) throws DataException {
        super(anno, mese, giorno);
        this.numeroPassi = numeroPassi;
    }

    @Override
    public int calorie() {
        return numeroPassi * KCAL_PASSO;
    }
}
