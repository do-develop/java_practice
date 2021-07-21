package ws05;

public class TestException
{

	public static void main(String[] argv)
	{
		lostException();
		//chainedException();
	}

public static void lostException()
{
    try
    {
      System.out.println("lostException: try block");
      doDivision(10, 0);
      // Call other methods ...
      System.out.println("lostException: end try block");
    }
    catch(RuntimeException err)
    {
      System.out.println("lostException: catch block");
      err.printStackTrace(System.out);
    }

}

public static void doDivision(int num1, int num2)
{
    try
    {
      System.out.println(num1 / num2);
      System.out.println("doDivision: end try block");
    }
    catch(ArithmeticException err)
    {
    	//err.printStackTrace(System.out);
    	//instead of calling above, below is calling wrong exception, thus original ArithmeticException is lost
    	throw new RuntimeException("Incorrect values ...");
    }
}

public static void chainedException()
{
    try
    {
      System.out.println("chainedException: try block");
      doString();
      // Call other methods ...
      System.out.println("chainedException: end try block");
    }
    catch(RuntimeException err)
    {
      System.out.println("chainedException: catch block");
      err.printStackTrace(System.out);       
    }
}

public static void doString()
{
    try
    {
      System.out.println("doString: try block");
      System.out.println("Hello".charAt(10));
      System.out.println("doString: end try block");
    }
    catch(StringIndexOutOfBoundsException err)
    {
      // err.printStackTrace(System.out);
      throw new RuntimeException("Incorrect String index", err);
    }
}
  
  
}