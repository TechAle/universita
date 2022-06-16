package universita.primoAnno.secondoSemestre.programmazioneDue.Distribuitore;

public class Toast extends Prodotto {
    private final int costoBase;
    private final boolean grande;

    public Toast(int costoBase, boolean grande, int quantita) {
        super(quantita);
        this.costoBase = costoBase;
        this.grande = grande;
    }

    @Override
    public int getPrezzoUnitario() {
        return costoBase * (grande ? 2 : 1);
    }
}
