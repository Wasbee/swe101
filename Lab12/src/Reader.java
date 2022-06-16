import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("short.arff");
		Scanner s = new Scanner(file);
		System.out.println("File found!");
		
		
		String currentLine = s.nextLine();
		
		// Print the individual substrings using the split() function
		String[] parts = currentLine.split(" ");
		for (int i =0; i < parts.length; i++)
		{
			System.out.println(" " + parts[i]);
		}
		

				
	}

}
