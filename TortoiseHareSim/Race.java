public class Race
{
	private int TortoisePosition;
	private int HarePosition;
	public Race()
	{
		TortoisePosition = 1;
		HarePosition = 1;
	}
	public void SetTortoisePosition(int TP)
	{
		TortoisePosition = TP;
	}
	public void SetHarePosition(int HP)
	{
		HarePosition = HP;
	}
	public int GetTortoisePosition()
	{
		return TortoisePosition;
	}
	public int GetHarePosition()
	{
		return HarePosition;
	}
	public void TFastPlod()
	{
		TortoisePosition =  TortoisePosition + 3;
	}
	public void TSlowPlod()
	{
		TortoisePosition =  TortoisePosition + 1;
	}
	public void TSlip()
	{
		TortoisePosition =  TortoisePosition - 6;
	}
	public void HBigHop()
	{
		HarePosition = HarePosition + 9;
	}
	public void HSmallHop()
	{
		HarePosition = HarePosition + 1;
	}
	public void HBigSlip()
	{
		HarePosition = HarePosition - 12;
	}
	public void HSmallSlip()
	{
		HarePosition = HarePosition - 2;
	}
	public void HFallAsleep()
	{
		HarePosition = HarePosition;
	}
}