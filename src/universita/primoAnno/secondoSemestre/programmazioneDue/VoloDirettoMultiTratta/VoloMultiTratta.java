package universita.primoAnno.secondoSemestre.programmazioneDue.VoloDirettoMultiTratta;

import java.util.List;

public class VoloMultiTratta extends Volo {

    private final List<VoloDiretto> tratte;

    public static String estraiAereoportoPartenza(List<VoloDiretto> voli) throws VoloNonValidoException {
        if (voli.size() == 0)
            throw new VoloNonValidoException();
        return voli.get(0).getAeroportoPartenza();
    }

    public static String estraiAereoportoArrivo(List<VoloDiretto> voli) throws VoloNonValidoException {
        if (voli.size() <= 1)
            throw new VoloNonValidoException();
        return voli.get(voli.size() - 1).getAeroportoArrivo();
    }

    public VoloMultiTratta(List<VoloDiretto> voli) throws VoloNonValidoException {
        super(estraiAereoportoPartenza(voli), estraiAereoportoArrivo(voli));

        // Controllo correttezza vori
        for(VoloDiretto volo : voli)
            if (!Aeroporti.aeroportoValido(volo.getAeroportoArrivo()) || !Aeroporti.aeroportoValido(volo.getAeroportoPartenza()))
                throw new VoloNonValidoException();

        // Controllo sincronia voli
        for(int i = 0; i < voli.size() - 1; i++)
            if (!voli.get(i).getAeroportoArrivo().equals(voli.get(i + 1).getAeroportoPartenza()))
                throw new VoloNonValidoException();

        this.tratte = voli;
    }

    @Override
    public int getNumeroTratte() {
        return tratte.size();
    }

    @Override
    public int getDurataInMinuti() {
        int somma = 0;
        for(VoloDiretto volo : tratte)
            somma += volo.getDurataInMinuti();
        return somma;
    }
}
