package universita.primoAnno.secondoSemestre.programmazioneDue.varco;

public class RegolaAccessoVietatoMotoriDiesel extends RegolaDiAccesso {
    public RegolaAccessoVietatoMotoriDiesel(String descrizione) {
        super(descrizione);
    }

    @Override
    public boolean multa(Veicolo veicolo) {
        return veicolo.getCarburante().equals(Carburante.DIESEL);
    }

}
