package src.main.dsa.algorithms.data_structures.linked_list.doubly_linked_list;

public class Node {

    public Node previous;

    public Integer data;

    public Node next;

    public Node() {
    }

    public Node(Integer data, Node next, Node previous) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public Node(Integer data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "previous=" + previous +
                ", data=" + data +
                ", next=" + next +
                '}';
    }
}
