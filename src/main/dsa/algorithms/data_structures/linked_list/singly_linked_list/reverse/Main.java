package src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.reverse;

import src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.IntNode;

public class Main {

    public static void main(String[] args) {
        IntNode node = new IntNode(100, null);
        IntNode node1 = new IntNode(90, node);
        IntNode node2 = new IntNode(80, node1);
        IntNode node3 = new IntNode(70, node2);
        IntNode node4 = new IntNode(60, node3);
        IntNode node5 = new IntNode(50, node4);

        System.out.println(node5);
        System.out.println(node);

//        reverseLinksIterative(node5, node);
//
//        System.out.println(node5.toString());
//        System.out.println(node.toString());

        node = new IntNode(100, null);
        node1 = new IntNode(90, node);
        node2 = new IntNode(80, node1);
//        node3 = new IntNode(70, node2);
//        node4 = new IntNode(60, node3);
//        node5 = new IntNode(50, node4);

        IntNode reversedList = reverseLinksRecursive(node2);
        System.out.println(reversedList);
        System.out.println(node);
    }

    private static IntNode reverseLinksRecursive(IntNode head) {

        if (null == head || null == head.getNext()) {
            return head;
        }

        IntNode newHead = reverseLinksRecursive(head.getNext());
        IntNode front = head.getNext();
        front.setNext(head);
        head.setNext(null);
        return newHead;
    }

    private static void reverseLinksIterative(IntNode node5, IntNode node) {
        IntNode previous = null;
        IntNode current = node5;
        IntNode next = current.getNext();

        while (null != current) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
    }

}
