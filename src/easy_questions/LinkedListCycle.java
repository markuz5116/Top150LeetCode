package easy_questions;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer != null) {
            if (slowPointer == fastPointer) {
                return true;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if (fastPointer == null) {
                return false;
            }
            fastPointer = fastPointer.next;
        }
        return false;
    }

}
