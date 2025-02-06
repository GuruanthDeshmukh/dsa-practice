package src.main.dsa.algorithms.data_structures.tree;

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

        //              10
        //       5              15
        //    2     7       12      18

        System.out.println(root);

//        int heightOfTree = getHeightOfTree(root);
//        System.out.println(heightOfTree);
//
//        String inOrderTraversal = performInOrderTraversal(root);
//        System.out.println(inOrderTraversal);
//
//        String preOrderTraversal = performPreOrderTraversal(root);
//        System.out.println(preOrderTraversal);
//
//        String postOrderTraversal = performPostOrderTraversal(root);
//        System.out.println(postOrderTraversal);

        List<List<Integer>> levelOrderTraversalPractice = performLevelOrderTraversalPractice(root);
        System.out.println(levelOrderTraversalPractice);

        Node root1 = new Node(1);
        Node rootLeftChild = new Node(2);
        Node rootRightChild = new Node(3);
        Node rootLeftChildLeftChild = new Node(4);
        Node rootRightChildRightChild = new Node(5);
        //                      1
        //              2               3
        //          4                       5
        root1.left = rootLeftChild;
        root1.right = rootRightChild;
        rootLeftChild.left = rootLeftChildLeftChild;
        rootRightChild.right = rootRightChildRightChild;


        List<List<Integer>> zigZagTraversal = performZigZapTraversal(root1);
        System.out.println(zigZagTraversal);
    }

    private static List<List<Integer>> performZigZapTraversal(Node root) {
        List<List<Integer>> response = new ArrayList<>();
        if (root == null)
            return response;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        response.add(List.of(root.key));
        boolean isLeftToRight = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node temp = queue.poll();
                if (!isLeftToRight) {
                    if (temp != null) {
                        if (temp.left != null) {
                            list.add(temp.left.key);
                            queue.add(temp.left);
                        }

                        if (temp.right != null) {
                            list.add(temp.right.key);
                            queue.add(temp.right);
                        }
                    }
                } else {
                    if (temp != null) {
                        if (temp.right != null) {
                            list.add(temp.right.key);
                            queue.add(temp.right);
                        }

                        if (temp.left != null) {
                            list.add(temp.left.key);
                            queue.add(temp.left);
                        }
                    }
                    Collections.reverse(list);
                }
            }
            isLeftToRight = !isLeftToRight;
            if (!list.isEmpty())
                response.add(list);
        }

        return response;
    }

    private static List<List<Integer>> performLevelOrderTraversalPractice(Node root) {
        List<List<Integer>> response = new ArrayList<>();
        if (root == null)
            return response;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        response.add(List.of(root.key));
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        list.add(temp.left.key);
                        queue.add(temp.left);
                    }

                    if (temp.right != null) {
                        list.add(temp.right.key);
                        queue.add(temp.right);
                    }
                }
            }
            if (!list.isEmpty())
                response.add(list);
        }

        return response;
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
