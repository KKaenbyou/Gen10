import java.util.Scanner;

public class BirthStones {
    public static void main(String[] args) {
     
        Scanner s = new Scanner(System.in);
        String month;
        
        System.out.print("What month's birthstone are you wanting to know? ");
        month = s.nextLine();
        int m = Integer.parseInt(month);
        
        switch(m) {
            case 1:
                System.out.print("January's birthstone is Garnet.");
                break;
            case 2:
                System.out.print("February's birthstone is Amethyst.");
                break;    
            case 3:
                System.out.print("March's birthstone is Aquamarine.");
                break;
            case 4:
                System.out.print("April's birthstone is Diamond.");
                break;    
            case 5:
                System.out.print("May's birthstone is Emerald.");
                break;    
            case 6:
                System.out.print("June's birthstone is Pearl.");
                break;    
            case 7:
                System.out.print("July's birthstone is Ruby.");
                break;
            case 8:
                System.out.print("August's birthstone is Peridot.");
                break;
            case 9:
                System.out.print("September's birthstone is Sapphire.");
                break;
            case 10:
                System.out.print("October's birthstone is Opal.");
                break;
            case 11:
                System.out.print("November's birthstone is Topaz.");
                break;
            case 12:
                System.out.print("December's birthstone is Turquoise.");
                break;
            default:
                System.out.print("I think you must be confused, " + m + " doesn't match a month.");
                break;
        }
    }
}
