package universita.primoAnno.secondoSemestre.programmazioneDue.Allenamento;

import java.util.ArrayList;
import java.util.List;

public class RegistroAllenamenti {

    private List<Esercizio> esercizi;

    public RegistroAllenamenti() {
        esercizi = new ArrayList<>();
    }

    public int calorieComplessive() {
        int cont = 0;
        for(Esercizio es : esercizi)
            cont += es.calorie();
        return cont;
    }

    public int contaEserciziUguali(Esercizio esercizio) {
        if (esercizio == null)
            return 0;
        int cont = 0;
        for(Esercizio es : esercizi)
            if (esercizio.equals(es))
                cont++;
        return cont;
    }

    public boolean aggiungiEsercizio(Esercizio esercizio) {
        if (esercizio == null)
            return false;
        esercizi.add(esercizio);
        return true;
    }

    public int aggiungiEsercizio(Esercizio[] esercizi) {
        int cont = 0;
        for(Esercizio es : esercizi)
            cont += aggiungiEsercizio(es) ? 1 : 0;
        return cont;
    }

}
