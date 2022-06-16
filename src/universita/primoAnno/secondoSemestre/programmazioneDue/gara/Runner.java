package universita.primoAnno.secondoSemestre.programmazioneDue.gara;

import java.util.Objects;

public class Runner {
    private int eta;
    private int migliorTempo;
    private String idRunner;

    public Runner(int eta, int migliorTempo, @SuppressWarnings("ConstantConditions") String idRunner) throws RunnerNotValidException {
        if (eta < 10 || eta > 100 || migliorTempo <= 0 || idRunner == null || idRunner.length() == 0)
            throw new RunnerNotValidException();
        this.eta = eta;
        this.migliorTempo = migliorTempo;
        this.idRunner = idRunner;
    }

    public int getEta() {
        return eta;
    }

    int getMigliorTempo() {
        return migliorTempo;
    }

    String getIdRunner() {
        return idRunner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runner runner = (Runner) o;
        return Objects.equals(idRunner, runner.idRunner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRunner);
    }
}
