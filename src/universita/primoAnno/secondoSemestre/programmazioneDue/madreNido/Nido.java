package universita.primoAnno.secondoSemestre.programmazioneDue.madreNido;

import java.util.*;

public class Nido {

    /*
        Integer = Lettino
     */
    private Map<Integer, Bambino> camerata;

    public Nido() {
        /*
            Come scegliere fra TreeMap e HashMap?
            - HashMap può contenere null. Vuoi null? Se no potresti scegliere TreeMap
            - HashMap non ha un ordine
         */
        camerata = new TreeMap<>();
    }

    public boolean aggiungiBambino(int lettino, Bambino bimbo) {
        if (bimbo == null)
            return false;

        // I prof non vogliono che mettiamo this quando non è richiesto
        // Non fatelo durante l'esame.
        if (this.camerata.containsKey(lettino))
            return false;
        else
            if (this.camerata.containsValue(bimbo))
                return false;
            else
                this.camerata.put(lettino, bimbo);

        // Avrei potuto farlo in maniera più ordinata, però meh preferisco che il codice
        // Sia più facile da leggere
        return true;
    }

    public Bambino dimettiBambino(int lettino, Persona richiedente) {
        if (richiedente == null )
            return null;

        if (!this.camerata.containsKey(lettino))
            return null;

       Bambino bimbo = this.camerata.get(lettino);

       if (!bimbo.dimettibile())
           return null;

        return this.camerata.remove(lettino);
    }

    public int getLettino(Braccialetto bimbo) {
        for(int key : this.camerata.keySet())
            // Potrei utilizzare una chiave di appoggio
            if (this.camerata.get(key).getBraccialetto() == bimbo ||
                this.camerata.get(key).getBraccialetto().getCodice() == bimbo.getCodice())
                return key;
        return -1;
    }

    public Collection<Integer> getLettiniOccupati() {
        return this.camerata.keySet();
    }

    public Bambino getBambino(int lettino) {

        if (!this.camerata.containsKey(lettino))
            return null;
        Bambino questo = this.camerata.get(lettino);
        return questo;
        /*
            CIOE', voi avete fatto 30 minuti per sta cosa di privacy leak
            e poi in questa esercitazione ti danno errore se controlli la privacy leak
            Okayyyy
         */
        /*
        try {
            // Privacy leak
            return new Bambino(questo.getBraccialetto(), questo.getPesoAllaNascita(), questo.getLunghezza(), questo.getIndiceApgar());
        } catch (OperazioneNonConsentitaException e) {
            return null;
        }*/

    }


}
