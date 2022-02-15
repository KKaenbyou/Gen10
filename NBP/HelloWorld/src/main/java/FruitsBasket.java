public class FruitsBasket {
    public static void main(String[] args) {
        
        String[] f = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        System.out.println("Total Number of Fruit in Basket: " + f.length);
        int apples = 0, oranges = 0;
        
        for(int i = 0; i < f.length; i++) {
            if(f[i].equals("Apple")) {
                apples++;
            } else if(f[i].equals("Orange")) {
                oranges++;
            }
        }
        
        String[] a = new String[apples];
        String[] o = new String[oranges];
        
        for(int i = 0; i < apples; i++) {
            a[i] = "Apple";
        }
        for(int i = 0; i < oranges; i++) {
            o[i] = "Orange";
        }
        
        System.out.println("Number of Apples: " + a.length);
        System.out.println("Number of Oranges: " + o.length);
    }
}