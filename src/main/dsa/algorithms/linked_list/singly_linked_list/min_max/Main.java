package src.main.dsa.algorithms.linked_list.singly_linked_list.min_max;

import src.main.dsa.algorithms.linked_list.singly_linked_list.Node;

public class Main {

    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Node node = new Node(100, null);
        Node node1 = new Node(90, node);
        Node node2 = new Node(110, node1);
        Node node3 = new Node(80, node2);
        Node node4 = new Node(60, node3);

        Node current = new Node(70, node4);
        while (null != current.getNext()) {
            min = Math.min(min, Integer.parseInt(current.getData().toString()));
            max = Math.max(max, Integer.parseInt(current.getData().toString()));

            current = current.getNext();
        }

        System.out.println("Min value : " + min);
        System.out.println("Max value : " + max);
    }

}
