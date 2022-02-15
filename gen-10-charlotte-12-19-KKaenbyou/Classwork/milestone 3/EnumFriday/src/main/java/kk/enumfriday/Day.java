// @author Kenji Kaenbyou

package kk.enumfriday;
import java.util.Scanner;

public class Day {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int u;
        
        System.out.println("Enter 1 if it's Saturday, 2 if it's Sunday, 3 if it's Monday, 4 if it's Tuesday,"
                + " 5 if its Wednesday, 6 if it's Thursday, or 7 if it's Friday.");
        u = s.nextInt();
        
        switch(u) {
                case 1:
                      weekday(DayOp.SATURDAY);
                      break;
                case 2:
                      weekday(DayOp.SUNDAY);
                      break;
                case 3:
                      weekday(DayOp.MONDAY);
                      break;
                case 4:
                      weekday(DayOp.TUESDAY);
                      break;
                case 5:
                      weekday(DayOp.WEDNESDAY);
                      break;
                case 6:
                      weekday(DayOp.THURSDAY);
                      break;
                case 7:
                      weekday(DayOp.FRIDAY);
                      break;
                default:
                      throw new UnsupportedOperationException();
        }
    }
    
    public enum DayOp {
        SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }
    
    public static void weekday(DayOp day) {
        switch(day) {
                case SATURDAY:
                      System.out.println("There are 6 days until Friday.");
                      break;
                case SUNDAY:
                      System.out.println("There are 5 days until Friday.");
                      break;
                case MONDAY:
                      System.out.println("There are 4 days until Friday.");
                      break;
                case TUESDAY:
                      System.out.println("There are 3 days until Friday.");
                      break;
                case WEDNESDAY:
                      System.out.println("There are 2 days until Friday.");
                      break;
                case THURSDAY:
                      System.out.println("Tomorrow is Friday.");
                      break;
                case FRIDAY:
                      System.out.println("Today is Friday.");
                      break;
                default:
                      throw new UnsupportedOperationException();
        }
   }
}