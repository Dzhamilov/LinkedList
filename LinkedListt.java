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

    public void removeAt(int index) {
        if (index == 0) {
            root.next = root.next.next;
            size--;
            return;
        }
        Node prevNode = this.getNode(index - 1);
        prevNode.next = prevNode.next.next;
        size--;
    }

    public int removeAll(int value) {
        int oldSize = size;
        if (root == null) return 0;
        while (root != null && root.value == value) {
            root = root.next;
            size--;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                size--;
            } else currentNode = currentNode.next;
        }
        return oldSize - size;
    }


    private Node getNode(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node currentNode = root;
        for (int i = 0; i < index; i++) currentNode = currentNode.next;

        return currentNode;
    }

    public void swap(int index1, int index2) {
        if (index1 == index2) return;
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) return;
        Node currentNode = root;
        Node node1 = null;
        Node node2 = null;
        for (int i = 0; currentNode != null; i++) {
            if (i == index1) node1 = currentNode;
            else if (i == index2) node2 = currentNode;
            if (node2 != null && node1 != null) break;
            currentNode = currentNode.next;
        }
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
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
