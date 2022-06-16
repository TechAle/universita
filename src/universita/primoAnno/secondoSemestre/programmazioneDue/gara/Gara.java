package universita.primoAnno.secondoSemestre.programmazioneDue.gara;

import java.util.ArrayList;
import java.util.List;

public abstract class Gara {

    protected List<Runner> partecipanti;

    public Gara() {
        partecipanti = new ArrayList<>();
    }

    public void iscrivi(Runner runner) throws RunnerNotValidException {
        if (vincoloIscrizioneSoddisfatto(runner)) {
            if (!this.partecipanti.contains(runner)) {
                this.partecipanti.add(runner);
                return;
            }
        }

    }

    public int iscrivi(ArrayList<Runner> runners) {
        int nIscritti = 0;
        for(Runner partecipante : runners) {
            if (vincoloIscrizioneSoddisfatto(partecipante)) {
                if (!this.partecipanti.contains(partecipante)) {
                    this.partecipanti.add(partecipante);
                    continue;
                }
            }
            nIscritti++;
        }
        return nIscritti;
    }

    public int getNumIscritti() {
        return partecipanti.size();
    }

    public ArrayList<Runner> getIscrittiClasseEta(int eta) {
        ArrayList<Runner> output = new ArrayList<>();

        for(Runner part : partecipanti)
            if (part.getEta() >= eta)
                output.add(part);

        return output;
    }

    public boolean vincoloIscrizioneSoddisfatto(Runner runner) {
        return true;
    }

}
