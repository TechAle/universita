package universita.primoAnno.secondoSemestre.programmazioneDue.madreNido;

import java.util.Locale;

public class Madre extends Persona {

    public static final String NATURALE = "naturale";
    public static final String CESAREO = "cesario";
    private String tipoParto;

    public Madre(@SuppressWarnings("ConstantConditions") Braccialetto braccialetto, String tipoParto) throws OperazioneNonConsentitaException {
        super(braccialetto);
        if (tipoParto.equalsIgnoreCase(NATURALE) || tipoParto.equalsIgnoreCase(CESAREO))
            this.tipoParto = tipoParto.toLowerCase();
        else throw new OperazioneNonConsentitaException();
    }

    public double allatta(Bambino bimbo) throws OperazioneNonConsentitaException {
        if (bimbo == null)
            throw new NullPointerException();
        if (bimbo.getBraccialetto() == this.getBraccialetto() || bimbo.getBraccialetto().getCodice() == this.getBraccialetto().getCodice()) {
            double latte = bimbo.getPesoAllaNascita() * bimbo.getLunghezza() / (this.tipoParto.equals(CESAREO) ? 10 : 5);
            bimbo.incrementaPeso(latte);
            return latte;
        }
        else throw new OperazioneNonConsentitaException();
    }

    public double allatta(Nido nido, int lettino) throws OperazioneNonConsentitaException {
        if (nido == null)
            throw new NullPointerException();
        return allatta(nido.getBambino(lettino));
    }

    @Override
    public String toString() {
        return "Madre{" +
                "braccialetto=" + super.getBraccialetto() +
                ", parto=" + this.tipoParto +
                '}';
    }
}
