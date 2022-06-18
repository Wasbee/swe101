
/**
 * @author janmolina
 *
 */
public class FeatureSelector 
{
	private RecipeData recipeData;
	public FeatureSelector(RecipeData r)
	{
		recipeData = r;
	}

	/**
	 * @param cuisineNum
	 * @param ingredientNum
	 * @return mutual information for the particular cuisine and ingredient
	 */
	public int mutualInformation(int cuisineNum, int ingredientNum) 
	{
		String cuisineName = recipeData.getCuisineName(cuisineNum);
		
		// I WAS using this, but it caused an arrayIndexOutOfBounds exception on RecipeMiner
		//int numberOfCuisines = recipeData.getNumberOfCuisines(); 
		int sum = 0;
		for (int i = 0; i < recipeData.getNumberOfSamples(); i++)
		{
			String currentRecipeName = recipeData.getRecipeCuisine(i);
			if ((cuisineName.contentEquals(currentRecipeName)) == (recipeData.getRecipeIngredient(i, ingredientNum)))
			{
				sum++;
			}
		}
		return sum;
	}
	
	/**
	 * @param ingredientNumber
	 * @return mutual information across all cuisines for the ingredient 
	 */
	public int totalMutualInformation(int ingredientNumber)
	{
		int numberOfCuisines = recipeData.getNumberOfCuisines();
		int sum = 0;
		for (int i = 0; i < numberOfCuisines; i++)
		{
			sum += mutualInformation(i, ingredientNumber);
		}
		return sum;
	}
	
	/**
	 * Bubble sort (yuck)
	 * @param array - the array to be sorted
	 */
	public void sort(MutualInformation[] array)
	{
		for (int i = 0; i < array.length-1; i++)
		{
			for (int j = 0; j < array.length-1; j++)
			{
				if (array[j].getTotalMutualInformation() > array[j + 1].getTotalMutualInformation())
				{
					MutualInformation tmp = array[i];
					array[i] = array[i+1];
					array[i + 1] = tmp;
				}
			}
		}
	}
	
	
	/**
	 * @param numberOfFeatures
	 * @return the top x features 
	 */
	public int[] topXFeatures(int numberOfFeatures)
	{
		// Create array of mutual information pairs
		MutualInformation[] mi = buildTotalMutualInformationPairs();
		
		// Sort the array 
		sort(mi);
		
		// Create an array of size for the top X features 
		int[] topFeatures = new int[numberOfFeatures];
		
		// Fill in the topFeatures array with the top X ingredient numbers
		for (int i = 0; i < topFeatures.length; i++)
		{
			topFeatures[i] = mi[i].getIngredientNumber();
		}
		
		return topFeatures;
	}
	
	/**
	 * @return an array of the (ingredient, mutualInformation) pairs
	 */
	public MutualInformation[] buildTotalMutualInformationPairs()
	{
		MutualInformation[] mutualInfoPairs = new MutualInformation[recipeData.getNumberOfIngredients()];
		for (int i = 0; i < recipeData.getNumberOfIngredients(); i++)
		{
			if (i % 100 == 0) 
			{
				System.out.println("Working on ingredient " + i);
			}
			mutualInfoPairs[i] = new MutualInformation(i, totalMutualInformation(i));
		}
		
		return mutualInfoPairs;
	}

}
