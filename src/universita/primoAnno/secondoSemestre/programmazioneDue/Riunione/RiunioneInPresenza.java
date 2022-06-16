package universita.primoAnno.secondoSemestre.programmazioneDue.Riunione;

public class RiunioneInPresenza extends Riunione {

    private int distanza;

    public RiunioneInPresenza(int anno, int mese, int giorno, int durata, int distanza) throws RiunioneNonValidaException {
        super(anno, mese, giorno, durata);

        if (distanza <= 0)
            throw new RiunioneNonValidaException();
        this.distanza = distanza;
    }




    @Override
    public int getImpegnoOrarioComplessivo() {
        return durata + distanza * 2;
    }
}
