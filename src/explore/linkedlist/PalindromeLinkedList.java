package explore.linkedlist;


import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/10/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/
 */
public class PalindromeLinkedList {

  public static void main(String[] args) {
    ListNode node0 = new ListNode(2);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(1);
    ListNode node5 = new ListNode(2);

    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    Solution solution = new Solution();
    boolean palindrome = solution.isPalindrome(node0);
    System.out.println(palindrome);
  }

  private static class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          '}';
    }
  }

  private static class Solution {

    public boolean isPalindrome(ListNode headNode) {
      int len = 0;
      ListNode currentNode = headNode;

      while (currentNode != null) {
        len++;
        currentNode = currentNode.next;
      }

      if (len == 1) {
        return true;
      }

      Stack<ListNode> stack = new Stack<>();

      currentNode = headNode;
      for (int i = 1; i <= len / 2; i++) {
        stack.push(currentNode);
        currentNode = currentNode.next;
      }

      if (len % 2 != 0) {
        currentNode = currentNode.next;
      }

      while (currentNode != null) {
        if (currentNode.val != stack.pop().val) {
          return false;
        }
        currentNode = currentNode.next;
      }

      return true;
    }
  }
}
