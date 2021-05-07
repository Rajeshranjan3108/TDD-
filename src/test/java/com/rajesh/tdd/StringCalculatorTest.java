package com.rajesh.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple App.
 */
public class StringCalculatorTest 
{
	 private StringCalculator calculator;

	    @Rule
	    public ExpectedException thrown = ExpectedException.none();

	    @Before
	    public void initialize() {
	        calculator = new StringCalculator();
	    }

	    @Test
	    public void emptyStringShouldReturn0() {
	        assertEquals(calculator.add(""), 0);
	    }

	    @Test
	    public void numberStringShouldReturnSameNumber() {
	        assertEquals(calculator.add("1"), 1);
	    }

	    @Test
	    public void numbersCommaDelimitedShouldBeSummed() {
	        assertEquals(calculator.add("1,2"), 3);
	    }
	    
	    @Test
	    public void unknownAmoutntOfNumbers() {
	    	assertEquals(calculator.add("1,2,3,4,5,6,7,8,9"), 45);
	    }

	    @Test
	    public void numbersNewlineBetweenNumbers() {
	        assertEquals(calculator.add("1\n2,3"), 6);
	    }

	    @Test
	    public void numbersWithDifferentDelimiters() {
	        assertEquals(calculator.add("//3;\n1;2"), 6);
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void negativeInputReturnsException() {
	        calculator.add("-1");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void multipleNegativeInputReturnsException() {
	        calculator.add("-5,10\n-15");
	    }
	    
	    @Test
	    public void numbersGreaterThan1000AreIgnored() {
	        assertEquals(calculator.add("2,1001"), 2);
	    }
	    
	    @Test
	    public void callingAddMethodHowManyTimes() {
	    	assertEquals(calculator.getCalledCount(), 9);
	    }
}
