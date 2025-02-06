package src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.array_to_linked_list;

import src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.IntNode;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 10, 4};
        IntNode list = arrayToList(arr);
        System.out.println(list);
    }

    public static IntNode arrayToList(int[] arr) {
        IntNode head = new IntNode(arr[0]);

        IntNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            IntNode node = new IntNode(arr[i]);
            temp.setNext(node);
            temp = node;
        }

        return head;
    }

}
