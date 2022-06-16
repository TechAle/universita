package universita.primoAnno.secondoSemestre.programmazioneDue.Distribuitore;

public abstract class Prodotto {
    private int quantita;

    protected Prodotto(int quantita) {
        this.quantita = Math.max(quantita, 0);
    }

    public abstract int getPrezzoUnitario();

    public int getQuantita() {
        return quantita;
    }

    public void incrementaQuantita(int quantita) {
        this.quantita += quantita;
    }

    public void decrementaQuantita(int quantita) {
        this.quantita -= quantita;
    }
}
