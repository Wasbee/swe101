import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author janmolina
 *
 */
public class RecipeData 
{
	private String[] ingredients;
	private String[] cuisineNames;
	private boolean[][] recipeIngredients;
	private String[] recipeCuisine;
	

	/**
	 * RecipeData constructor (RIGID)
	 * @param cuisineNames
	 * @param ingredients
	 * @param recipeCuisine
	 * @param recipeIngredients
	 */
	public RecipeData(String[] cuisineNames, 
					String[] ingredients, 
					String[] recipeCuisine,
					boolean[][] recipeIngredients)
	{
		this.ingredients = ingredients;
		this.cuisineNames = cuisineNames;
		this.recipeCuisine = recipeCuisine;
		this.recipeIngredients = recipeIngredients;
	}
	
	/**
	 * RecipeData constructor
	 * @param fileTitle
	 * @throws FileNotFoundException
	 */
	public RecipeData(String fileTitle) throws FileNotFoundException
	{
		Scanner dataFile = new Scanner(new File(fileTitle));
		int numberOfSamples = getAttribute(dataFile);
		dataFile.nextLine();
		int numberOfIngredients = getAttribute(dataFile);
		
		readIngredientNames(dataFile, numberOfIngredients);
		readCuisineNames(dataFile);
		
		// Move down to the @DATA field
		dataFile.nextLine();
		dataFile.nextLine();
		recipeIngredients = new boolean[numberOfSamples][ingredients.length];
		recipeCuisine = new String[numberOfSamples];
		for (int i = 0; i < numberOfSamples; i++)
		{
			String line = dataFile.nextLine();
			String[] parts = line.split(",");
			for (int j = 0; j < ingredients.length; j++)
			{
				if (parts[j].contentEquals("0"))
				{
					recipeIngredients[i][j] = false;
				}
				else if (parts[j].contentEquals("1"))
				{
					recipeIngredients[i][j] = true;
				}
			}
			recipeCuisine[i] = parts[parts.length - 1];
		}

	}
	
	private void readIngredientNames(Scanner dataFile, int numberOfIngredients)
	{
		ingredients = new String[numberOfIngredients]; 
		dataFile.nextLine();
		dataFile.nextLine();
		for (int i = 0 ; i < numberOfIngredients; i++)
		{
			String line = dataFile.nextLine();
			String[] parts = line.split(" ");
			ingredients[i] = parts[1];
		}
	}
	
	private void readCuisineNames(Scanner dataFile)
	{
		String line = dataFile.nextLine();
		String[] parts = line.split(" ");
		line = parts[2];
		cuisineNames = line.substring(1, line.length() - 1).split("[^a-z_]");
	}
	
	private int getAttribute(Scanner dataFile) {
		String line;
		String[] parts;
		line = dataFile.nextLine();
		parts = line.split(" ");
		return Integer.parseInt(parts[3]);
	}
	
	/**
	 * @return the number of samples
	 */
	public int getNumberOfSamples()
	{
		return recipeCuisine.length;
	}
	
	/**
	 * @return the number of cuisines
	 */
	public int getNumberOfCuisines()
	{
		return cuisineNames.length;
	}
	
	/**
	 * @return the number of ingredients
	 */
	public int getNumberOfIngredients()
	{
		return ingredients.length;
	}
	
	/**
	 * @param ingredientNumber
	 * @return the ingredient name
	 */
	public String getIngredient(int ingredientNumber)
	{
		return ingredients[ingredientNumber];
	}
	
	/**
	 * @param cuisineNumber
	 * @return the cuisine name
	 */
	public String getCuisineName(int cuisineNumber)
	{
		return cuisineNames[cuisineNumber];
	}
	
	/**
	 * @param recipeNum
	 * @param ingredientNum
	 * @return true or false if the ingredient is present or not present, respectively
	 */
	public boolean getRecipeIngredient(int recipeNum, int ingredientNum)
	{
		return recipeIngredients[recipeNum][ingredientNum];
	}
	
	/**
	 * @param recipeNum
	 * @return the recipe name
	 */
	public String getRecipeCuisine(int recipeNum)
	{
		return recipeCuisine[recipeNum];
	}

}
