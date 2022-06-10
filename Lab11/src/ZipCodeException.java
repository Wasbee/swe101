
/**
 * Exceptions caused by invalid zip codes
 * @author janmolina
 *
 */
public class ZipCodeException extends Exception
{
	private String message;
	
	/**
	 * @param string
	 */
	public ZipCodeException(String string)
	{
		this.message = string;
	}
	
	/**
	 * toString override
	 */
	public String toString()
	{
		return message;
	}

}
