/**
 * Lab9 - MySorter
 * @author jm8721
 *
 */
public class MySorter 
{
	public MySorter()
	{
		
	}
	/** Swap the values in two positions of an array
	 * 
	 * @param x the array
	 * @param i the first position to be swapped
	 * @param j the second position to be swapped
	 */
	private void swap(int[] x, int i, int j)
	{
		int tmp = x[i];
		x[i] = x[j];
		x[j] = tmp;
	}
	
	/**
	 * Bubble sort
	 * @param array - the array to be sorted
	 */
	public void bubbleSort(int[] array)
	{
		for (int i = 0; i < array.length-1; i++)
		{
			for (int j = 0; j < array.length -1; j++)
			{
				if (array[j] > array[j + 1])
				{
					swap(array, j, j + 1);
				}
			}
		}
	}
	
	/**
	 * Max Position
	 * @param array
	 * @param endPos
	 * @return the index of the largest element within range.
	 */
	public int maxPosition(int[] array, int endPos)
	{
		int maxPos = 0;
		int max = array[0];
		for (int i = 0; i < endPos+1; i++)
		{
			if (array[i] > max)
			{
				max = array[i];
				maxPos = i;
			}
		}
		return maxPos;
	}
	
	/** 
	 * Insertion sort
	 * @param array
	 */
	public void insertionSort(int[] array) 
	{
		for (int i = 0; i < array.length; i++)
		{
			int pos = i;
			while (pos > 0 && array[pos] < array[pos-1])
			{
				swap(array, pos, pos-1);
				pos--;
			}
		}
	}
	
	/**
	 * Selection sort
	 * @param array
	 */
	public void selectionSort(int[] array)
	{
		//  5 3 8 1
		for (int i = array.length - 1; i > 0; i--)
		{
			int maxpos = maxPosition(array, i);
			swap(array, i, maxpos);
		}
	}

}
