package src.main.dsa.neetcode.two_fifty.linked_list;

public class Remove_Nth_Node_From_End_of_List {
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
        System.out.println(removeNthFromEnd(createList(new int[] {1,2,3,4,5}), 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return new ListNode();
//        ListNode slow = head;
//        ListNode fast = head;
//        int slowCounter = 0;
//        int fastCounter = 0;
//        while (fast != null) {
//            slowCounter++;
//            slow = slow.next;
//            if (fast.next != null) {
//                fast = fast.next.next;
//                fastCounter += 2;
//            } else {
//                fast = fast.next;
//                fastCounter++;
//            }
//        }
//        n = fastCounter - n;
//        if (n >= slowCounter) {
//            ListNode prev = slow;
//            while (slowCounter != n) {
//                prev = slow;
//                slow = slow.next;
//                slowCounter++;
//            }
//            prev = prev.next.next;
//        } else {
//            int index = 0;
//            ListNode prev = head;
//            slow = head.next;
//            while (index != n) {
//                index++;
//                prev = slow;
//                slow = slow.next;
//            }
//        }

//        ListNode fast = head;
//        ListNode slow = head;
//        int slowCounter = 0;
//        int fastCounter = 0;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            slowCounter++;
//            fastCounter+=2;
//        }
//        n = fastCounter - n;
//        ListNode prevPointer = head;
//        ListNode headPointer = head;
//        if (slowCounter <= n) {
//            prevPointer = slow;
//            while (slowCounter <= n) {
//                if (n == slowCounter) {
//                    prevPointer = prevPointer.next.next;
//                } else {
//                    prevPointer = prevPointer.next;
//                }
//                slowCounter++;
//            }
//        } else {
//            int index = 0;
//            while (index != n) {
//                index++;
//                prevPointer = prevPointer.next;
//            }
//            prevPointer = prevPointer.next;
//        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int index = 0;
        while (index != n+1) {
            fast = fast.next;
            index++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
