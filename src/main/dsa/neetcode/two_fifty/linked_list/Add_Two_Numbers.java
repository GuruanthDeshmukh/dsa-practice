package src.main.dsa.neetcode.two_fifty.linked_list;

public class Add_Two_Numbers {

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
        System.out.println(addTwoNumbers(createList(new int[]{2,4,3}), createList(new int[]{5,6,4})));
        System.out.println(addTwoNumbers(createList(new int[]{0}), createList(new int[]{0})));
        System.out.println(addTwoNumbers(createList(new int[]{9,9,9,9,9,9,9}), createList(new int[]{9,9,9,9})));
        System.out.println(addTwoNumbers(createList(new int[]{2,4,9}), createList(new int[]{5,6,4,9})));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        boolean carryFlag = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (carryFlag)
                sum++;
            if (sum >= 10) {
                carryFlag = true;
                sum %= 10;
            } else {
                carryFlag = false;
            }
            pointer.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            pointer = pointer.next;
        }

        while (l1 != null) {
            int sum = l1.val;
            if (carryFlag)
                sum++;
            if (sum >= 10) {
                carryFlag = true;
                sum %= 10;
            } else {
                carryFlag = false;
            }
            pointer.next = new ListNode(sum);
            l1 = l1.next;
            pointer = pointer.next;
        }

        while (l2 != null) {
            int sum = l2.val;
            if (carryFlag)
                sum++;
            if (sum >= 10) {
                carryFlag = true;
                sum %= 10;
            } else {
                carryFlag = false;
            }
            pointer.next = new ListNode(sum);
            l2 = l2.next;
            pointer = pointer.next;
        }
        if (carryFlag) {
            pointer.next = new ListNode(1);
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode list) {
        ListNode prev = null;
        ListNode current = list;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
