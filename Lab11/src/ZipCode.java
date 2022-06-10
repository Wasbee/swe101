
/**
 * 
 * @author janmolina
 *
 */
public class ZipCode 
{
	private int[] zipDigits;
	private static final int NUM_DIGITS = 5;
	private static final String[] CODE = 
		{"||```", // 0
		 "```||", // 1
		 "``|`|", // 2
		 "``||`", // 3
		 "`|``|", // 4
		 "`|`|`", // 5
		 "`||``", // 6
		 "|```|", // 7
		 "|``|`", // 8
		 "|`|``" };
	// Zip 67890 = |`||``|```||``|`|`|``||```||```|
		
	/**
	 * Constructor
	 * @param z - the zipcode
	 * @throws ZipCodeException 
	 */
	public ZipCode(int z) throws ZipCodeException
	{
		if (z <= 0)
		{
			throw new ZipCodeException("Zipcode too small: " + z);
		}
		if ((Math.floor(Math.log10(z)) + 1) > NUM_DIGITS)
		{
			throw new ZipCodeException("Zipcode too large: " + z);
		}
		zipDigits = new int[NUM_DIGITS];
		for (int i = 0; i < NUM_DIGITS; i++)
		{
			zipDigits[i] = z % 10;
			z = z / 10;
		}
	}
	
	/**
	 * @return barcode string
	 */
	public String getBarCode()
	{
		String barcode = new String();
		barcode += '|';
		for (int i = NUM_DIGITS - 1; i >= 0; i--)
		{
			barcode += CODE[zipDigits[i]];
		}
		barcode += CODE[getCheckDigit()];
		barcode += '|';
		
		return barcode;
	}
	
	/**
	 * @return the check digit
	 */
	public int getCheckDigit()
	{
		int sum = 0;
		for(int i = 0; i < NUM_DIGITS; i++)
		{
			sum += zipDigits[i];
		}
		if (sum % 10 == 0)
		{
			sum = 0;
		} 
		else
		{
			sum = 10 - (sum % 10);
		}
		return sum;
	}
	
	/**
	 * toString override
	 */
	public String toString()
	{
		String str = new String();
		for (int i = NUM_DIGITS - 1; i >= 0; i--)
		{
			str += Integer.toString(zipDigits[i]);
		}
		return str;
	}

}
