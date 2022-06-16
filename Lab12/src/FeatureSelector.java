
public class FeatureSelector 
{
	private RecipeData recipeData;
	public FeatureSelector(RecipeData r)
	{
		recipeData = r;
	}

	public int mutualInformation(int cuisineNum, int ingredientNum) 
	{
		String cuisineName = recipeData.getRecipeCuisine(cuisineNum);
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
	
	public int totalMutualInformation(int ingredientNumber)
	{
		int numberOfSamples = recipeData.getNumberOfSamples();
		int sum = 0;
		for (int i = 0; i < numberOfSamples; i++)
		{
			sum += mutualInformation(i, ingredientNumber);
		}
		return sum;
	}

}
