package datastructures.lists;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName DoublyLinkedList.java
 * @Description TODO
 * @createTime 2020-02-27 22:47
 */
public class DoublyLinkedList {
    private Link head;
    private Link tail;
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public DoublyLinkedList(int[] array){
        if(array == null){
            throw new NullPointerException();
        }
        for(int i : array){
            insertTail(i);
        }
    }
    public void insertHead(int x){
        Link newLink = new Link(x);
        if(isEmpty()){
            tail = newLink;
        }else{
            head.prevoius = newLink;
            newLink.next = head;
            head = newLink;
        }
    }

    public void insertTail(int x){
        Link newLink = new Link(x);
        newLink.next = null;
        if(isEmpty()){
            tail = newLink;
            head = tail;
        }else{
            tail.next = newLink;
            newLink.prevoius = tail;
            tail = newLink;
        }
    }
    public Link deleteHead() {
        Link temp = head;
        head = head.next;
        head.prevoius = null;
        if(head ==null){
            tail=null;
        }
        return temp;
    }
    public Link deleteTail(){
        Link temp = tail;
        tail = tail.prevoius;
        tail.next = null;
        if(tail==null){
            head = null;
        }
        return temp;
    }

    public void delete(int x){
        Link current = head;
        while(current.value != x){
            if(current != tail){
                current = current.next;
            } else{
                throw new RuntimeException("The element to be deleted does not exist!");
            }
        }
        if(current == head){
            deleteHead();
        }else if(current == tail){
            deleteTail();
        }else{
            current.prevoius.next = current.next;
            current.next.prevoius = current.prevoius;
        }
    }
    public void insertOrdered(int x){
        Link newLink = new Link(x);
        Link current = head;
        while(current !=null && x > current.value){
            current = current.next;
        }
        if(current == head){
            insertHead(x);
        }else if(current == null){
            insertTail(x);
        }else{
            newLink.prevoius = current.prevoius;
            current.prevoius.next = newLink;
            newLink.next = current;
            current.prevoius = newLink;
        }
    }
    public boolean isEmpty(){
        return (head == null);
    }

    public void display() { // Prints contents of the list
        Link current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

class Link{
    public int value;
    public Link next;
    public Link prevoius;
    public Link(int value){
        this.value = value;
    }
    public void displayLink(){
        System.out.println(value + "");
    }
}
