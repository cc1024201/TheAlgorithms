package datastructures.heaps;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName MinPriorityQueue.java
 * @Description TODO
 * @createTime 2020-02-26 22:28
 */
public class MinPriorityQueue {
    private int[] heap;
    private int capacity;
    private int size;

    MinPriorityQueue(int c) {
        this.capacity = c;
        this.size = 0;
        this.heap = new int[c + 1];
    }

    public void insert(int key) {
        if (this.isFull()) {
            return;
        }
        this.heap[this.size + 1] = key;
        int k = this.size + 1;
        while (k > 1) {
            if (this.heap[k] < this.heap[k / 2]) {
                int temp = this.heap[k];
                this.heap[k] = this.heap[k / 2];
                this.heap[k / 2] = temp;
            }
            k = k / 2;
        }
        this.size++;
    }

    public int peek() {
        return this.heap[1];
    }

    public boolean isEmpty() {
        if (0 == this.size) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (this.size == this.capacity) {
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 1; i <= this.capacity; i++) {
            System.out.print(this.heap[i] + " ");
        }
        System.out.println();
    }

    public void heapSort() {
        for (int i = 1; i < this.capacity; i++) {
            this.delete();
        }
    }

    private void sink() {
        int k = 1;
        while (2 * k <= this.size || 2 * k + 1 <= this.size) {
            int minIndex;
            if (this.heap[2 * k] >= this.heap[k]) {
                if (2 * k + 1 <= this.size && this.heap[2 * k + 1] >= this.heap[k]) {
                    break;
                } else if (2 * k + 1 > this.size) {
                    break;
                }
            }
            if (2 * k + 1 > this.size) {
                minIndex = this.heap[2 * k] < this.heap[k] ? 2 * k : k;
            } else {
                if (this.heap[k] > this.heap[2 * k] || this.heap[k] > this.heap[2 * k + 1]) {
                    minIndex = this.heap[2 * k] < this.heap[2 * k + 1] ? 2 * k : 2 * k + 1;
                } else {
                    minIndex = k;
                }
            }
            int temp = this.heap[k];
            this.heap[k] = this.heap[minIndex];
            this.heap[minIndex] = temp;
            k = minIndex;
        }
    }

    public int delete() {
        int min = this.heap[1];
        this.heap[1] = this.heap[this.size];
        this.heap[this.size] = min;
        this.size--;
        this.sink();
        return min;
    }
}
