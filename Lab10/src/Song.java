
public class Song 
{
	private String title;
	private int duration;
	
	public Song(String t, int d)
	{
		title = t;
		duration = d;
	}
	
	/**
	 * getTitle
	 * @return the title of the song
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * getDuration
	 * @return the duration of the song
	 */
	public int getDuration()
	{
		return duration;
	}
	
	/**
	 * Convert to string
	 */
	public String toString()
	{
		return title + String.format(": %d:%02d", duration/60, duration % 60);
	}

}
