package universita.primoAnno.secondoSemestre.programmazioneDue.VoloDirettoMultiTratta;

public abstract class Volo {
    private final String aereoportoPartenza;
    private final String aereoportoArrivo;

    public Volo(String aereoportoPartenza, String aereoportoArrivo) {
        this.aereoportoPartenza = aereoportoPartenza;
        this.aereoportoArrivo = aereoportoArrivo;
    }

    public String getAeroportoArrivo() {
        return aereoportoArrivo;
    }

    public String getAeroportoPartenza() {
        return aereoportoPartenza;
    }

    public abstract int getNumeroTratte();

    public abstract int getDurataInMinuti();

    @Override
    public String toString() {
        return String.format("Volo: Partenza: %s. Arrivo: %s. Durata: %d. Tratti: %d", aereoportoPartenza, aereoportoArrivo, getDurataInMinuti(), getNumeroTratte());
    }
}
