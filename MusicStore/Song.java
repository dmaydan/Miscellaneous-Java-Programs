public class Song
{
	private String Title;
	private String Artist;
	private double Price;
	public Song(String title, String artist, double price)
	{
		Title = title;
		Artist = artist;
		Price = price;
	}
	public String GetTitle()
	{
		return Title;
	}
	public String GetArtist()
	{
		return Artist;
	}
	public double GetPrice()
	{
		return Price;
	}
}
