// @author Rin

public class SummartiveSums {
    public static void main(String[] args) {
        
        int[] a1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] a2 = { 999, -60, -77, 14, 160, 301 };
        int[] a3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
            140, 150, 160, 170, 180, 190, 200, -99 };
        
        int a1s = aSum(a1);
        int a2s = aSum(a2);
        int a3s = aSum(a3);
        
        System.out.println("#1 Array Sum: " + a1s);
        System.out.println("#1 Array Sum: " + a2s);
        System.out.println("#1 Array Sum: " + a3s);
    }
    
    public static int aSum(int[] a) {
        int sum = 0;
        
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        
        return sum;
    }
}
