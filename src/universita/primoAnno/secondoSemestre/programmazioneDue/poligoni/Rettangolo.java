package universita.primoAnno.secondoSemestre.programmazioneDue.poligoni;

public class Rettangolo implements Poligono {

    private final double base;
    private final double altezza;

    public Rettangolo(double v, double v1) {
        this.base = v;
        this.altezza = v1;
    }

    @Override
    public double calcolaArea() {
        return this.base * this.altezza;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o )
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        double area1 = this.calcolaArea();
        double area2 = ((Rettangolo) o).calcolaArea();
        return area1 == area2 || Math.abs(area1 - area2) <= 0.001;
    }
}
