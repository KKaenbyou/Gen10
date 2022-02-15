// @author Kenji Kaenbyou

package kk.statecapitals;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StateCapitals2 {
    public static void main(String[] args) {
        
        HashMap<String, ArrayList<String>> st = new HashMap<>();
        st.put("Alabama", new ArrayList<>(Arrays.asList("Montgomery", "205000", "156")));
        st.put("Alaska", new ArrayList<>(Arrays.asList("Juneau", "31000", "3255")));
        st.put("Arizona", new ArrayList<>(Arrays.asList("Phoenix", "1445000", "517")));
        st.put("Arkansas", new ArrayList<>(Arrays.asList("Little Rock", "193000", "116")));
        Set<String> keys = st.keySet();
        
        System.out.println("State/Capital Pairs: \n ================");
        for (String k : keys) {
            System.out.println(k + " - " + st.get(k).get(0) + " | Population: " + st.get(k).get(1) + " | Area: " + st.get(k).get(2) + " Square Miles");
        }
        
        int p;
        Scanner s = new Scanner(System.in);
        System.out.print("\nPlease enter the minimum capital city population: ");
        p = Integer.parseInt(s.nextLine());
        System.out.println("Listing capitals with populations greater than " + p + "\n");
        
        for (String k : keys) {
            if(Integer.parseInt(st.get(k).get(1)) > p) {
                System.out.println(k + " - " + st.get(k).get(0) + " | Population: " + st.get(k).get(1) + " | Area: " + st.get(k).get(2) + " Square Miles");
            }
        }
    }
}