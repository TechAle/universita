package universita.primoAnno.secondoSemestre.programmazioneDue.Allenamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class EsameTestAllenamento {

	//===== TEST STEPPER
	@Test
	public void testStepperCreazioneOK() throws DataException {
		Stepper s = new Stepper (2021, 1, 18, 500);
		assertEquals(2021, s.getAnno());
		assertEquals(1, s.getMese());		
		assertEquals(18, s.getGiorno());
		assertEquals(1000, s.calorie());
	}
	
	@Test
	public void testStepperCreazioneKO() {
		
		Stepper s;
		try {
			s = new Stepper (1900, 1, 18, 500);
			fail();
		} catch (DataException e) {
			// OK
		}
		
		try {
			s = new Stepper (2021, 15, 18, 500);
			fail();
		} catch (DataException e) {
			// OK
		}
		
		try {
			s = new Stepper (2021, 1, 34, 500);
			fail();
		} catch (DataException e) {
			// OK
		}
	}
	
		@Test
		public void testStepperEquals() throws DataException {
			Stepper s1 = new Stepper (2021, 1, 18, 500);
			Stepper s2 = new Stepper (2021, 1, 18, 500);		
			Stepper s3 = new Stepper (2021, 5, 18, 500);	
			Stepper s4 = new Stepper (2021, 5, 18, 400);	
			
			assertTrue(s1.equals(s2));
			assertTrue(s1.equals(s3));
			assertFalse(s1.equals(s4));
		}
	
		
		//===== TEST CYCLETTE
		@Test
		public void testCycletteCreazioneOK() throws DataException {
			Cyclette c = new Cyclette(2021, 1, 18, 30);
			assertEquals(2021, c.getAnno());
			assertEquals(1, c.getMese());		
			assertEquals(18, c.getGiorno());
			assertEquals(90, c.calorie());
			
			c = new Cyclette(2021, 1, 18, 10);
			assertEquals(2021, c.getAnno());
			assertEquals(1, c.getMese());		
			assertEquals(18, c.getGiorno());
			assertEquals(20, c.calorie());
		}
		
		@Test
		public void testCycletteCreazioneKO() {
			
			Cyclette c;
			try {
				c = new Cyclette(1900, 1, 18, 500);
				fail();
			} catch (DataException e) {
				// OK
			}
			
			try {
				c = new Cyclette (2021, 15, 18, 500);
				fail();
			} catch (DataException e) {
				// OK
			}
			
			try {
				c= new Cyclette (2021, 1, 34, 500);
				fail();
			} catch (DataException e) {
				// OK
			}
		}
		
			@Test
			public void testCycletteEquals() throws DataException {
				Cyclette c1 = new Cyclette (2021, 1, 18, 30);
				Cyclette c2 = new Cyclette (2021, 1, 18, 30);		
				Cyclette c3 = new Cyclette (2021, 5, 18, 30);	
				Cyclette c4 = new Cyclette (2021, 5, 18, 10);	
				
				assertTrue(c1.equals(c2));
				assertTrue(c1.equals(c3));
				assertFalse(c1.equals(c4));
			}
		
			//===== TEST REGISTRO ALLENAMENTI
			
			@Test
			public void testRegistroVuoto() throws DataException{
				RegistroAllenamenti r = new RegistroAllenamenti();
				assertEquals(0,r.calorieComplessive());
				assertEquals(0,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 30)));
			}
	
			@Test
			public void testAggiungiEsercizio() throws DataException{
				RegistroAllenamenti r = new RegistroAllenamenti();
				Esercizio e1 = new Cyclette(2021, 1, 18, 30);
				Esercizio e2 = new Cyclette (2021, 5, 18, 10);
				Esercizio e3 = new Stepper (2021, 1, 18, 500);
				Esercizio e4 = new Cyclette(2021, 6, 18, 30);
				r.aggiungiEsercizio(e1);
				r.aggiungiEsercizio(e2);
				r.aggiungiEsercizio(e3);
				r.aggiungiEsercizio(e4);
				
				assertEquals(1200,r.calorieComplessive());
				assertEquals(1,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 10)));
				assertEquals(2,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 30)));
				
			}
			
			@Test
			public void testAggiungiEsercizi() throws DataException{
				RegistroAllenamenti r = new RegistroAllenamenti();
				Esercizio e1 = new Cyclette(2021, 1, 18, 30);
				Esercizio e2 = new Cyclette (2021, 5, 18, 10);
				Esercizio e3 = new Stepper (2021, 1, 18, 500);
				Esercizio e4 = new Cyclette(2021, 6, 18, 30);
				Esercizio[] lista = new Esercizio[4];
				lista[0]=e1;
				lista[1]=e2;
				lista[2]=e3;
				lista[3]=e4;
				r.aggiungiEsercizio(lista);
				
				assertEquals(1200,r.calorieComplessive());
				assertEquals(1,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 10)));
				assertEquals(2,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 30)));
				
			}
			
			@Test
			public void testAggiungiEserciziNull() throws DataException{
				RegistroAllenamenti r = new RegistroAllenamenti();
				
				//aggiunta null con registro vuoto
				Esercizio e = null;
				r.aggiungiEsercizio(e);
				assertEquals(0,r.calorieComplessive());
				assertEquals(0,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 30)));
				
				//aggiunta null con registro non vuoto
				Esercizio e1 = new Cyclette(2021, 1, 18, 30);
				Esercizio e2 = new Cyclette (2021, 5, 18, 10);
				Esercizio e3 = new Stepper (2021, 1, 18, 500);
				Esercizio e4 = new Cyclette(2021, 6, 18, 30);
				r.aggiungiEsercizio(e1);
				r.aggiungiEsercizio(e2);
				r.aggiungiEsercizio(e3);
				r.aggiungiEsercizio(e4);
				r.aggiungiEsercizio(e);
				
				assertEquals(1200,r.calorieComplessive());
				assertEquals(1,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 10)));
				assertEquals(2,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 30)));
				
				//null presente nella lista di esercizi aggiunti
				 e1 = new Cyclette(2021, 1, 18, 30);
				 e2 = new Cyclette (2021, 5, 18, 10);
				 e3 = new Stepper (2021, 1, 18, 500);
				 e4 = new Cyclette(2021, 6, 18, 30);
				Esercizio[] lista = new Esercizio[5];
				lista[0]=e1;
				lista[1]=e2;
				lista[2]=null;
				lista[3]=e3;
				lista[4]=e4;
				r.aggiungiEsercizio(lista);
				
				assertEquals(2400,r.calorieComplessive());
				assertEquals(2,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 10)));
				assertEquals(4,r.contaEserciziUguali(new Cyclette(2021, 1, 18, 30)));
				
				//equals con null
				assertEquals(0,r.contaEserciziUguali(null));
				
			}
			
}
