package src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.add;

import src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.IntNode;

public class Main {

    public static void main(String[] args) {
//        Node node = new Node(100, null);
//        Node node1 = new Node(90, node);
//        Node node2 = new Node(80, node1);
//        Node node3 = new Node(70, node2);
//        System.out.println(node3.toString());
//
//        //Adding at first
//        Node node4 = new Node(60, node3);
//        System.out.println(node4.toString());
//
//        //Adding to last
//        Node node5 = new Node(110, null);
//        node.setNext(node5);
//        System.out.println(node4.toString());

        IntNode node = src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.array_to_linked_list.Main.arrayToList(new int[]{1, 2, 3, 4, 5});

//        IntNode extraHead = addHead(node, 10);
//        System.out.println(extraHead);
//
//        IntNode extraTail = addTail(node, 15);
//        System.out.println(extraTail);
//
//        IntNode extraBeforeKth = addAtKthPosition(node, 7, 100);
//        System.out.println(extraBeforeKth);

        IntNode extraBeforeValue = addBeforeValue(node, 4, 100);
        System.out.println(extraBeforeValue);

    }

    public static IntNode addAtKthPosition(IntNode head, int k, int value) {
        if (null == head) {
            if (1 == k) {
                return new IntNode(k);
            } else {
                throw new RuntimeException("Invalid list to add node at " + "th position");
            }
        }

        if (1 == k) {
            return new IntNode(value, head);
        }

        IntNode temp = head;
        int count = 0;

        while (null != temp) {
            count++;
            if (k - 1 == count) {
                IntNode newNode = new IntNode(value, temp.getNext());
                temp.setNext(newNode);
                return head;
            }

            temp = temp.getNext();
        }

        throw new RuntimeException("Invalid value provided for position");
    }

    public static IntNode addBeforeValue(IntNode head, int k, int value) {
        if (null == head) {
            throw new RuntimeException("Invalid list size");
        }

        if (null == head.getNext()) {
            return new IntNode(value, head);
        }

        IntNode temp = head;

        while (null != temp.getNext()) {
            if (k == temp.getNext().getData()) {
                IntNode newNode = new IntNode(value, temp.getNext());
                temp.setNext(newNode);
                return head;
            }

            temp = temp.getNext();
        }

        throw new RuntimeException("Invalid value provided for position");
    }

    public static IntNode addTail(IntNode head, int value) {

        if (null == head) {
            return new IntNode(value);
        }

        IntNode temp = head;
        while (null != temp.getNext()) {
            temp = temp.getNext();
        }
        IntNode newTail = new IntNode(value);
        temp.setNext(newTail);
        return head;
    }

    public static IntNode addHead(IntNode head, int i) {
        return new IntNode(i, head);
    }

}
