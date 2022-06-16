package universita.primoAnno.secondoSemestre.programmazioneDue.gara;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class EsameTest {

// ======================= TEST RUNNER ======================
	@Test
	public void testRunnerOK() throws RunnerNotValidException {
		Runner r = new Runner(22, 34, "12345");
		assertEquals(22, r.getEta());
		assertEquals(34, r.getMigliorTempo());
		assertEquals("12345", r.getIdRunner());

		Runner r2 = new Runner(22, 34, "12346");
		Runner r3 = new Runner(23, 35, "12345");
		assertFalse(r.equals(r2));
		assertTrue(r.equals(r3));
	}

	@Test
	public void testRunnerKO() throws RunnerNotValidException {
		try {
			Runner r = new Runner(9, 34, "12345");
			fail();
		} catch (RunnerNotValidException e) {
			// ok
		}

		try {
			Runner r = new Runner(105, 34, "12345");
			fail();
		} catch (RunnerNotValidException e) {
			// ok
		}

		try {
			Runner r = new Runner(22, 0, "12345");
			fail();
		} catch (RunnerNotValidException e) {
			// ok
		}

		try {
			Runner r = new Runner(22, 34, null);
			fail();
		} catch (RunnerNotValidException e) {
			// ok
		}

		try {
			Runner r = new Runner(22, 34, "");
			fail();
		} catch (RunnerNotValidException e) {
			// ok
		}
	}

// ====================== TEST ISCRIZIONI ======================

	@Test
	public void testIscrizioneGaraAgonistica() throws RunnerNotValidException {
		GaraAgonistica gara = new GaraAgonistica(30);
		Runner r = new Runner(22, 28, "1234");
		Runner r2 = new Runner(21, 24, "1234");

		Runner r3 = new Runner(22, 27, "2234");
		Runner r4 = new Runner(22, 35, "3234");

		
		assertEquals(0,gara.getNumIscritti());
		gara.iscrivi(r);
		assertEquals(1,gara.getNumIscritti());
		
		try {
			gara.iscrivi(r2);
		} catch (RunnerNotValidException e) {// OK
		}
		assertEquals(1,gara.getNumIscritti());
		
		gara.iscrivi(r3);
		assertEquals(2,gara.getNumIscritti());
		
		try {
			gara.iscrivi(r4);
		} catch (RunnerNotValidException e) {// OK
		}
		assertEquals(2,gara.getNumIscritti());
		
	}

	@Test
	public void testIscrizioneGaraNonAgonistica() throws RunnerNotValidException {
		GaraNonAgonistica gara = new GaraNonAgonistica(20,80);
		Runner r = new Runner(22, 28, "1234");
		Runner r2 = new Runner(34, 24, "1234");

		Runner r3 = new Runner(24, 27, "7234");
		Runner r4 = new Runner(10, 27, "2234");
		Runner r5 = new Runner(80, 35, "3234");

		
		assertEquals(0,gara.getNumIscritti());
		gara.iscrivi(r);
		assertEquals(1,gara.getNumIscritti());
		
		try {
			gara.iscrivi(r2);
		} catch (RunnerNotValidException e) {// OK
		}
		assertEquals(1,gara.getNumIscritti());
		
		gara.iscrivi(r3);
		assertEquals(2,gara.getNumIscritti());
		
		try {
			gara.iscrivi(r4);
		} catch (RunnerNotValidException e) {// OK
		}
		assertEquals(2,gara.getNumIscritti());

		gara.iscrivi(r5);
		
		assertEquals(3,gara.getNumIscritti());
	}
	
	@Test
	public void testIscrizioneMultiple() throws RunnerNotValidException {
		GaraAgonistica gara = new GaraAgonistica(30);
		
		ArrayList<Runner> partecipanti = new ArrayList<Runner>();
		
		Runner r = new Runner(22, 28, "1234");
		Runner r2 = new Runner(21, 24, "1234"); // no

		Runner r3 = new Runner(22, 27, "2234");
		Runner r4 = new Runner(22, 35, "3234"); // no
		Runner r5 = new Runner(22, 28, "1734");

		partecipanti.add(r);
		partecipanti.add(r2);		
		partecipanti.add(r3);		
		partecipanti.add(r4);
		partecipanti.add(r5);
		
		int numNonAccettati=gara.iscrivi(partecipanti);
		
		assertEquals(2,numNonAccettati);
		assertEquals(3,gara.getNumIscritti());
		
		ArrayList<Runner> partecipanti2 = new ArrayList<Runner>();
		partecipanti2.add(r4);
		
		numNonAccettati=gara.iscrivi(partecipanti2);
		
		assertEquals(1,numNonAccettati);
		assertEquals(3,gara.getNumIscritti());
	}	
	
	// ====================== TEST VINCITORE GARA ======================
	@Test
	public void testVincitore() throws RunnerNotValidException {
		GaraAgonistica gara = new GaraAgonistica(30);
		Runner r = new Runner(22, 28, "1234");
		Runner r2 = new Runner(22, 25, "3234");
		Runner r3 = new Runner(28, 25, "3634");
		
		gara.iscrivi(r);
		gara.iscrivi(r2);
		
		assertEquals(null, gara.getVincitore());
		
		try {
		gara.setVincitore(r3);
		}catch(RunnerNotValidException e) { //OK
		}
		
		assertEquals(null, gara.getVincitore());
		
		gara.setVincitore(r2);
		assertEquals(r2, gara.getVincitore());
	
	}
	
	// ====================== TEST FASCIA ETA ======================
	@Test
	public void testFasciaEta() throws RunnerNotValidException {
		GaraAgonistica gara = new GaraAgonistica(30);
		Runner r = new Runner(22, 28, "1234");
		Runner r2 = new Runner(31, 24, "5234");

		Runner r3 = new Runner(42, 27, "2234");
		Runner r4 = new Runner(32, 25, "3234");

		gara.iscrivi(r);
		gara.iscrivi(r2);
		gara.iscrivi(r3);
		gara.iscrivi(r4);
		
		ArrayList<Runner> runners = gara.getIscrittiClasseEta(30);
		assertEquals(3,runners.size());
		assertTrue(runners.contains(r2));
		assertTrue(runners.contains(r3));
		assertTrue(runners.contains(r4));

		runners = gara.getIscrittiClasseEta(5);
		assertEquals(4,runners.size());
		assertTrue(runners.contains(r));
		assertTrue(runners.contains(r2));
		assertTrue(runners.contains(r3));
		assertTrue(runners.contains(r4));

		runners = gara.getIscrittiClasseEta(70);
		assertEquals(0,runners.size());

	}
}
