package debug;

import java.util.Arrays;
// import debug.Library;

public class Main{
  public static String msg = "BLA BLA BLA BLA";
  public static void main(String []args){
    System.out.println("This is how a full debug mode shows the message!");
    args = new String[]{"true", "true"};
    Library.makeStart(args);
    test();
    System.out.println("\n--------- Just to separet the messages ---------\n");
    System.out.println("This is how a debug mode shows the message!");
    args = new String[]{"true", "false"};
    Library.makeStart(args);
    testDebug();
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