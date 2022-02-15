// @author Kenji Kaenbyou

package kk.statecapitals;
import java.util.HashMap;
import java.util.Set;

public class StateCapitals {
    public static void main(String[] args) {
        
        HashMap<String, String> st = new HashMap<>();
        
        st.put("Alabama", "Montgomery");
        st.put("Alaska", "Juneau");
        st.put("Arizona", "Phoenix");
        st.put("Arkansas", "Little Rock");
        
        Set<String> keys = st.keySet();
        
        System.out.println("States: \n ====");
        for (String k : keys) {
            System.out.println(k);
        }
        System.out.println("Capitals: \n ====");
        for (String k : keys) {
            System.out.println(st.get(k));
        }
        System.out.println("State/Capital Pairs: \n ================");
        for (String k : keys) {
            System.out.println(k + " - " + st.get(k));
        }
    }
}
