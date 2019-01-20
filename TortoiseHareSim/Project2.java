import java.util.Random;
public class Project2
{
	public static void main( String [] args )
	{
		//race object
		Race TortoiseHare = new Race();
		//random variable
		Random SimulationGenerator = new Random();
		System.out.println("And they're off");
		//action loop
		while (TortoiseHare.GetTortoisePosition() < 50 && TortoiseHare.GetHarePosition() < 50)
		{
			int Simulation = SimulationGenerator.nextInt((9)) + 1;
			if ( 5 >= Simulation && Simulation >= 1)
			{
			 TortoiseHare.TFastPlod();
			}
			else if (8 >= Simulation && Simulation >= 6)
			{
				TortoiseHare.TSlowPlod();
			}
			else if (10 >= Simulation && Simulation >= 9)
			{
				TortoiseHare.TSlip();
			}
			
			if (TortoiseHare.GetTortoisePosition() < 1)
			{
				TortoiseHare.SetTortoisePosition(1);
			}
			else if ( 2 >= Simulation && Simulation >= 1)
			{
			 	TortoiseHare.HBigHop();
			}
			else if ( 5 >= Simulation && Simulation >= 3)
			{
			 TortoiseHare.HSmallHop();
			}
			else if ( Simulation == 6)
			{
			 TortoiseHare.HBigSlip();
			}
			else if ( 8 >= Simulation && Simulation >= 7)
			{
			 TortoiseHare.HSmallSlip();
			}
			else if ( 10 >= Simulation && Simulation >= 9)
			{
			 TortoiseHare.HFallAsleep();
			}
			if (TortoiseHare.GetHarePosition() < 1)
			{
				TortoiseHare.SetHarePosition(1);
			}
			DisplayRace(TortoiseHare.GetTortoisePosition(), TortoiseHare.GetHarePosition());
			System.out.println();	
		}
		if (TortoiseHare.GetTortoisePosition() == 50)
		{
			System.out.println("Tortoise Wins");
		}
		if (TortoiseHare.GetHarePosition() == 50)
		{
			System.out.println("Hare Wins");
		}
		if (TortoiseHare.GetTortoisePosition() == 50 && TortoiseHare.GetHarePosition() == 50)
		{
			System.out.println("Its A Tie");
		}
	}
	//display function
	public static void DisplayRace(int TortoisePosition, int HarePosition)
	{
		//display posiblities
		int RacePosition = 1;
		if (TortoisePosition < HarePosition)
		{
			while (RacePosition < TortoisePosition)
			{
				System.out.print("_ ");
				RacePosition = RacePosition + 1;
			}
			RacePosition = RacePosition + 1;
			System.out.print("T ");
			while (RacePosition < HarePosition)
			{
				System.out.print("_ ");
				RacePosition = RacePosition + 1;
			}
			RacePosition = RacePosition + 1;
			System.out.print("H ");
			while (RacePosition <= 50)
			{
				System.out.print("_ ");
				RacePosition = RacePosition + 1;
			}
			
		}
		if (HarePosition < TortoisePosition)
		{

			while (RacePosition < HarePosition)
			{
				System.out.print("_ ");
				RacePosition = RacePosition + 1;
			}
			RacePosition = RacePosition + 1;
			System.out.print("H ");
			while (RacePosition < TortoisePosition)
			{
				System.out.print("_ ");
				RacePosition = RacePosition + 1;
			}
			RacePosition = RacePosition + 1;
			System.out.print("T ");
			while (RacePosition <= 50)
			{
				System.out.print("_ ");
				RacePosition = RacePosition + 1;
			}
			
		}
		if (TortoisePosition == HarePosition)
		{
			while (RacePosition < TortoisePosition)
			{
				System.out.print("_ ");
				RacePosition = RacePosition + 1;
			}
			System.out.print("Ouch");
			RacePosition = RacePosition + 1;
			while (RacePosition <= 50)
			{
				System.out.print("_ ");
				RacePosition = RacePosition + 1;
			}
				
		}
	}
		
}