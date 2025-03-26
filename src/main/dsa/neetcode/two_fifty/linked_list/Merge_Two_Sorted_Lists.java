package src.main.dsa.neetcode.two_fifty.linked_list;

public class Merge_Two_Sorted_Lists {

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
        System.out.println(mergeTwoLists(createList(new int[]{1, 2, 4}), createList(new int[]{1, 3, 4})));
        System.out.println(mergeTwoLists(createList(new int[]{}), createList(new int[]{})));
        System.out.println(mergeTwoLists(createList(new int[]{}), createList(new int[]{0})));
        System.out.println(mergeTwoLists(createList(new int[]{1}), createList(new int[]{})));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode res = null;
        ListNode pointer = null;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                if (res == null) {
                    res = new ListNode(temp1.val, null);
                    pointer = res;
                } else {
                    ListNode temp = new ListNode(temp1.val, null);
                    pointer.next = temp;
                    pointer = pointer.next;
                }
                temp1 = temp1.next;
            } else {
                if (res == null) {
                    res = new ListNode(temp2.val, null);
                    pointer = res;
                } else {
                    ListNode temp = new ListNode(temp2.val, null);
                    pointer.next = temp;
                    pointer = pointer.next;
                }
                temp2 = temp2.next;
            }
        }
        while (temp1 != null) {
            ListNode temp = new ListNode(temp1.val, null);
            pointer.next = temp;
            pointer = pointer.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            ListNode temp = new ListNode(temp2.val, null);
            pointer.next = temp;
            pointer = pointer.next;
            temp2 = temp2.next;
        }
        return res;
    }
}
