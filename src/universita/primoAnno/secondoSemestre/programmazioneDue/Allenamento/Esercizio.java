package universita.primoAnno.secondoSemestre.programmazioneDue.Allenamento;

import java.util.Objects;

public abstract class Esercizio {
    private final int anno, mese, giorno;

    public Esercizio(int anno, int mese, int giorno) throws DataException {

        if (anno < 2000 || anno > 2021 || giorno < 1 || giorno > 31 || mese < 1 || mese > 12)
            throw new DataException("lol");

        this.anno = anno;
        this.mese = mese;
        this.giorno = giorno;
    }

    public int getAnno() {
        return anno;
    }

    public int getMese() {
        return mese;
    }

    public int getGiorno() {
        return giorno;
    }

    public abstract int calorie();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        return calorie() == ((Esercizio) o).calorie();
    }


}
