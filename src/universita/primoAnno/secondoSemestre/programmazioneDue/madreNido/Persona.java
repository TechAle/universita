package universita.primoAnno.secondoSemestre.programmazioneDue.madreNido;

public class Persona {
    private Braccialetto braccialetto;
    public Persona(Braccialetto braccialetto) throws OperazioneNonConsentitaException {
        if (braccialetto == null)
            throw new OperazioneNonConsentitaException();
        this.braccialetto = braccialetto;
    }

    public Braccialetto getBraccialetto() {
        return braccialetto;
    }

    public boolean confrontaBraccialetto(Persona altraPersona) {
        if (altraPersona == null)
            return false;
        if (this == altraPersona)
            return true;
        if (altraPersona.getBraccialetto() == this.braccialetto)
            return true;
        if (altraPersona.getBraccialetto().getCodice() == this.braccialetto.getCodice())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "braccialetto=" + braccialetto +
                '}';
    }
}
