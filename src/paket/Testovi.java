package paket;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DodavanjeUKorpuTest.class, 
			   FacebookTest.class, 
			   ONamaTest.class, 
			   PerformanceTest.class, 
			   PretragaTest.class, 
			   PrijavaTest.class, 
			   ProveraPodatakaTest.class, 
			   RegistracijaTest.class, 
			   UkupnaCenaTest.class})
public class Testovi{}
