package universita.primoAnno.secondoSemestre.programmazioneDue.Distribuitore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DistributoreAutomatico {
    private final List<Prodotto> prodotti;

    public DistributoreAutomatico(Collection<Prodotto> prodotti) {
        this.prodotti = new ArrayList<>();

        Iterator<Prodotto> iteratore = prodotti.iterator();

        /// Intellij, so che questa opzione è veramente brutta e potrei usare addAll
        /// Però i prof vogliono questo suppongo, sorry.
        //noinspection WhileLoopReplaceableByForEach
        while (iteratore.hasNext())
            //noinspection UseBulkOperation
            this.prodotti.add(iteratore.next());
    }

    public Prodotto getProdotto(int pos) throws PosizioneNonValidaException {
        if (pos < 0 || pos > prodotti.size() - 1)
            throw new PosizioneNonValidaException();
        return prodotti.get(pos);
    }

    public void incrementaQuantitaProdotto(int pos, int qt) throws PosizioneNonValidaException {
        Prodotto pr = getProdotto(pos);
        pr.incrementaQuantita(qt);
    }

    public int acquista(int pos, int valore) throws PosizioneNonValidaException, ProdottoNonAcquistabileException {
        int out = 0;

        Prodotto pr = getProdotto(pos);

        if (pr.getQuantita() <= 0)
            throw new ProdottoNonAcquistabileException("quantita insufficiente");

        if (pr.getPrezzoUnitario() > valore)
            throw new ProdottoNonAcquistabileException("valore insufficiente");

        int acquistati = valore / pr.getPrezzoUnitario();


        pr.decrementaQuantita(acquistati);

        return valore - (acquistati * pr.getPrezzoUnitario()) ;
    }


}
