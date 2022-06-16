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

	}

}
