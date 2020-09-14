package Steg3;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;




class StandardTestClass {
		
		@Test
		void testboolean() {
			booleantest2 passwordtest = new booleantest2();
			assertTrue(passwordtest.add("test"));
			
		}
		
		@Test
		void testbooleanFails() {
			booleantest2 passwordtest = new booleantest2();
			assertTrue(passwordtest.add("tescvcvt"));
			
		}
		
		
}
	
//annotations talar om f�r JUnit den ska utf�ra n�gon test typ
//@test talar om f�r JUnit detta �r en test metod
//assertions JUnits test metoder
//assertEquals man f�rv�ntar sig ett nummer(int) och kollar metoden returnerar r�tt, d�rf�r andra exmeplet
// failade f�r den f�rv�ntade sig 2 men fick 1+2=3



//Egna tests


class booleantest2 {
	
	public boolean add(String password) {
		
		if(password.toLowerCase().equals("test")) {
			return true;
		} else return false;
					}

}
