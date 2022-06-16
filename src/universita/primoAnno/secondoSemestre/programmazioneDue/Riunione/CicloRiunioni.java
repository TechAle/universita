package universita.primoAnno.secondoSemestre.programmazioneDue.Riunione;

import java.util.TreeSet;

public class CicloRiunioni {
    private TreeSet<Riunione> ciclo;

    public CicloRiunioni() {
        ciclo = new TreeSet<>();
    }

    public void aggiungiRiunione(Riunione riunione) throws RiunioneNonValidaException {
        if (riunione == null)
            throw new RiunioneNonValidaException();
        ciclo.add(riunione);
    }

    public int getNumeroRiunioni() {
        return ciclo.size();
    }

    public int getNumeroRiunioniVirtuali() {
        int num = 0;
        for (Riunione rin : ciclo)
            if (rin instanceof RiunioneVirtuale)
                num++;
        return num;
    }

    public int calcolaImpegnoComplessivo() {
        int num = 0;
        for (Riunione rin : ciclo)
            num += rin.getImpegnoOrarioComplessivo();
        return num;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Riunione rin : ciclo)
            sb.append(rin.toString()).append("\n");

        return "Ciclo: " + sb;
    }
}
