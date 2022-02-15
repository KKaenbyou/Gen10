public class DifferentKettleOfFish {
    public static void main(String[] args) {

        int fish = 1;
        
        for(int i = fish; i < 10; i++) {
            if(i == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(i + " fish!");
            }
        }
        
        // The while loop was refactored into a for loop, with int i taking the place of int fish
    }
}