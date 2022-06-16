package universita.primoAnno.secondoSemestre.programmazioneDue.gara;

public class GaraNonAgonistica extends Gara {
    private final int minEta;
    private final int maxEta;

    public GaraNonAgonistica(int minEta, int maxEta) {
        this.maxEta = maxEta;
        this.minEta = minEta;
    }

    public boolean vincoloIscrizioneSoddisfatto(Runner runner) {
        return runner.getEta() >= minEta && runner.getEta() <= maxEta;
    }
}
