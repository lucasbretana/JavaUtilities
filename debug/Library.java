package debug;

public abstract class Library{
  private static boolean debug = false;
  private static boolean more = true;
  /**
   * @return the state of the program, debugging or not
   * */
  public static boolean isDebug(){return Library.debug;};
  /**
   * @param args is a String vector with all the initialize parameters, look in the first parameter for a debug option
   * @see if the parameter is not a correct string, neither an integer, it is used a false value to the debug option
   * */
  public static void makeStart(String[] args){
    Library.makeStart(args, 0);
  }
  /**
   * @param args is a String vector with all the initialize parameters
   * @param indDeb is used as a index for where to look the debugging option
   * @see if the parameter is not a correct string, neither an integer, it is used a false value to the debug option.
   * @see the indDeb+1 will be used as a moreDebug option
   * */
  public static void makeStart(String[] args, int indDeb){
    if( (args.length == (indDeb+2)) && (args[indDeb] != null) && (!args[indDeb].equalsIgnoreCase(" ")) ){
      try {
        Library.debug = Integer.parseInt(args[indDeb]) == 1;
      } catch (NumberFormatException ex) {
    	Library.debug = Boolean.parseBoolean(args[indDeb]);
	    Library.echo("debug.Library", "makeStart", ex.getMessage());
      }
    } else {
      Library.debug = false;
    }
    try{
      Library.more = Boolean.parseBoolean(args[indDeb + 1]);
    }catch(IndexOutOfBoundsException ex){
      Library.more = true;
      return;
    }
  }

  // uses the debug option to determinate if will or not show the debug
  /**
   * @param msg is the message that will be displayed if is in debug mode
   * @param theClass is used in debug message
   * @param theMethod is used in debug message
   * @see show the message in a debug format, only if is in debug mode. Format: In: theClas.theMethod ->DEBUG: msg
   */
  public static void echo(String theClass, String theMethod, String msg){
    if (Library.debug) System.err.println("In: " + theClass + "." + theMethod + "\n\t->DEBUG: " + msg + "\n");
  }
  /**
   * @param msg is the message that will be displayed if is in debug mode
   * @param theClass is used in debug message
   * @param theMethod is used in debug message
   * @param moreDebug is used to display more debug information
   * @see show the message in a debug format, only if is in debug mode. Format: In: theClas.theMethod ->DEBUG: msg
   */
  public static void echo(String theClass, String theMethod, String msg, Boolean moreDebug){
    if (Library.debug && (moreDebug && Library.more))
      Library.echo(theClass, theMethod, msg);
  }

}
