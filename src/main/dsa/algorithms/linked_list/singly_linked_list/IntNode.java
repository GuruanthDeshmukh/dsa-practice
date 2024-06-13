package src.main.dsa.algorithms.linked_list.singly_linked_list;

public class IntNode {

    private Integer data;

    private IntNode next;

    public IntNode() {
    }

    public IntNode(Integer data, IntNode next) {
        this.data = data;
        this.next = next;
    }

    public IntNode(Integer data) {
        this.data = data;
    }

    public IntNode(IntNode next) {
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public IntNode getNext() {
        return next;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{\"Node\":{"
                + "\"data\":" + data
                + ", \"next\":" + next
                + "}}";
    }
}
