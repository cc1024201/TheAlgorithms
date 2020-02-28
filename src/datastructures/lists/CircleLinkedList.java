package datastructures.lists;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName CircleLinkedList.java
 * @Description TODO
 * @createTime 2020-02-28 20:36
 */
public class CircleLinkedList<E> {
    private static class Node<E> {
        Node<E> next;
        E value;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private Node<E> head;

    public CircleLinkedList() {
        head = new Node<E>(null, head);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void append(E value) {
        if (value == null) {
            throw new NullPointerException("Cannot add null element to the list");
        }
        head.next = new Node<E>(value, head);
        size++;
    }

    public E remove(int pos) {
        if (pos > size || pos < 0) {
            throw new IndexOutOfBoundsException("position cannot be greater than size or negative");
        }
        Node<E> before = head;
        for (int i = 1; i <= pos; i++) {
            before = before.next;
        }
        Node<E> destory = before.next;
        E saved = destory.value;
        before.next = before.next.next;
        destory = null;
        size--;
        return saved;
    }
}
