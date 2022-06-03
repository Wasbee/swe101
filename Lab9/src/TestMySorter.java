import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMySorter
{



	@Test
	public void testBubbleSort()
	{
		int[] x = {5, 3, 8, 1};
		MySorter s = new MySorter();
		s.bubbleSort(x);
		for (int i = 0; i < x.length - 1; i++)
		{
			assertTrue("Out of order at " + i, x[i] < x[i + 1]);
		}
	}
	
	@Test
	public void testMaxPositionMiddle()
	{
		int[] x = {1, 5, 3, 7, 8, 9};
		MySorter s = new MySorter();
		assertEquals(1, s.maxPosition(x, 2));
	}
	
	@Test
	public void testMaxPositionFirst()
	{
		
	}
	
	@Test public void testMaxPositionLast()
	{
		
	}
	
	@Test
	public void testMaxPositionOneElement()
	{
		
	}
	
	@Test
	public void testMaxPositionNegative()
	{
		int[] x = {-7, -6, -8, -3, -1};
		MySorter s = new MySorter();
		assertEquals(1, s.maxPosition(x, 2));
	}
	
	@Test
	public void testSelectionSmall()
	{
		
	}
	
	@Test
	public void testInsertionSmall()
	{
		
	}

}
