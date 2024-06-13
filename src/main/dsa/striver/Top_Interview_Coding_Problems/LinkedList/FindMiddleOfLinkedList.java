package src.main.dsa.striver.Top_Interview_Coding_Problems.LinkedList;

public class FindMiddleOfLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    //1,2,3,4,5
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        System.out.println(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {

        if (null == head || null == head.next) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while ((null != fast) && (null != fast.next)) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

}
