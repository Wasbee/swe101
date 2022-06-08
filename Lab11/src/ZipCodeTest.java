import static org.junit.Assert.*;

import org.junit.Test;

public class ZipCodeTest {

	@Test
	public void testInitializationSimple()
	{
		ZipCode z1 = new ZipCode(17257);
		assertEquals("17257", z1.toString());
		
		ZipCode z2 = new ZipCode(12340);
		assertEquals("12340", z2.toString());

	}
	@Test
	public void testConstructorBorder()
	{
		ZipCode z1 = new ZipCode(1234);
		assertEquals("01234", z1.toString());
		
		z1 = new ZipCode(123);
		assertEquals("00123", z1.toString());
		
		z1 = new ZipCode(1);
		assertEquals("00001", z1.toString());
		
	}

}
