import static org.junit.Assert.*;

import org.junit.Test;

public class TestFeatureSelector 
{
	private static String[] ingredients = {"salt", "pepper", "thyme", "eggs"};
	private static String[] cuisines = {"good food", 
			"italian", "korean",  "icky food", "homecooking"};
	private static String[] recipeCuisine = {"good food", 
			"korean", "korean", "italian", "homecooking"};
	private static boolean[][]recipeIngredients = 
		{{true, false, true, true},
		 {false, true, true, true},
		 {true, true, true, true},
		 {false, false, false, false},
		 {true, false, true, true}};
	
	@Test
	public void testMutualInformation()
	{
		RecipeData r = new RecipeData(cuisines, ingredients,
				recipeCuisine, recipeIngredients);
		FeatureSelector fs = new FeatureSelector(r);
		assertEquals(5, fs.mutualInformation(2,1));
		assertEquals(2, fs.mutualInformation(2,0));
		assertEquals(2, fs.mutualInformation(4,3));
	}
	
	@Test
	public void testTotalMutualInformation()
	{
		RecipeData r = new RecipeData(cuisines, ingredients,
				recipeCuisine, recipeIngredients);
		FeatureSelector fs = new FeatureSelector(r);
		assertEquals(3+1+2+2+3, fs.totalMutualInformation(0));
		assertEquals(2+2+5+3+2, fs.totalMutualInformation(1));
	}


}
