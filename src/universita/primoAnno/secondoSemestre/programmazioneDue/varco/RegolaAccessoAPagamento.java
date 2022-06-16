package universita.primoAnno.secondoSemestre.programmazioneDue.varco;

import java.util.HashSet;
import java.util.Set;

public class RegolaAccessoAPagamento extends RegolaDiAccesso {

    private final HashSet<String> registroTarghePaganti = new HashSet<>();

    public RegolaAccessoAPagamento(String descrizione) {
        super(descrizione);
    }

    @Override
    public boolean multa(Veicolo veicolo) {
        return !registroTarghePaganti.contains(veicolo.getTarga());
    }

    void registraPagamento(String targa) throws VeicoloException {
        if (targa == null || targa.length() == 0)
            return;

        if (registroTarghePaganti.contains(targa))
            throw new VeicoloException();

        registroTarghePaganti.add(targa);
    }
}
