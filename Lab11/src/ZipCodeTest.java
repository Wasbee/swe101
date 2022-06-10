import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * ZipCode tester
 * @author janmolina
 */
public class ZipCodeTest 
{
	/**
	 * Test initialization
	 * @throws ZipCodeException
	 */
	@Test
	public void testInitializationSimple()throws ZipCodeException
	{
		ZipCode z1 = new ZipCode(17257);
		assertEquals("17257", z1.toString());
		
		ZipCode z2 = new ZipCode(12340);
		assertEquals("12340", z2.toString());

	}
	/**
	 * Test initialization for smaller zipcodes
	 * @throws ZipCodeException
	 */
	@Test
	public void testConstructorBorder()throws ZipCodeException
	{
		ZipCode z1 = new ZipCode(1234);
		assertEquals("01234", z1.toString());
		
		z1 = new ZipCode(123);
		assertEquals("00123", z1.toString());
		
		z1 = new ZipCode(12);
		assertEquals("00012", z1.toString());
		
		z1 = new ZipCode(1);
		assertEquals("00001", z1.toString());
		
	}
	
	/**
	 * Test getCheckDigit 
	 * @throws ZipCodeException
	 */
	@Test
	public void testCheckDigit()throws ZipCodeException
	{
		//  1 + 7 + 3 + 2 + 5 = 18, so must check digit must be 2
		ZipCode z1 = new ZipCode(17325);
		assertEquals(2, z1.getCheckDigit());
		
		//  1 + 2 + 3 = 6, so must check digit must be 4
		z1 = new ZipCode(123);
		assertEquals(4, z1.getCheckDigit());
		
		//  3 + 4 = 7, so must check digit must be 3
		z1 = new ZipCode(34);
		assertEquals(3, z1.getCheckDigit());
	}
	
	/**
	 * Test getCheckDigit border
	 * @throws ZipCodeException
	 */
	@Test
	public void testCheckDigitBorder()throws ZipCodeException
	{
		ZipCode z1 = new ZipCode(1234);
		assertEquals(0, z1.getCheckDigit());

		z1 = new ZipCode(11234);
		assertEquals(9, z1.getCheckDigit());
		
		z1 = new ZipCode(34);
		assertEquals(3, z1.getCheckDigit());
	}
	
	/**
	 * Test that barcode generation works properly
	 * @throws ZipCodeException
	 */
	@Test
	public void testBarCode() throws ZipCodeException
	{
		ZipCode z1 = new ZipCode(17257);
		assertEquals("|```|||```|``|`|`|`|`|```||``|`|", z1.getBarCode());
		
		z1 = new ZipCode(12345);
		assertEquals("|```||``|`|``||``|``|`|`|``|`|`|", z1.getBarCode());
		
		z1 = new ZipCode(67890);
		assertEquals("|`||``|```||``|`|`|``||```||```|", z1.getBarCode());
		
	}
	
	/**
	 * Test Zipcode negative
	 * @throws ZipCodeException
	 */
	@Test (expected = ZipCodeException.class)
	public void testNegative() throws ZipCodeException
	{
		ZipCode z = new ZipCode(-1);
	}
	
	/**
	 * Test Zipcode too small
	 * @throws ZipCodeException
	 */
	@Test (expected = ZipCodeException.class)
	public void testTooSmall() throws ZipCodeException
	{
		ZipCode z = new ZipCode(0);
	}
	
	/**
	 * Test zipcode too big
	 * @throws ZipCodeException
	 */
	@Test (expected = ZipCodeException.class)
	public void testTooBig() throws ZipCodeException
	{
		ZipCode z = new ZipCode(100000);
	}

}
