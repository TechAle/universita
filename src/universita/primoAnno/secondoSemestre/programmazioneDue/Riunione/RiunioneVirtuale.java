package universita.primoAnno.secondoSemestre.programmazioneDue.Riunione;

public class RiunioneVirtuale extends Riunione {

    public RiunioneVirtuale(int anno, int mese, int giorno, int durata) throws RiunioneNonValidaException {
        super(anno, mese, giorno, durata);
    }


    @Override
    public int getImpegnoOrarioComplessivo() {
        return durata;
    }
}
