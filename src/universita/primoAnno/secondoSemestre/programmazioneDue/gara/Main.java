package universita.primoAnno.secondoSemestre.programmazioneDue.gara;

public class Main {
    public static void main(String[] args) throws RunnerNotValidException {
        GaraAgonistica gara = new GaraAgonistica(30);
        Runner r = new Runner(22, 28, "1234");
        Runner r2 = new Runner(22, 25, "3234");
        Runner r3 = new Runner(28, 25, "3634");

        gara.iscrivi(r);
        gara.iscrivi(r2);

        try {
            gara.setVincitore(r3);
        }catch(RunnerNotValidException e) { //OK
        }

        gara.setVincitore(r2);

        int b = 0;
    }
}
