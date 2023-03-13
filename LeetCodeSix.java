import java.util.Arrays;

public class LeetCodeSix {

    /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    Diff: Easy
    Problem: Remove duplicates from a sorted linked list
    Input: head Node
    Ouptut: head pointing to sorted linked list without duplicates
    */

      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = new ListNode(0);
        slow = head;
        while (slow.next != null) {
            if (slow.val == slow.next.val) {
                slow.next = slow.next.next;
            } else {
                slow = slow.next;
            }
        }
        return head;
    }

     /*
    https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    Diff: Medium
    Problem: Remove nth node from end of linked list
    Input: head Node
    Ouptut: head pointing to sorted linked list without nth node
    */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = new ListNode(0);
        fast.next = head;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return head;
    }

    /*
    https://leetcode.com/problems/middle-of-the-linked-list/
    Diff: Easy
    Problem: Given the head of a singly linked list, return the middle node of the linked list.
    Input: head Node
    Ouptut: node pointing to middle of linked list and onwards
    */

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
