package universita.primoAnno.secondoSemestre.programmazioneDue.Riunione;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestEsameData {

	// TEST Riunione Virtuale
	@Test
	public void testRiunioneVirtualeOK() throws RiunioneNonValidaException {
		RiunioneVirtuale r = new RiunioneVirtuale(2022, 8, 22, 2);
		assertTrue("22/8/2022".equals(r.getData()));
		assertTrue(r.getImpegnoOrarioComplessivo() == 2);
	}

	@Test
	public void testConfrontoRiunioneVirtuale() throws RiunioneNonValidaException {
		RiunioneVirtuale r = new RiunioneVirtuale(2022, 8, 22, 2);
		RiunioneVirtuale r1 = new RiunioneVirtuale(2022, 8, 22, 3);
		RiunioneVirtuale r2 = new RiunioneVirtuale(2022, 8, 20, 2);
		RiunioneVirtuale r3 = new RiunioneVirtuale(2023, 8, 22, 2);

		assertTrue(r.compareTo(r1) == 0);
		assertTrue(r.compareTo(r2) > 0);
		assertTrue(r.compareTo(r3) < 0);
	}

	@Test
	public void testRiunioneVirtualeKO() throws RiunioneNonValidaException {
		try {
			RiunioneVirtuale r = new RiunioneVirtuale(1200, 8, 22, 2);
			fail();
		} catch (RiunioneNonValidaException r) {
		}

		try {
			RiunioneVirtuale r = new RiunioneVirtuale(2022, 15, 22, 2);
			fail();
		} catch (RiunioneNonValidaException r) {
		}

		try {
			RiunioneVirtuale r = new RiunioneVirtuale(2022, 8, 50, 2);
			fail();
		} catch (RiunioneNonValidaException r) {
		}

		try {
			RiunioneVirtuale r = new RiunioneVirtuale(2022, 8, 22, 0);
			fail();
		} catch (RiunioneNonValidaException r) {
		}

	}

	// TEST Riunione in presenza
	@Test
	public void testRiunioneInPresenzaOK() throws RiunioneNonValidaException {
		RiunioneInPresenza r = new RiunioneInPresenza(2022, 8, 22, 2, 1);
		assertTrue("22/8/2022".equals(r.getData()));
		assertTrue(r.getImpegnoOrarioComplessivo() == 4);
	}

	@Test
	public void testConfrontoRiunioneInPresenza() throws RiunioneNonValidaException {
		RiunioneInPresenza r = new RiunioneInPresenza(2022, 8, 22, 2, 1);
		RiunioneInPresenza r1 = new RiunioneInPresenza(2022, 8, 22, 3, 1);
		RiunioneInPresenza r2 = new RiunioneInPresenza(2022, 8, 20, 2, 1);
		RiunioneInPresenza r3 = new RiunioneInPresenza(2023, 8, 22, 2, 1);


		assertTrue(r.compareTo(r1) == 0);
		assertTrue(r.compareTo(r2) > 0);
		assertTrue(r.compareTo(r3) < 0);
	}

	@Test
	public void testRiunioneInPresenzaKO() throws RiunioneNonValidaException {
		try {
			RiunioneInPresenza r = new RiunioneInPresenza(1200, 8, 22, 2,1);
			fail();
		} catch (RiunioneNonValidaException r) {
		}

		try {
			RiunioneInPresenza r = new RiunioneInPresenza(2022, 15, 22, 2,1);
			fail();
		} catch (RiunioneNonValidaException r) {
		}

		try {
			RiunioneInPresenza r = new RiunioneInPresenza(2022, 8, 50, 2,1);
			fail();
		} catch (RiunioneNonValidaException r) {
		}

		try {
			RiunioneInPresenza r = new RiunioneInPresenza(2022, 8, 22, 0,1);
			fail();
		} catch (RiunioneNonValidaException r) {
		}

		try {
			RiunioneInPresenza r = new RiunioneInPresenza(2022, 8, 22, 1,0);
			fail();
		} catch (RiunioneNonValidaException r) {
		}
	}
	
	// TEST toString riunioni
	@Test
	public void testRiunionitoString() throws RiunioneNonValidaException {
		RiunioneVirtuale r = new RiunioneVirtuale(2022, 8, 22, 12);
		assertTrue(r.toString().indexOf("12")>0);
		RiunioneInPresenza r2 = new RiunioneInPresenza(2022, 8, 22, 10,3);
		assertTrue(r2.toString().indexOf("16")>0);
	}
	
	// TEST ciclo riunioni
	@Test
	public void testCicloRiunioni() throws RiunioneNonValidaException {
	
		CicloRiunioni ciclo = new CicloRiunioni();
		
		assertTrue(0==ciclo.getNumeroRiunioni());
		assertTrue(0==ciclo.getNumeroRiunioniVirtuali());
		assertTrue(0==ciclo.calcolaImpegnoComplessivo());
		
		RiunioneVirtuale r = new RiunioneVirtuale(2022, 8, 22, 2);
		RiunioneVirtuale r1 = new RiunioneVirtuale(2022, 8, 22, 3);
		RiunioneVirtuale r2 = new RiunioneVirtuale(2022, 8, 20, 2);
		RiunioneVirtuale r3 = new RiunioneVirtuale(2023, 8, 22, 2);
		
		ciclo.aggiungiRiunione(r);
		ciclo.aggiungiRiunione(r1);
		ciclo.aggiungiRiunione(r2);
		ciclo.aggiungiRiunione(r3);
		assertTrue(3==ciclo.getNumeroRiunioni());
		assertTrue(3==ciclo.getNumeroRiunioniVirtuali());
		assertTrue(6==ciclo.calcolaImpegnoComplessivo());
		
		RiunioneInPresenza r4 = new RiunioneInPresenza(2022, 8, 22, 2, 1);
		RiunioneInPresenza r5 = new RiunioneInPresenza(2022, 8, 22, 3, 1);
		RiunioneInPresenza r6 = new RiunioneInPresenza(2022, 10, 20, 2, 1);
		RiunioneInPresenza r7 = new RiunioneInPresenza(2022, 11, 22, 3, 1);
		ciclo.aggiungiRiunione(r4);
		ciclo.aggiungiRiunione(r5);
		ciclo.aggiungiRiunione(r6);
		ciclo.aggiungiRiunione(r7);		
		assertTrue(5==ciclo.getNumeroRiunioni());
		assertTrue(3==ciclo.getNumeroRiunioniVirtuali());
		assertTrue(15==ciclo.calcolaImpegnoComplessivo());
	}
	
	@Test
	public void testCicloRiunioniOrdinamento() throws RiunioneNonValidaException {
	
		CicloRiunioni ciclo = new CicloRiunioni();
		
		RiunioneVirtuale r = new RiunioneVirtuale(2023, 8, 22, 2);
		RiunioneVirtuale r1 = new RiunioneVirtuale(2023, 8, 21, 3);
		RiunioneInPresenza r2 = new RiunioneInPresenza(2023, 7, 21, 2, 1);
		RiunioneInPresenza r3 = new RiunioneInPresenza(2022, 7, 21, 3, 1);
		
		ciclo.aggiungiRiunione(r);
		ciclo.aggiungiRiunione(r1);
		ciclo.aggiungiRiunione(r2);
		ciclo.aggiungiRiunione(r3);

		String s = ciclo.toString();
		
		assertTrue(s.indexOf("2022") < s.indexOf("2023"));
		
	}
}
