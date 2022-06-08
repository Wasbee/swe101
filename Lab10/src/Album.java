
public class Album 
{
	private Song[] songs;
	private int numberOfSongs;
	private String title;
	
	/**
	 * Constructor
	 * @param title
	 * @param size
	 */
	public Album(String title, int size)
	{
		this.title = title;
		this.numberOfSongs = 0;
		this.songs = new Song[size];
	}
	
	/**
	 * addSong
	 * @param s
	 */
	public void addSong(Song s)
	{
		if (numberOfSongs == songs.length) 
		{
			return;
		}
		songs[numberOfSongs] = s;
		numberOfSongs++;
	}
	
	/**
	 * 
	 * @return duration of the entire album
	 */
	public int getDuration()
	{
		int totalDuration = 0;
		
		if (numberOfSongs == 0) 
		{
			return 0;
		}
		for (int i = 0; i < numberOfSongs; i++)
		{
			totalDuration += songs[i].getDuration();
		}
		return totalDuration;
	}
	
	/**
	 * getNumberOfSongs
	 * @return number of songs in the album
	 */
	public int getNumberOfSongs()
	{
		return numberOfSongs;
	}
	
	/**
	 * getSize
	 * @return maximum number of songs the album can hold
	 */
	public int getSize()
	{
		return songs.length;
	}
	
	/**
	 * getTitle
	 * @return the title of the album
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * getSong
	 * @param i
	 * @return the ith song
	 */
	public Song getSong(int i)
	{
		return songs[i];
	}
	/**
	 * toString 
	 */
	public String toString()
	{
		String str = new String();
		str = title + ":";
		for (int i = 0; i < numberOfSongs; i++)
		{
			str += "\n\t" + songs[i].toString();
		}
		return str;
	}

}
