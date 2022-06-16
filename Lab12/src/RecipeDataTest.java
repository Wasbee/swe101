import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class RecipeDataTest 
{

	@Test
	public void testInitialParams() throws FileNotFoundException
	{
		 RecipeData r = new RecipeData("short.arff");
		 assertEquals(4, r.getNumberOfSamples());
		 assertEquals(8, r.getNumberOfCuisines());
		 assertEquals(14, r.getNumberOfIngredients());
		 
		 r = new RecipeData("short2.arff");
		 assertEquals(6, r.getNumberOfSamples());
		 assertEquals(7, r.getNumberOfCuisines());
		 assertEquals(12, r.getNumberOfIngredients());
		 
	}
	
	@Test
	public void testIngredients() throws FileNotFoundException
	{
		RecipeData r = new RecipeData("short.arff");
		assertEquals("lettuce", r.getIngredient(0));
		assertEquals("beans", r.getIngredient(7));
		assertEquals("eggs", r.getIngredient(r.getNumberOfIngredients() - 1));
	}
	
	@Test
	public void testCuisineNames() throws FileNotFoundException
	{
		RecipeData r = new RecipeData("short.arff");
		assertEquals("greek", r.getCuisineName(0));
		assertEquals("french", r.getCuisineName(4));
		assertEquals("korean", r.getCuisineName(r.getNumberOfCuisines() - 1));
	}
	
	@Test
	public void testFirstRecipe() throws FileNotFoundException
	{
		RecipeData r = new RecipeData("short.arff");
		assertTrue(r.getRecipeIngredient(0,0));
		assertFalse(r.getRecipeIngredient(0,7));
		assertTrue(r.getRecipeIngredient(0,13));
		assertEquals("southern_us", r.getRecipeCuisine(0));
	}

	@Test
	public void testLastRecipe() throws FileNotFoundException
	{
		RecipeData r = new RecipeData("short.arff");
		assertTrue(r.getRecipeIngredient(3,0));
		assertTrue(r.getRecipeIngredient(3,6));
		assertFalse(r.getRecipeIngredient(3,13));
		assertEquals("korean", r.getRecipeCuisine(3));
	}
	
	@Test
	public void testRiggedConstructor()
	{
		String[] ingredients = {"salt", "pepper", "thyme", "eggs"};
		String[] cuisines = {"good food", "italian", "korean",
				"icky food", "homecooking"};
		String[] recipeCuisine = {"good food", 
				"korean", "korean","italian", "homecooking"};
		boolean[][]recipeIngredients = 
			{{true, false, true, false},
			 {false, true, false, false},
			 {true, true, true, true},
			 {false, false, false, false},
			 {true, false, false, true}};
		
		RecipeData r = new RecipeData(cuisines, ingredients, 
				recipeCuisine, recipeIngredients);
		
		// Verify the big numbers
		assertEquals(5, r.getNumberOfSamples());
		assertEquals(5, r.getNumberOfCuisines());
		assertEquals(4, r.getNumberOfIngredients());
		
		// spot check some recipe data
		assertFalse(r.getRecipeIngredient(3,0));
		assertEquals("italian", r.getRecipeCuisine(3));
		
		
	}

}
