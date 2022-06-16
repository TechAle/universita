package universita.primoAnno.secondoSemestre.programmazioneDue.VoloDirettoMultiTratta;

public class VoloDiretto extends Volo {

    private final int durataInMinuti;

    public VoloDiretto(String aereoportoPartenza, String aereoportoArrivo, int durataInMinuti) throws VoloNonValidoException {
        super(aereoportoPartenza, aereoportoArrivo);
        if (durataInMinuti <= 0 || !Aeroporti.aeroportoValido(aereoportoArrivo) || !Aeroporti.aeroportoValido(aereoportoPartenza))
            throw new VoloNonValidoException();
        this.durataInMinuti = durataInMinuti;
    }

    @Override
    public int getNumeroTratte() {
        return 1;
    }

    @Override
    public int getDurataInMinuti() {
        return durataInMinuti;
    }

    @Override
    public String toString() {
        return super.toString() + "durataInMinuti: " + durataInMinuti;
    }
}
