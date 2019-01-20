public class TestThreads2
{
  public static void main( String [] args )
  {
    Resource myResource = new Resource( 21 );
    Thread t1 = new Findit2(myResource, 0, 349);
    Thread t2 = new Findit2(myResource, 350, 699);
    Thread t3 = new Findit2(myResource, 700, 1000);
    t1.start();
    t2.start();
    t3.start();
  }
}