package universita.primoAnno.secondoSemestre.programmazioneDue.poligoni;

import java.util.ArrayList;

public class DisegnoGeometrico {

    ArrayList<Poligono> collezione = new ArrayList<>();

    public long calcolaAreaTotale() throws NoPoligoniException {
        if (collezione.size() == 0)
            throw new NoPoligoniException("Nessun poligono trovato");
        long somma = 0;
        for(Poligono ret : collezione) {
            somma += ret.calcolaArea();
        }
        return somma;
    }

    public void aggiungiPoligono(Poligono rettangolo) {
        if (rettangolo != null)
            collezione.add(rettangolo);
    }



}
