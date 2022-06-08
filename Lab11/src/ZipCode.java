
public class ZipCode 
{
	private int zipCode;
	
	public ZipCode(int z)
	{
		zipCode = z;
	}
	public int getCheckDigit()
	{
		return 0;
	}
	public String getBarCode()
	{
		return null;
	}
	public String toString()
	{
		if (zipCode > 10000)
		{
			return Integer.toString(zipCode);
		}
		
		int digits = Integer.toString(zipCode).length();
		String str = new String();
		for (int i = 0; i < 5 - digits; i++)
		{
			str += "0";
		}
		return str + Integer.toString(zipCode);
	}

}
