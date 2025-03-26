package src.main.dsa.neetcode.two_fifty.linked_list;

public class Reverse_Linked_List {
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
            return val + " -> " + next;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseList(createList(new int[]{1, 2, 3, 4, 5})));
        System.out.println(reverseListV2(createList(new int[]{1, 2, 3, 4, 5})));
        System.out.println(reverseListV3(createList(new int[]{1, 2, 3, 4, 5})));
        System.out.println(reverseList(createList(new int[]{1, 2})));
        System.out.println(reverseListV2(createList(new int[]{1, 2})));
        System.out.println(reverseListV3(createList(new int[]{1, 2})));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode res = null;
        ListNode newTail = new ListNode(head.val, null);
        ListNode temp = head.next;
        while (temp != null) {
            if (res == null) {
                res = new ListNode(temp.val, newTail);
            } else {
                res = new ListNode(temp.val, res);
            }
            temp = temp.next;
        }
        return res;
    }

    public static ListNode reverseListV2(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (null != current) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static ListNode reverseListV3(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseListV3(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;
    }


    private static ListNode createList(int[] ints) {
        ListNode node = node = new ListNode(ints[ints.length - 1], null);
        ListNode temp = null;
        for (int i = ints.length - 2; i >= 0; i--) {
            temp = new ListNode(ints[i], node);
            node = temp;
        }
        return temp;
    }
}
