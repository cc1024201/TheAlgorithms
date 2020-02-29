package datastructures.queues;

import java.util.ArrayList;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName GenericArrayListQueue.java
 * @Description TODO
 * @createTime 2020-02-29 14:58
 */
public class GenericArrayListQueue<T> {
    ArrayList<T> _queue = new ArrayList<>();
    private boolean hasElements(){
        return !_queue.isEmpty();
    }
    public T peek(){
        T result = null;
        if(this.hasElements()){
            result = _queue.get(0);
        }
        return result;
    }
    public boolean add(T element){
        return _queue.add(element);
    }
    public T poll(){
        T result = null;
        if(this.hasElements()){
            result = _queue.remove(0);
        }
        return result;
    }

}
