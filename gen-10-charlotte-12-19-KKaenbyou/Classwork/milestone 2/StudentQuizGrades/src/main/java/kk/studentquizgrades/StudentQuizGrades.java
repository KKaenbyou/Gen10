// @author Kenji Kaenbyou

package kk.studentquizgrades;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentQuizGrades {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        User u = new User();
        int i;
        
        HashMap<String, ArrayList<Integer>> st = new HashMap<>();
        st.put("John One", new ArrayList<>(Arrays.asList(100, 100)));
        st.put("John Two", new ArrayList<>(Arrays.asList(75, 75)));
        st.put("John Three", new ArrayList<>(Arrays.asList(50, 50)));
        Set<String> keys = st.keySet();
        
        while(true) {
            i = u.readInt("Enter 1 to view students. Enter 2 to add a student. Enter 3 to remove a student. Enter 4 to quit program.");
            if(i < 1 || i > 4) {
                u.print("Invalid input.");
            } else if(i == 1) {
                for (String k : keys) {
                    u.print(k + " - Quiz Scores: " + st.get(k).get(0) + ", " + st.get(k).get(1) + ". Average score: " + avg(st.get(k).get(0), st.get(k).get(1)));
                }
            } else if(i == 2) {
                String name = u.readString("Enter the student's name.");
                String q1 = u.readString("Enter the student's first quiz grade.");
                String q2 = u.readString("Enter the student's second quiz grade.");
                int q1p = Integer.parseInt(q1);
                int q2p = Integer.parseInt(q2);
                st.put(name, new ArrayList<>(Arrays.asList(q1p, q2p)));
                u.print("New student added.");
            } else if(i == 3) {
                String name = u.readString("Enter the student's name, case sensitive.");
                st.remove(name);
                u.print(name + " has been removed.");
            } else if(i == 4) {
                System.exit(0);
            }
        }
    }
    
    public static double avg(int x, int y) {
        double xd = x;
        double yd = y;
        double zd = (x + y) / 2;
        return zd;
    }
}