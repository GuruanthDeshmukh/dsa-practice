package src.main.dsa.neetcode.two_fifty.linked_list;

public class Reorder_List {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

    private static ListNode createList(int[] ints) {
        if (ints.length == 0)
            return null;
        ListNode node = new ListNode(ints[ints.length - 1], null);
        if (ints.length == 1)
            return node;
        ListNode temp = null;
        for (int i = ints.length - 2; i >= 0; i--) {
            temp = new ListNode(ints[i], node);
            node = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode l1 = createList(new int[] {1,2,3,4,5});
        System.out.println(l1);
        reorderList(l1);
        System.out.println(l1);
        ListNode l2 = createList(new int[] {1,2,3,4,});
        System.out.println(l2);
        reorderList(l2);
        System.out.println(l2);

    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (secondHalf != null) {
            ListNode next = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = next;
        }

        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode tempFirst = first.next;
            ListNode tempSecond = second.next;
            first.next = second;
            second.next = tempFirst;
            first = tempFirst;
            second = tempSecond;
        }

    }

}
