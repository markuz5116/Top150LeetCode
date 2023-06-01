package easy_questions;

class MergeTwoSortedLists {
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

    // You are given the heads of two sorted linked lists list1 and list2.
    // Merge the two lists in a one sorted list. The list should be made by splicing
    // together the nodes of the first two lists.
    // Return the head of the merged linked list.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalListHead = null;
        ListNode finalListTail = null;
        while (list1 != null && list2 != null) {
            ListNode smallerNode = null;
            if (list1.val < list2.val) {
                smallerNode = list1;
                list1 = list1.next;
            } else {
                smallerNode = list2;
                list2 = list2.next;
            }

            if (finalListHead == null) {
                finalListHead = smallerNode;
            } else {
                finalListTail.next = smallerNode;
            }
            finalListTail = smallerNode;
        }

        while (list1 != null) {
            if (finalListHead == null) {
                finalListHead = list1;
            } else {
                finalListTail.next = list1;
            }
            finalListTail = list1;
            list1 = list1.next;
        }

        while (list2 != null) {
            if (finalListHead == null) {
                finalListHead = list2;
            } else {
                finalListTail.next = list2;
            }
            finalListTail = list2;
            list2 = list2.next;
        }

        return finalListHead;
    }
}