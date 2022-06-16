package universita.primoAnno.secondoSemestre.programmazioneDue.varco;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import universita.primoAnno.secondoSemestre.programmazioneDue.varco.Veicolo;

public class TestEsameAuto {

	
	@Test
	public void testVeicoloKO() {
		try {
			Veicolo v = new Veicolo(null,"diesel");
			fail();
		} catch (VeicoloException e) {}

		try {
			Veicolo v = new Veicolo("","diesel");
			fail();
		} catch (VeicoloException e) {}
		
		try {
			Veicolo v = new Veicolo("AA111BB",null);
			fail();
		} catch (VeicoloException e) {}

		try {
			Veicolo v = new Veicolo("AA111BB","benz");
			fail();
		} catch (VeicoloException e) {}

}

	
	@Test
	public void testVeicoloOK() throws VeicoloException {
		Veicolo v1 = new Veicolo("AA111B","diesel");
		assertTrue("AA111B".equals(v1.getTarga()));
		assertTrue("diesel".equals(v1.getCarburante()));
		
		Veicolo v2 = new Veicolo("AA111B","benzina");
		assertTrue(v1.equals(v2));
		assertTrue(v1.hashCode()==v2.hashCode());
		
		assertTrue(v1.compareTo(v2)==0);
		
		Veicolo v3 = new Veicolo("BA111B","benzina");
		Veicolo v4 = new Veicolo("AA111A","diesel");
		assertTrue(v1.compareTo(v3)<0);
		assertTrue(v1.compareTo(v4)>0);
		
	}
	
	@Test
	public void testRegolaDiesel() throws VeicoloException {
		RegolaAccessoVietatoMotoriDiesel r = new RegolaAccessoVietatoMotoriDiesel("Accesso vietato ai diesel");
		Veicolo v1 = new Veicolo("AA111B","diesel");
		Veicolo v2 = new Veicolo("BA111B","benzina");
		assertTrue(r.multa(v1));
		assertFalse(r.multa(v2));
	}
	
	@Test
	public void testRegolaPagamentiKO() throws VeicoloException {
		RegolaAccessoAPagamento r = new RegolaAccessoAPagamento("Accesso a pagamento");
			r.registraPagamento(null);
			r.registraPagamento("");
			r.registraPagamento("AA111AA");
			try{
				r.registraPagamento("AA111AA");
				fail();
			}catch(VeicoloException e) {}		
	}
	
	@Test
	public void testRegolaPagamentiOK() throws VeicoloException {
		RegolaAccessoAPagamento r = new RegolaAccessoAPagamento("Accesso a pagamento");
			r.registraPagamento("AA111AA");
			r.registraPagamento("AA111BB");
			Veicolo v1 = new Veicolo("AA111BB","diesel");
			Veicolo v2 = new Veicolo("AA111CC","benzina");
			assertFalse(r.multa(v1));
			assertTrue(r.multa(v2));
	}
	
	
	@Test
	public void testVarcoNoRegola() throws VeicoloException {
		Varco v = new Varco(null);
		Veicolo v1 = new Veicolo("AA111BB","diesel");
		Veicolo v2 = new Veicolo("AA111CC","benzina");
		v.convalidaEntrata(v1);
		v.convalidaEntrata(v2);
		assertTrue(v.getMultati().size()==0);
	}
	
	@Test
	public void testVarcoRegolaDiesel() throws VeicoloException {
		Varco v = new Varco(new RegolaAccessoVietatoMotoriDiesel("no accesso diesel"));
		Veicolo v1 = new Veicolo("AA111BB","diesel");
		Veicolo v2 = new Veicolo("AA111CC","benzina");
		Veicolo v3 = new Veicolo("BB111BB","diesel");
		Veicolo v4 = new Veicolo("BB111CC","benzina");
		v.convalidaEntrata(v1);
		v.convalidaEntrata(v2);
		v.convalidaEntrata(v3);
		v.convalidaEntrata(v4);
		assertTrue(v.getMultati().size()==2);
		assertTrue(v.toString().contains("AA111BB"));
		assertTrue(v.toString().contains("BB111BB"));
	}
	
	@Test
	public void testVarcoRegolaPagamenti() throws VeicoloException {
		RegolaAccessoAPagamento r = new RegolaAccessoAPagamento("pagamento richiesto");
		Varco v = new Varco(r);
		Veicolo v1 = new Veicolo("AA111BB","diesel");
		Veicolo v2 = new Veicolo("AA111CC","benzina");
		Veicolo v3 = new Veicolo("BB111BB","diesel");
		Veicolo v4 = new Veicolo("BB111CC","benzina");
		r.registraPagamento("AA111CC");
		r.registraPagamento("BB111BB");
		v.convalidaEntrata(v1);
		v.convalidaEntrata(v2);
		v.convalidaEntrata(v3);
		v.convalidaEntrata(v4);
		assertTrue(v.getMultati().size()==2);
		assertTrue(v.toString().contains("AA111BB"));
		assertTrue(v.toString().contains("BB111CC"));
	}
}
