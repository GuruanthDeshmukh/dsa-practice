package src.main.dsa.algorithms.tree;

import java.util.*;

public class CreateTest {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node leftChild = new Node(5);
        Node rightChild = new Node(15);
        Node leftChildLeftLeaf = new Node(2);
        Node leftChildRightLead = new Node(7);
        Node rightChildLeftLeaf = new Node(12);
        Node rightChildRightLeaf = new Node(18);
        root.left = leftChild;
        root.right = rightChild;
        leftChild.left = leftChildLeftLeaf;
        leftChild.right = leftChildRightLead;
        rightChild.left = rightChildLeftLeaf;
        rightChild.right = rightChildRightLeaf;

        System.out.println(root);

        int heightOfTree = getHeightOfTree(root);
        System.out.println(heightOfTree);

        String inOrderTraversal = performInOrderTraversal(root);
        System.out.println(inOrderTraversal);

        String preOrderTraversal = performPreOrderTraversal(root);
        System.out.println(preOrderTraversal);

        String postOrderTraversal = performPostOrderTraversal(root);
        System.out.println(postOrderTraversal);

        List<List<Integer>> levelOrderTraversal = performLevelOrderTraversal(root);
    }

    private static List<List<Integer>> performLevelOrderTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Node temp = root;
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(temp);
        while (nodeQueue != null) {
            List<Integer> list = new ArrayList<>();

        }
        return null;
    }

    private static String performInOrderTraversal(Node root) {
        Node temp = root;
        if (temp.left == null && temp.right == null) {
            return String.valueOf(temp.key);
        }
        String leftString = performInOrderTraversal(temp.left);
        String rightString = performInOrderTraversal(temp.right);

        return leftString + "," + root.key + "," + rightString;
    }

    private static String performPreOrderTraversal(Node root) {
        Node temp = root;
        if (temp.left == null && temp.right == null) {
            return String.valueOf(temp.key);
        }
        String leftString = performPreOrderTraversal(temp.left);
        String rightString = performPreOrderTraversal(temp.right);

        return root.key + "," + leftString + "," + rightString;
    }

    private static String performPostOrderTraversal(Node root) {
        Node temp = root;
        if (temp.left == null && temp.right == null) {
            return String.valueOf(temp.key);
        }
        String leftString = performPostOrderTraversal(temp.left);
        String rightString = performPostOrderTraversal(temp.right);

        return leftString + "," + rightString + "," + root.key;
    }

    private static int getHeightOfTree(Node root) {
        Node temp = root;
        int height = 0;
        if (null == root)
            return height;

        int leftHeight = getHeightOfTree(temp.left);
        int rightHeight = getHeightOfTree(temp.right);
        height = 1 + Math.max(leftHeight, rightHeight);

        return height;

    }
}
