package debug;

import java.util.Arrays;
// import debug.Library;

public class Main{
  public static String msg = "BLA BLA BLA BLA";
  public static void main(String []args){
    System.out.println("------------------------------------------------------------------------------");
    System.out.println("----------------------- This is only a default message -----------------------");
    System.out.println("----------------------------- See documentation ------------------------------");
    System.out.println("------------------------------------------------------------------------------");
    System.out.println("");
    
    args = new String[]{"true", "true"};
    Library.makeStart(args);
    System.out.println("----------------------------------------------------");
    System.out.println("- This is how a full debug mode shows the message! -");
    System.out.println("----------------------------------------------------");
    test();
    Library.more = false;
    System.out.println();
    System.out.println("----------------------------------------------------");
    System.out.println("- This is how a full debug mode shows the message! -");
    System.out.println("----------------------------------------------------");
    testDebug();

    System.out.println("");
    System.out.println("------------------------------------------------------------------------------");
    System.out.println("----------------------------- See documentation ------------------------------");
    System.out.println("----------------------- This is only a default message -----------------------");
    System.out.println("------------------------------------------------------------------------------");
  }

  private static void test(){
    testMoreDebug();
  }

  public static void testDebug(){
    Library.echo("This is a default debug message!");
  }
  public static void testMoreDebug(){
    Library.echo("This is a default debug message!");
  }
}
