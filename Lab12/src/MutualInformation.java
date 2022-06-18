
/**
 * @author janmolina
 *
 */
public class MutualInformation 
{
	private int ingredientNumber;
	private int totalMutualInformation;
	
	/**
	 * @param ingredientNumber
	 * @param totalMutualInformation
	 */
	public MutualInformation(int ingredientNumber,
			int totalMutualInformation)
	{
		this.ingredientNumber = ingredientNumber;
		this.totalMutualInformation = totalMutualInformation;
	}
	/**
	 * @return the ingredient number
	 */
	public int getIngredientNumber()
	{
		return ingredientNumber;
	}
	/**
	 * @return the total mutual information
	 */
	public int getTotalMutualInformation()
	{
		return totalMutualInformation;
	}
	

}
