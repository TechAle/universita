package universita.primoAnno.secondoSemestre.programmazioneDue.varco;

import java.util.Set;
import java.util.TreeSet;

public class Varco {

    RegolaDiAccesso regolaAccesso;
    TreeSet<Veicolo> multati;

    public Varco(RegolaDiAccesso regolaDiAccesso) {
        this.regolaAccesso = regolaDiAccesso;
        multati = new TreeSet<>();
    }

    void convalidaEntrata(Veicolo veicolo) {
        if (regolaAccesso == null)
            return;
        if (regolaAccesso.multa(veicolo))
            multati.add(veicolo);

    }

    Set<Veicolo> getMultati() {
        return multati;
    }

    @Override
    public String toString() {

        StringBuilder targhe = new StringBuilder();

        for(Veicolo multato : multati)
            targhe.append(multato.getTarga()).append("\n");

        return regolaAccesso != null ? (regolaAccesso.getDescrizione() + "\n" + targhe) : "";
    }
}
