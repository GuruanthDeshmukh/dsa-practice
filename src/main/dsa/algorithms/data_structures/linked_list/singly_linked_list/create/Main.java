package src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.create;

import src.main.dsa.algorithms.data_structures.linked_list.singly_linked_list.Node;

public class Main {

    public static void main(String[] args) {
        Node head = new Node();
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        Node end = new Node();
        head.setData("Head Node");
        head.setNext(one);
        //head -> one

        one.setData(1);
        one.setNext(two);
        //one -> two

        two.setNext(three);
        two.setData(null);
        //two -> three

        three.setNext(end);
        three.setData(true);
        //three -> end

        end.setNext(null);
        end.setData("End Node");
        //end -> null

        System.out.println(head);
        //head -> one -> two -> three -> end

    }

}
