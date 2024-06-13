package src.main.dsa.algorithms.linked_list.doubly_linked_list.delete;

import src.main.dsa.algorithms.linked_list.doubly_linked_list.Helper;
import src.main.dsa.algorithms.linked_list.doubly_linked_list.Node;

public class Main {

    public static void main(String[] args) {
        Node node = src.main.dsa.algorithms.linked_list.doubly_linked_list.array_to_linked_list.Main.arrayToLinkedList(new int[]{1, 2, 3, 4, 5});
//        Helper.print(node);

        Helper.print(deleteHead(node));
    }

    public static Node deleteHead(Node head) {
        if (null == head || null == head.next)
            return null;

        Node previous = head;
        head = head.next;
        head.previous = null;
        previous.next = null;

        return head;
    }

//    public static Node deleteTail

}
