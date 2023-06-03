package easy_questions;

import java.util.HashSet;

public class IntersectionofTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Given the heads of two singly linked-lists headA and headB, return the node
    // at which the two lists intersect. If the two linked lists have no
    // intersection at all, return null.
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aSize = 0;
        int bSize = 0;
        ListNode tailA = headA;
        ListNode tailB = headB;
        HashSet<ListNode> visited = new HashSet<>();
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (visited.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
