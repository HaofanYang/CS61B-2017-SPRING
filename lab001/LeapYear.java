/** Class that determines whether or not a year is a leap year.
 *  @author YOUR NAME HERE
 */
public class LeapYear {

    /** Calls isLeapYear to print correct statement.
     *  @param  year to be analyzed
     */
    public static boolean isLeapYear(int year) {
        int remainer = year % 4;
        System.out.println();
        if (remainer == 0){
            System.out.println(year + " is a leap year.");
        } else{
            System.out.println(year + " is not a leap year.");
        }
        return (remainer == 0);
    }

    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {
            isLeapYear(args);
    }
}

