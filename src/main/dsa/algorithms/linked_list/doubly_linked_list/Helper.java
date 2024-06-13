package src.main.dsa.algorithms.linked_list.doubly_linked_list;

public class Helper {
    public static void print(Node node) {
        while (null != node) {
            System.out.print(" " + node.data);
            node = node.next;
        }
        System.out.println();
    }
}
