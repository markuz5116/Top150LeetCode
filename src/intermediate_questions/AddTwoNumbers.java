package intermediate_questions;

public class AddTwoNumbers {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumNode = new ListNode();
        ListNode currNode = null;
        while (l1 != null && l2 != null) {
            if (currNode == null) {
                currNode = sumNode;
            } else {
                currNode.next = new ListNode();
                currNode = currNode.next;
            }
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            currNode.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            if (currNode == null) {
                currNode = sumNode;
            } else {
                currNode.next = new ListNode();
                currNode = currNode.next;
            }
            int sum = carry + l1.val;
            carry = sum / 10;
            currNode.val = sum % 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            if (currNode == null) {
                currNode = sumNode;
            } else {
                currNode.next = new ListNode();
                currNode = currNode.next;
            }
            int sum = carry + l2.val;
            carry = sum / 10;
            currNode.val = sum % 10;
            l2 = l2.next;
        }

        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }
        return sumNode;
    }
}
