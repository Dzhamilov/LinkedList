public class LinkedListt {
    private Node root;
    private int size;

    public void add(int value){
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null) currentNode = currentNode.next;
        currentNode.next = new Node(value);
        size++;
    }

    public boolean remove(int value){
        if (root == null) return false;
        if (root.value == value) {
            root = root.next;
            size--;
            return true;
        }
        Node curentNode = root;
        while (curentNode.next != null) {
            if (curentNode.next.value == value) {
                curentNode.next = curentNode.next.next;
                size--;
                return true;
            }
            curentNode = curentNode.next;
        }
        return false;
    }

    private Node getNode(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node currentNode = root;
        for (int i = 0; i < index; i++) currentNode = currentNode.next;

        return currentNode;
    }


    public int getValue(int index) {return this.getNode(index).value;}

    public void print() {
        Node currentNode = root;
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("]  size: " + size);
    }

    private class Node {
        int value;
        Node next;

        Node() {};

        Node(int value) {this.value = value;}
    }
}
