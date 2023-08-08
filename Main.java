import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedListt list = new LinkedListt();
        
        for (int i = 0; i < 6; i++) {
            list.addSorted(new Random().nextInt(10 ));
        }
        list.print();

        
    }
    
}