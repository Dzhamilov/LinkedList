public class Main {
    public static void main(String[] args) {
        LinkedListt list = new LinkedListt();
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(4);
        list.addAt(1, 0);
        list.addAt(0,1);
        list.print();
        list.quickSort();
        list.print();

        
    }
    
}