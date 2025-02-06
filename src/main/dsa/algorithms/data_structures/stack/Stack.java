package src.main.dsa.algorithms.data_structures.stack;

import java.util.ArrayList;

public class Stack {
    private final ArrayList<Integer> list;
    private int top = -1;
    private final int size;

    public Stack(int size) {
        this.size = size;
        list = new ArrayList<>(size);
    }

    public void push(Integer element) {
        top++;
        if (top >= size) {
            top--;
            throw new RuntimeException("Max stack size reached");
        }
        list.add(element);
    }

    public void pop() {
        if (top == -1)
            throw new RuntimeException("Stack is empty");
        list.remove(top);
        top--;
    }

    public Integer top() {
        if (top == -1)
            throw new RuntimeException("Stack is empty");
        return list.get(top);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size;
    }

    public void print() {
        System.out.println(list);
    }
}
