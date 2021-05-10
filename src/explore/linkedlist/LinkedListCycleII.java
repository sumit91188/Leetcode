package explore.linkedlist;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/8/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
 */
public class LinkedListCycleII {

  public static void main(String[] args) {
    ListNode listNode0 = new ListNode(3);
    ListNode listNode1 = new ListNode(2);
    ListNode listNode2 = new ListNode(0);
    ListNode listNode3 = new ListNode(-4);

    listNode0.nextListNode = listNode1;
    listNode1.nextListNode = listNode2;
    listNode2.nextListNode = listNode3;
    listNode3.nextListNode = listNode1;

    Solution solution = new Solution();
    ListNode listNode = solution.detectCycle(listNode0);
    System.out.println(listNode.val);
  }

  private static class ListNode {

    int val;
    ListNode nextListNode;

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode nextListNode) {
      this.val = val;
      this.nextListNode = nextListNode;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          '}';
    }
  }

  private static class Solution {

    public ListNode detectCycle(ListNode headNode) {
      ListNode intersectionNode = findIntersectionNode(headNode);

      if (intersectionNode == null) {
        return null;
      }

      ListNode pointerNode1 = headNode;
      ListNode pointerNode2 = intersectionNode;

      while (pointerNode1 != pointerNode2) {
        pointerNode1 = pointerNode1.nextListNode;
        pointerNode2 = pointerNode2.nextListNode;
      }

      return pointerNode1;
    }

    private ListNode findIntersectionNode(ListNode headNode) {
      ListNode hareNode = headNode;
      ListNode tortoiseNode = headNode;

      while (hareNode != null && hareNode.nextListNode != null) {
        hareNode = hareNode.nextListNode.nextListNode;
        tortoiseNode = tortoiseNode.nextListNode;

        if (hareNode == tortoiseNode) {
          return hareNode;
        }
      }
      return null;
    }
  }
}
