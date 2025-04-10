package src.main.dsa.algorithms.data_structures.tree;

public class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
