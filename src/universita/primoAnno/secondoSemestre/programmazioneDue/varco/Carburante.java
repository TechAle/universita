package universita.primoAnno.secondoSemestre.programmazioneDue.varco;

public class Carburante {
	public static final String BENZINA = "benzina";
	public static final String DIESEL = "diesel";
	
	public static boolean carburanteValido(String carburante) {
		if (BENZINA.equals(carburante)) {
			return true;
		} else if (DIESEL.equals(carburante)) {
			return true;
		} else {
			return false;
		}
	}
}
