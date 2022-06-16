package universita.primoAnno.secondoSemestre.programmazioneDue.varco;

import java.util.Objects;

public class Veicolo implements Comparable<Veicolo> {
    private String targa;
    private String carburante;

    public Veicolo(String targa, String carburante) throws VeicoloException {
        if (targa == null || targa.length() == 0 ||
            !Carburante.carburanteValido(carburante))
            throw new VeicoloException();

        this.targa = targa;
        this.carburante = carburante;
    }

    public String getTarga() {
        return targa;
    }

    public String getCarburante() {
        return carburante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veicolo veicolo = (Veicolo) o;
        return Objects.equals(targa, veicolo.targa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targa);
    }

    @Override
    public int compareTo(Veicolo that) {
        if (this.getTarga() == null && that.getTarga() == null) {
            return 0;
        } else if (this.getTarga() == null) {
            return -1;
        } else if (that.getTarga() == null) {
            return 1;
        } else {
            return this.getTarga().compareTo(that.getTarga());
        }
    }
}
