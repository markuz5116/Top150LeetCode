package easy_questions;

public class PalindromeLinkedList {
    public class ListNode {
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

    // Given the head of a singly linked list, return true if it is a palindrome or
    // false otherwise.
    public boolean isPalindrome(ListNode head) {
        ListNode halfListNode = head;
        ListNode twoStepNode = head.next;
        while (twoStepNode != null && twoStepNode.next != null) {
            halfListNode = halfListNode.next;
            twoStepNode = twoStepNode.next;
            if (twoStepNode != null) {
                twoStepNode = twoStepNode.next;
            }
        }

        ListNode secHalfNode = halfListNode.next;
        halfListNode.next = null;
        ListNode reversedNode = reverse(secHalfNode);
        while (reversedNode != null) {
            if (head.val != reversedNode.val) {
                return false;
            }
            head = head.next;
            reversedNode = reversedNode.next;
        }
        halfListNode.next = reverse(secHalfNode);
        return true;
    }

    private ListNode reverse(ListNode currNode) {
        if (currNode == null) {
            return null;
        }
        ListNode nextNode = currNode.next;
        currNode.next = null;
        while (nextNode != null) {
            ListNode nextNextNode = nextNode.next;
            nextNode.next = currNode;
            currNode = nextNode;
            nextNode = nextNextNode;
        }
        return currNode;
    }   

}
