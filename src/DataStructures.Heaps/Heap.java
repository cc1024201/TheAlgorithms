package DataStructures.Heaps;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName Heap.java
 * @Description TODO
 * @createTime 2020-02-24 21:16
 */
public interface Heap {
    HeapElement getElement() throws EmptyHeapException;

    void insertElement(HeapElement heapElement);

    void deleteElement(int elementIndex);
}
