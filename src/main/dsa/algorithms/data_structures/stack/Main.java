package src.main.dsa.algorithms.data_structures.stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        try {
            stack.pop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        stack.push(23);
        stack.push(7);
        stack.push(2000);
        System.out.println(stack.top());
        try {
            stack.push(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        stack.print();
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

    }
}
