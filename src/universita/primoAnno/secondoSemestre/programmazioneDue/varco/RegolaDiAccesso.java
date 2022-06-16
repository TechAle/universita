package universita.primoAnno.secondoSemestre.programmazioneDue.varco;

abstract class RegolaDiAccesso {
    private final String descrizione;

    public RegolaDiAccesso(String descrizione) {
        this.descrizione = descrizione;
    }



    public String getDescrizione() {
        return descrizione;
    }

    public abstract boolean multa(Veicolo veicolo);
}
