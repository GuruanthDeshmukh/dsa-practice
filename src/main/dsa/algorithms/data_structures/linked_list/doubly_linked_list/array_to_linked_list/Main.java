package src.main.dsa.algorithms.data_structures.linked_list.doubly_linked_list.array_to_linked_list;

import src.main.dsa.algorithms.data_structures.linked_list.doubly_linked_list.Helper;
import src.main.dsa.algorithms.data_structures.linked_list.doubly_linked_list.Node;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        Node node = arrayToLinkedList(arr);
        Helper.print(node);
    }

    public static Node arrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node previous = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, head);
            previous.next = temp;
            previous = temp;
        }

        return head;
    }

}
