package src.main.dsa.neetcode.two_fifty.linked_list;

public class Prerequiste_Practice {

    static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

    public static void main(String[] args) {
        Node list = createList(new int[]{0, 5, 10, 15, 20});
        System.out.println(list);
        list = addAtFront(list, -5);
        System.out.println(list);
        list = addAtLast(list, -5);
        System.out.println(list);
        list = addAtKthIndex(list, 3, -5);
        System.out.println(list);
        list = deleteKthIndex(list, 3);
        System.out.println(list);
        list = deleteStart(list);
        System.out.println(list);
        list = deleteLast(list);
        System.out.println(list);
    }

    private static Node deleteKthIndex(Node list, int k) {
        Node prev = list;
        Node curr = list.next;
        int index = 1;
        while (index <= k) {
            if (index < k) {
                prev = curr;
                curr = curr.next;
            } else if (index == k) {
                prev.next = curr.next;
            }
            index++;
        }
        return list;
    }

    private static Node deleteLast(Node list) {
        Node temp = list;
        while (temp != null) {
            if (temp.next != null && temp.next.next == null)
                temp.next = null;
            else
                temp = temp.next;
        }
        return list;
    }

    private static Node deleteStart(Node list) {
        return list.next;
    }

    private static Node addAtKthIndex(Node list, int k, int i) {
        int index = 0;
        Node current = list;
        Node ahead = list.next;
        while (index != k) {
            if (index != k - 1) {
                current = ahead;
                ahead = ahead.next;
            } else {
                Node temp = new Node(i, ahead);
                current.next = temp;
            }
            index++;
        }
        return list;
    }

    private static Node addAtLast(Node list, int i) {
        Node temp = list;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = new Node(i, null);
                break;
            }
            temp = temp.next;
        }
        return list;
    }

    private static Node addAtFront(Node list, int i) {
        Node temp = new Node(i, list);
        return temp;
    }

    private static Node createList(int[] ints) {
        Node node = node = new Node(ints[ints.length - 1], null);
        Node temp = null;
        for (int i = ints.length - 2; i >= 0; i--) {
            temp = new Node(ints[i], node);
            node = temp;
        }
        return temp;
    }

}
