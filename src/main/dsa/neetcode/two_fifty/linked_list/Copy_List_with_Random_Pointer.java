package src.main.dsa.neetcode.two_fifty.linked_list;

import java.util.HashMap;

public class Copy_List_with_Random_Pointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        map.put(null, null);
        Node temp = head;
        while (temp != null) {
            Node num = new Node(temp.val);
            map.put(temp, num);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node num = map.get(temp);
            num.next = map.get(temp.next);
            num.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
