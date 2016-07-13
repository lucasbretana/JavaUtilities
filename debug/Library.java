package debug;

import java.io.PrintStream;
import java.util.Arrays;

public abstract class Library{
  /** * Is the more debug option, the default is false */
  private static boolean debug = false;
  /** * Is the debug option, the default is false */
  private static boolean more = false;
  /** * Is the stream for output, the default is System.err */
  private static PrintStream out = System.err;

  /**
   * Check if is in debug mode
   * @return the state of the program, debugging or not
   **/
  public static boolean isDebug(){return Library.debug;};

  /**
  * Check if is in more debug mode
  * @return the state of the program about the more debug, print more debugging or not
  **/
  public static boolean isMoreDebug(){return Library.debug && Library.more;};

  /**
   * Sets the indDeb as 0. The more debug as false, and leave the PrintStream as the default.
   * @param args is the parameters for debug.
   */
  public static void makeStart(String[] args){
    Library.makeStart(args, 0, 1, null);
  }

  /**
   * Sets the more debug as false, and leave the PrintStream as the default.
   * @param args is the parameters for debug.
   * @param indDeb is the index for the debug option.
   */
  public static void makeStart(String[] args, Integer indDeb){
    Library.makeStart(args, indDeb, null, null);
  }

  /**
   * Leave the PrintStream as the default.
   * @param args is the parameters for debug.
   * @param indDeb is the index for the debug option.
   * @param more is the index for the more debug option.
   */
  public static void makeStart(String[] args, Integer indDeb, Integer more){
    Library.makeStart(args, indDeb, more, null);
  }

  /**
   * Sets the more debug as false.
   * @param args is the parameters for debug.
   * @param indDeb is the index for the debug option.
   * @param p is the stream for output.
   */
  public static void makeStart(String[] args, Integer indDeb, PrintStream p){
    Library.makeStart(args, indDeb, null, p);
  }

  /**
   * @param args is the parameters for debug.
   * @param indDeb is the index for the debug option.
   * @param indMore is the index for the more debug option.
   * @param p is the stream for output.
   */
  public static void makeStart(String[] args, Integer indDeb, Integer indMore, PrintStream p){
    // Sets the debug option. If the value is 1 ou 'true', the Library.debug is set to true
    if( (args.length >= (indDeb + 1)) && (args[indDeb] != null) && (!args[indDeb].equalsIgnoreCase(" ")) ){
      try {
        Library.debug = Integer.parseInt(args[indDeb]) == 1;
      } catch (NumberFormatException ex) {
    	  Library.debug = Boolean.parseBoolean(args[indDeb]);
	      // Library.echo("debug.Library", "makeStart", ex.getMessage());
        if(!Library.debug) return;
      }
    } else {
      Library.debug = false;
      return;
    }
    // Sets the more debug option. If the value is 1 ou 'true', the Library.more is set to true
    if( (args.length >= (indMore + 1)) && (args[indMore] != null) && (!args[indMore].equalsIgnoreCase(" ")) ){
      try {
        Library.more = Integer.parseInt(args[indMore]) == 1;
      } catch (NumberFormatException ex) {
    	  Library.more = Boolean.parseBoolean(args[indMore]);
	      // Library.echo("debug.Library", "makeStart", ex.getMessage());
      }
    } else {
      Library.more = false;
    }

    // if(indMore != null){
    //   try{
    //     Library.more = Boolean.parseBoolean(args[indMore]) && Library.debug;
    //   }catch(IndexOutOfBoundsException ex){
    //     Library.more = false;
    //   }
    // }
    // Sets the PrintStream
    if( p != null) Library.out = p;
  }

  /**
   * Prints the message if is in debug mode, also if is in more debug, print extra traces.
   * @param  theClass the current class
   * @param  theMethod the current method
   * @param  msg is the message to be displayed
   */
  @Deprecated
  private static void echo(String theClass, String theMethod, String msg){
    if(!Library.more)
      if (Library.debug) Library.out.println("In: " + theClass + "." + theMethod + "\n\t->DEBUG: " + msg + "\n");
  }

  /**
   * Prints the message if is in debug mode, also if is in more debug, print extra traces.
   * If it is called from a static context then the clas will be 'java.lang.StackTraceElement'
   * @param msg is the message to be displayed
   */
  public static void echo(String msg){
    if(!Library.isMoreDebug()){
      if(Library.debug)
        Library.out.println("In: " + Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n\t->DEBUG: " + msg + "\n");
    }else{
      Library.out.print("\n\t->DEBUG: " + msg + "\n");
      Arrays.stream(Thread.currentThread().getStackTrace(), 2, Thread.currentThread().getStackTrace().length).filter(
        (w) -> w != null).forEach(
        (x) -> Library.out.print(x.getClassName() + "." + x.getMethodName()  + "\n"));
    }

    // echo(Thread.currentThread().getStackTrace()[2].getClassName(), Thread.currentThread().getStackTrace()[2].getMethodName(), msg);
  }

}
