package datastructures.queues;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName PriorityQueues.java
 * @Description TODO
 * @createTime 2020-02-29 12:55
 */
class PriorityQueue {
    private int maxSize;
    private int[] queueArray;
    private int nItems;

    public PriorityQueue(int size) {
        maxSize = size;
        queueArray = new int[size];
        nItems = 0;
    }

    public void insert(int value) {
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }else{
            int j = nItems - 1;
            while(j>=0&&queueArray[j]>value){
                queueArray[j+1] = queueArray[j];
                j--;
            }
            queueArray[j+1] = value;
            nItems++;
        }
    }
    public int remove(){
        return queueArray[--nItems];
    }
    public int peek(){
        return queueArray[nItems-1];
    }
    public boolean isEmpty(){
        return (nItems == 0);
    }
    public boolean isFull(){
        return (nItems == maxSize);
    }
    public int getSize(){
        return nItems;
    }
}
