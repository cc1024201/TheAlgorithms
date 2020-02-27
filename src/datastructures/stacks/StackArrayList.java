package datastructures.stacks;

import java.util.ArrayList;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName StackArrayList.java
 * @Description TODO
 * @createTime 2020-02-27 21:10
 */
public class StackArrayList {
    private ArrayList<Integer> stackList;

    public StackArrayList() {
        stackList = new ArrayList<>();
    }

    public void push(int value) {
        stackList.add(value);
    }

    public int pop() {
        if (!isEmpty()) {
            int popValue = stackList.get(stackList.size() - 1);
            stackList.remove(stackList.size() - 1);
            return popValue;
        }
        System.out.println("The stack is already empty!");
        return -1;
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int peek() {
        return stackList.get(stackList.size() - 1);
    }
}
