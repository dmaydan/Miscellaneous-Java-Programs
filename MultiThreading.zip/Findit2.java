public class Findit2 extends Thread
{
  private Resource targetResource;
  private int startNumber;
  private int stopNumber;
  private int i = startNumber;
  private int t = 0;
  
  //constructor
  public Findit2( Resource r, int start, int stop )
  {
    targetResource = r;
    startNumber = start;
    stopNumber = stop;
    i = startNumber;
  }
//runner
  public void run()
  {
    while(i < stopNumber)
    {
      synchronized (targetResource)     // puts a lock on the shared resource so threads are blocked until the method is completed
      {
	//ten times only
      while (t < 10)
      {
      System.out.println( "i = \t" + i + "\t" + this.getName() + " is running" );
      
      if( i == targetResource.getTarget() )
      {
        System.out.println( this.getName() + " found the target "+i );
        System.exit(0);
      }
      i++;
      t++;
      }
      t=0;
      }//unlocks
      try
      {
      Thread.sleep(1);
      }
      catch(InterruptedException e)
      {
      }
    } 
  }
}
