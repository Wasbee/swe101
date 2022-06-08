import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlbum {

	@Test
	public void testConstructor() 
	{
		Album a1 = new Album("My Album", 3);
		assertEquals("My Album", a1.getTitle());
		assertEquals(3, a1.getSize());
		assertEquals(0, a1.getDuration());

		Album a2 = new Album("My Second Album", 5);
		assertEquals("My Second Album", a2.getTitle());
		assertEquals(5, a2.getSize());
		assertEquals(0, a2.getDuration());
	}
	
	@Test
	public void testOneSong()
	{
		Album a1 = new Album("My Album", 3);
		Song s1 = new Song("Song Title", 272);
		a1.addSong(s1);
		
		assertEquals(s1, a1.getSong(0));
		assertEquals(1, a1.getNumberOfSongs());
	}
	
	@Test
	public void testFullAlbum()
	{
		Album a1 = new Album("My Full Album", 3);
		Song s1 = new Song("First Song", 272);
		Song s2 = new Song("Second Song", 305);
		Song s3 = new Song("Third Song", 249);
		
		a1.addSong(s1);
		a1.addSong(s2);
		a1.addSong(s3);
		
		assertEquals(3, a1.getNumberOfSongs());
		assertEquals(s1, a1.getSong(0));
		assertEquals(s2, a1.getSong(1));
		assertEquals(s3, a1.getSong(2));
	}
	
	@Test
	public void testDurationSimple()
	{
		Album a1 = new Album("My Album", 1);
		Song s1 = new Song("My Song", 100);
		
		a1.addSong(s1);
		assertEquals(s1.getDuration(), a1.getDuration());
	}
	
	@Test
	public void testDurationFull()
	{
		Album a1 = new Album("My Full Album", 3);
		Song s1 = new Song("First Song", 272);
		Song s2 = new Song("Second Song", 305);
		Song s3 = new Song("Third Song", 249);
		a1.addSong(s1);
		a1.addSong(s2);
		a1.addSong(s3);
		assertEquals(s1.getDuration() + s2.getDuration() + s3.getDuration(),
				a1.getDuration());
	}

	@Test
	public void testDurationPartiallyFull()
	{
		Album a1 = new Album("Partially Full Album", 3);
		Song s1 = new Song("First", 272);
		Song s2 = new Song("Second", 305);
		a1.addSong(s1);
		a1.addSong(s2);
		assertEquals(577, a1.getDuration());
	}
	
	@Test
	public void testToString()
	{
		Album a1 = new Album("My Full Album", 3);
		Song s1 = new Song("First Song", 272);
		Song s2 = new Song("Second Song", 305);
		Song s3 = new Song("Third Song", 249);
		
		a1.addSong(s1);
		a1.addSong(s2);
		a1.addSong(s3);
		
		assertEquals("My Full Album:"
				+ "\n\t"+s1.toString()
				+ "\n\t"+s2.toString()
				+ "\n\t"+s3.toString(), a1.toString());
	}


}
