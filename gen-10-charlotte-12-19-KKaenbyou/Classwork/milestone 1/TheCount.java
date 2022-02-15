import java.util.Scanner;

public class TheCount {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int ha = 0;
        int start, stop, count;
        String st;
        
        System.out.println("I love to count! Let me share my counting with you!");
        System.out.print("Start at: ");
        st = s.nextLine();
        start = Integer.parseInt(st);
        System.out.print("Stop at: ");
        st = s.nextLine();
        stop = Integer.parseInt(st);
        System.out.print("Count by: ");
        st = s.nextLine();
        count = Integer.parseInt(st);
        
        for(int i = start; i < stop; i = i + count ) {
            System.out.print(i + " ");
            ha++;
            if(ha == 3) {
                System.out.println("- Ah ah ah!");
                ha = 0;
            }
        }
    }
}
