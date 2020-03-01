package datastructures.hashmap;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName LinkedList.java
 * @Description TODO
 * @createTime 2020-03-01 19:03
 */
class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void insert(int data) {
        Node temp = head;
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void delete(int data) {
        if (size == 0) {
            System.out.println("UnderFlow!");
            return;
        } else {
            Node curr = head;
            if (curr.data == data) {
                head = curr.next;
                size--;
                return;
            } else {
                while (curr.next.next != null) {
                    if (curr.next.data == data) {
                        curr.next = curr.next.next;
                        return;
                    }
                }
                System.out.println("Key not Found");
            }
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}
