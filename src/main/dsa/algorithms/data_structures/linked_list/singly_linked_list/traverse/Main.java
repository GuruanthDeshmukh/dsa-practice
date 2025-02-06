package src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.traverse;

import src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.Node;

public class Main {

    public static void main(String[] args) {
        Node end = new Node("End", null);
        Node legs = new Node("Legs", end);
        Node torse = new Node("Torso", legs);
        Node head = new Node("Head", torse);

        Node current = head;
        System.out.println("Beginning to traverse the list");
        while (current != null) {
            System.out.println("Currently on : " + current.getData());
            current = current.getNext();
        }
        System.out.println("Traversal completed for the list");
    }

}
