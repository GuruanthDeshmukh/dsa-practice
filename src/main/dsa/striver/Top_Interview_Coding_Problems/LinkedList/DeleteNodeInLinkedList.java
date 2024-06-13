package src.main.dsa.striver.Top_Interview_Coding_Problems.LinkedList;

public class DeleteNodeInLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode listNode) {
            val = x;
            next = listNode;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));

//        deleteNode();

    }

    public static void deleteNode(ListNode node) {

    }

}
