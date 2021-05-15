package explore.recursion1;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.recursion1
 * @date 5/13/21
 * @comment: https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/
 */
public class MergeTwoSortedLists {

  public static void main(String[] args) {
    ListNode nodea0 = new ListNode(1);
    ListNode nodea1 = new ListNode(2);
    ListNode nodea2 = new ListNode(3);

    nodea0.next = nodea1;
    nodea1.next = nodea2;

    ListNode nodeb0 = new ListNode(1);
    ListNode nodeb1 = new ListNode(2);
    ListNode nodeb2 = new ListNode(3);
    ListNode nodeb3 = new ListNode(4);


    nodeb0.next = nodeb1;
    nodeb1.next = nodeb2;
    nodeb2.next = nodeb3;

    Solution solution = new Solution();
    ListNode node = solution.mergeTwoLists(nodea0, nodeb0);

    while (node != null) {
      System.out.println(node);
      node = node.next;
    }
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }
      if (l1.val <= l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
      }
      else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
      }
    }
  }
}
