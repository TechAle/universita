package universita.primoAnno.secondoSemestre.programmazioneDue.Riunione;

import java.util.Objects;

public abstract class Riunione implements Comparable<Riunione> {
    private final int anno, mese, giorno;
    protected final int durata;

    public Riunione(int anno, int mese, int giorno, int durata) throws RiunioneNonValidaException {
        if (anno < 2022 || mese < 1 || mese > 12 || giorno < 1 || giorno > 31 || durata < 1)
            throw new RiunioneNonValidaException();



        this.anno = anno;
        this.mese = mese;
        this.giorno = giorno;
        this.durata = durata;
    }



    public abstract int getImpegnoOrarioComplessivo();

    public String getData() {
        return String.format("%d/%d/%d", giorno, mese, anno);
    }

    @Override
    public String toString() {
        return getData() + " " + getImpegnoOrarioComplessivo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Riunione)) return false;
        Riunione riunione = (Riunione) o;
        return anno == riunione.anno && mese == riunione.mese && giorno == riunione.giorno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anno, mese, giorno);
    }


    @Override
    public int compareTo(Riunione that) {
        if (this.anno != that.anno) {
            return (this.anno < that.anno ? -1 : 1);
        }

        if (this.mese != that.mese) {
            return (this.mese < that.mese ? -1 : 1);
        }

        if (this.giorno != that.giorno) {
            return (this.giorno < that.giorno ? -1 : 1);
        }

        return 0;
    }
}
