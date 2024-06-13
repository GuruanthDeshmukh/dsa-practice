package src.main.dsa.algorithms.linked_list.singly_linked_list.delete;

import src.main.dsa.algorithms.linked_list.singly_linked_list.IntNode;

public class Main {

    public static void main(String[] args) {
        IntNode node = src.main.dsa.algorithms.linked_list.singly_linked_list.array_to_linked_list.Main.arrayToList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});

        IntNode headless = deleteHead(node);
        System.out.println(headless);

        IntNode tailless = deleteTail(node);
        System.out.println(tailless);

        IntNode kthless = deleteKthNode(node, 7);
        System.out.println(kthless);

        IntNode removeValue = deleteValue(node, 5);
        System.out.println(removeValue);

    }

    public static IntNode deleteValue(IntNode head, int value) {
        if (null == head || null == head.getNext())
            return null;

        if (value == head.getData()) {
            return deleteHead(head);
        }

        boolean valueAvailability = false;

        IntNode temp = head;
        IntNode previous = null;

        while (null != temp) {
            if (value == temp.getData()) {
                previous.setNext(previous.getNext().getNext());
                valueAvailability = true;
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }

        if (Boolean.FALSE.equals(valueAvailability)) {
            throw new RuntimeException("Value missing in the linked list");
        }

        return head;
    }

    public static IntNode deleteKthNode(IntNode head, Integer k) {
        if (null == head || null == head.getNext())
            return null;

        if (1 == k) {
            return deleteHead(head);
        }

        int current = 0;

        IntNode temp = head;
        IntNode previous = null;

        while (null != temp) {
            current++;
            if (k == current) {
                previous.setNext(previous.getNext().getNext());
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }

        if (k > current) {
            throw new RuntimeException("Size too big for linked list");
        }

        return head;
    }

    public static IntNode deleteTail(IntNode head) {
        if (null == head || null == head.getNext())
            return null;

        IntNode temp = head;

        while (null != temp.getNext().getNext()) {
            temp = temp.getNext();
        }

        temp.setNext(null);

        return head;
    }

    public static IntNode deleteHead(IntNode head) {
        if (null == head || null == head.getNext())
            return head;

        head = head.getNext();

        return head;
    }
}
