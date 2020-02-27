package datastructures.lists;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName SinglyLinkedList.java
 * @Description TODO
 * @createTime 2020-02-27 22:17
 */
public class SinglyLinkedList {
    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    public SinglyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public void insertHead(int x) {
        insertNth(x, 0);
    }

    public void insert(int data) {
        insertNth(data, size);
    }

    public void insertNth(int data, int position) {
        checkBounds(position, 0, size);
        Node cur = head;
        for (int i = 0; i < position; ++i) {
            cur = cur.next;
        }
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void insertSorted(int data) {
        Node cur = head;
        while (cur.next != null && data > cur.next.value) {
            cur = cur.next;
        }
        Node newNode = new Node(data);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteHead() {
        deleteNth(0);
    }

    public void delete() {
        deleteNth(size - 1);
    }

    public void deleteNth(int position) {
        checkBounds(position, 0, size - 1);
        Node cur = head;
        for (int i = 0; i < position; ++i) {
            cur = cur.next;
        }
        Node destory = cur.next;
        cur.next = cur.next.next;
        destory = null;
        size--;
    }

    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    public void clear() {
        if (size == 0) {
            return;
        }
        Node prev = head.next;
        Node cur = prev.next;
        while (cur != null) {
            prev = null;
            prev = cur;
            cur = cur.next;
        }
        prev = null;
        head.next = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Node cur = head.next;
        while (cur != null) {
            builder.append(cur.value).append("->");
            cur = cur.next;
        }
        return builder.replace(builder.length() - 2, builder.length(), "").toString();
    }

    public static SinglyLinkedList merge(SinglyLinkedList listA, SinglyLinkedList listB) {
        Node headA = listA.head.next;
        Node headB = listB.head.next;
        int size = listA.size() + listB.size();
        Node head = new Node();
        Node tail = head;
        while (headA != null && headB != null) {
            if (headA.value <= headB.value) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;
        }
        if (headA == null) {
            tail.next = headB;
        }
        if (headB == null) {
            tail.next = headA;
        }
        return new SinglyLinkedList(head, size);
    }
}

class Node {
    int value;
    Node next;

    Node() {
    }

    Node(int value) {
        this(value, null);
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}