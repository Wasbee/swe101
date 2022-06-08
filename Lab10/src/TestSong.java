import static org.junit.Assert.*;

import org.junit.Test;

public class TestSong 
{

	/**
	 * Test the constructor
	 */
	@Test
	public void testCreation()
	{
		Song s1 = new Song("First Song Title", 246);
		Song s2 = new Song("Second Song Title", 340);
		assertEquals(246, s1.getDuration());
		assertEquals(340, s2.getDuration());
		assertEquals("First Song Title", s1.getTitle());
		assertEquals("Second Song Title", s2.getTitle());
	}
	
	/**
	 * Test toString
	 */
	@Test
	public void testToString()
	{
		Song s2 = new Song("First Song Title", 340);
		assertEquals("First Song Title: 5:40", s2.toString());
	}

	/**
	 * Test toString - with leading zero in seconds
	 */
	@Test
	public void testToString2()
	{
		Song s1 = new Song("Song Title", 246);
		assertEquals("Song Title: 4:06", s1.toString());
	}

}
