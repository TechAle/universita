package universita.primoAnno.secondoSemestre.programmazioneDue.gara;

public interface CompetizioneAgonistica {
    void setVincitore(Runner runner) throws RunnerNotValidException;
    Runner getVincitore();

}
