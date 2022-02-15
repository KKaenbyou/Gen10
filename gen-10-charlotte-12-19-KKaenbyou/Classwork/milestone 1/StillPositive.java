public class StillPositive {
    public static void main(String[] args) {
        
        int[] n = { 389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311};
        
        for(int i = 0; i < n.length; i++) {
            if(n[i] > 0) {
                System.out.println(n[i]);
            }
        }
    }
}
