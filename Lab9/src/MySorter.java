
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
	
	public int maxPosition(int[] array, int endPos)
	{
		int maxPos = 0;
		int max = 0;
		for (int i = 0; i < endPos; i++)
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
	 */
	public void insertionSort(int[] array) 
	{
		
	}
	
	/**
	 * Selection sort
	 */
	public void selectionSort(int[] array)
	{
		
	}

}
