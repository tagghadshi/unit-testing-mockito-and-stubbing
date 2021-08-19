package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
class BiscuitTest {

	@Test
	void testEquals() {
		Biscuit theBiscuit = new Biscuit("Ginger");
		Biscuit myBiscuit = new  Biscuit("Ginger");
//		assertEquals(theBiscuit.toString(), myBiscuit.toString());
		assertThat(theBiscuit, equalTo(myBiscuit));
	}

}
