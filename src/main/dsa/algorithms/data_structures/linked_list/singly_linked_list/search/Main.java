package src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.search;

import src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.IntNode;

public class Main {

    public static void main(String[] args) {
        IntNode node = src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.array_to_linked_list.Main.arrayToList(new int[]{3, 7, 5});
        IntNode newAtHead = addAtHead(node, 1);
        System.out.println(newAtHead);
    }

    public static IntNode addAtHead(IntNode node, int i) {
        IntNode head = new IntNode(i);
        head.setNext(node);
        return head;
    }

//    public static IntNode addAtTail(IntNode node, int i){
//        IntNode tail = new IntNode(i);
//        IntNode temp = node;
//        int size = size.singly_linked_list.src.main.dsa.algorithms.data_structures.linked_list.Main.sizeOfList(node);
//
//        for (int j = 0; j <= ; j++) {
//
//        }
//    }

}
