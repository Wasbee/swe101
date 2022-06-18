import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecipeMiner 
{

	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner keyboard = new Scanner(System.in);
		RecipeData r = null;
		
		while (r == null) 
		{
			System.out.print("Enter the name of the file: ");
			try 
			{
				String line = keyboard.nextLine();
				r = new RecipeData(line);
			} 
			catch (FileNotFoundException e)
			{
				System.out.println("That file can't be found, please try again");
			}
		}
		
		
		System.out.println("File contains " + r.getNumberOfSamples() +
			" recipes with " + r.getNumberOfIngredients() + " ingredients " +
			" across " + r.getNumberOfCuisines() + " cuisines");
		
		System.out.println("How many features should be selected? ");
		String line = keyboard.nextLine();
		int numberOfFeatures = Integer.parseInt(line);
		
		FeatureSelector fs = new FeatureSelector(r);
		int[] features = fs.topXFeatures(numberOfFeatures);
		
		System.out.println("The top " + numberOfFeatures + " features are ");
		for (int i = 0; i < numberOfFeatures; i++)
		{
			System.out.printf("  #%d %s\n",
					i + 1,
					r.getIngredient(features[i])
					);
		}
		
		
		keyboard.close();
		

	}

}
