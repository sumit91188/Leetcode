package explore.linkedlist;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/10/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
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

    public ListNode mergeTwoLists(ListNode rootNodeA, ListNode rootNodeB) {
      ListNode dummyHead = new ListNode(0);
      ListNode currentA = rootNodeA;
      ListNode currentB = rootNodeB;
      ListNode currentRes  = dummyHead;

      while (currentA != null || currentB != null) {
        if (currentA == null) {
          currentRes.next = currentB;
          break;
        }
        else if (currentB == null) {
          currentRes.next = currentA;
          break;
        }
        else {
          if (currentA.val <= currentB.val) {
            currentRes.next = currentA;
            currentA = currentA.next;
          }
          else {
            currentRes.next = currentB;
            currentB = currentB.next;
          }
        }
        currentRes = currentRes.next;
      }
      return dummyHead.next;
    }
  }
}
