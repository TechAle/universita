package universita.primoAnno.secondoSemestre.programmazioneDue.VoloDirettoMultiTratta;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistroVoli {

    private HashMap<String, Volo> voli;

    public RegistroVoli() {
        voli = new HashMap<>();
    }

    public void aggiungiVolo(String codice, Volo volo) throws CodiceVoloNonValidoException {
        if (codice.length() != 5)
            throw new CodiceVoloNonValidoException();
        voli.put(codice, volo);
    }

    public void aggiungiVolo(String codice, String aereoportoPartenza, String aereoportoArrivo, int durata) throws VoloNonValidoException, CodiceVoloNonValidoException {
        Volo volo = new VoloDiretto(aereoportoPartenza, aereoportoArrivo, durata);
        aggiungiVolo(codice, volo);
    }

    public Volo getVolo(String codice) {
        //noinspection Java8MapApi
        if (voli.containsKey(codice))
            return voli.get(codice);
        else return null;
    }

    public String[] getListaCodiciDeiVoli() {
        String[] codici = new String[voli.size()];
        int i = 0;
        for(String codice : voli.keySet()) {
            codici[i++] = codice;
        }
        return codici;
    }

    void dumpSuFile(String nomeFile){
        FileWriter f;
        try {
            f = new FileWriter(nomeFile);

            for(Map.Entry<String, Volo> volo : voli.entrySet()) {
                f.write(String.format("%s) %s" + System.lineSeparator(), volo.getKey(), volo.getValue().toString()));
            }
            f.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
