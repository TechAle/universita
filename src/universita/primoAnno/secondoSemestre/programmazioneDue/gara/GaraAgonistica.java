package universita.primoAnno.secondoSemestre.programmazioneDue.gara;

public class GaraAgonistica extends Gara implements CompetizioneAgonistica {
    @SuppressWarnings("FieldCanBeLocal")
    private int maxTempo;
    private Runner vincitore;

    public GaraAgonistica(int maxTempo) {
        this.maxTempo = maxTempo;
        vincitore = null;
    }

    @Override
    public void setVincitore(Runner runner) throws RunnerNotValidException {
        if (runner != null && super.partecipanti.contains(runner)) {
            if (vincitore == null || vincitore.getMigliorTempo() > runner.getMigliorTempo()) {
                vincitore = runner;
                maxTempo = vincitore.getMigliorTempo();
            }
        }else throw new RunnerNotValidException();
    }

    @Override
    public Runner getVincitore() {
        return vincitore;
    }

    @Override
    public boolean vincoloIscrizioneSoddisfatto(Runner runner) {
        return runner.getMigliorTempo() < maxTempo;
    }


}
