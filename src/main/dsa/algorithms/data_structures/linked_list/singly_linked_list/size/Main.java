package src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.size;

import src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.IntNode;

public class Main {

    public static void main(String[] args) {
        IntNode node = src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.array_to_linked_list.Main.arrayToList(new int[]{1, 3, 5, 7});
        System.out.println(sizeOfList(node));
    }

    public static int sizeOfList(IntNode node) {

        if (null == node) {
            return 0;
        } else if (null == node.getNext()) {
            return 1;
        }
        return 1 + sizeOfList(node.getNext());
    }
}
