package easy_questions;

public class ReverseLinkedList {
    class ListNode {
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
    }

    // Given the head of a singly linked list, reverse the list, and return the
    // reversed list.
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode currNode = head;
        ListNode nextNode = currNode.next;
        head.next = null;
        while (nextNode != null) {
            ListNode nextNextNode = nextNode.next;
            nextNode.next = currNode;
            currNode = nextNode;
            nextNode = nextNextNode;
        }
        return currNode;
    }
}
