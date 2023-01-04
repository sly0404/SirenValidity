package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import siren.Siren;
import siren.SirenImpl;

class SirenTest
{

	Siren siren = new SirenImpl();
	
	@Test
	void testSirenLength()
	{
		String sirenString = "7328293208293";
		boolean isValid = siren.checkSirenValidity(sirenString);
		assertFalse(isValid, "Length must be exactly 9 digits!");
	}
	
	@Test
	void testSirenNumericOnly()
	{
		String sirenString = "73282xv23";
		boolean isValid = siren.checkSirenValidity(sirenString);
		assertFalse(isValid, sirenString + " must contain only digits characters!");
	}
	
	@Test
	void testSiren()
	{
		String sirenString = "732829320";
		boolean isValid = siren.checkSirenValidity(sirenString);
		assertTrue(isValid, sirenString + " is invalid!");
	}
	
	@Test
	void testSiren2()
	{
		String sirenString = "732829326";
		boolean isValid = siren.checkSirenValidity(sirenString);
		assertFalse(isValid, sirenString + " is invalid!");
	}
	
	@Test
	void testSiren3()
	{
		String sirenString = "111111175";
		boolean isValid = siren.checkSirenValidity(sirenString);
		assertTrue(isValid, sirenString + " is invalid!");
	}
	
	@Test
	void testcomputeSirenSum1()
	{
		String sirenString = "11111117";
		String fullSiren = siren.computeFullSiren(sirenString);
		assertEquals("111111175", fullSiren);
	}
	
	@Test
	void testcomputeSirenSum2()
	{
		String sirenString = "73282932";
		String fullSiren = siren.computeFullSiren(sirenString);
		assertEquals("732829320", fullSiren);
	}
}
