package explore.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/9/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
 */
public class IntersectionOfTwoLinkedLists {

  public static void main(String[] args) {
    ListNode nodeA0 = new ListNode(4);
    ListNode nodeA1 = new ListNode(1);
    ListNode nodeA2 = new ListNode(8);
    ListNode nodeA3 = new ListNode(4);
    ListNode nodeA4 = new ListNode(5);

    nodeA0.next = nodeA1;
    nodeA1.next = nodeA2;
    nodeA2.next = nodeA3;
    nodeA3.next = nodeA4;

    ListNode nodeB0 = new ListNode(5);
    ListNode nodeB1 = new ListNode(6);
    ListNode nodeB2 = new ListNode(1);

    nodeB0.next = nodeB1;
    nodeB1.next = nodeB2;
    nodeB2.next = nodeA2;

    Solution solution = new Solution();
    ListNode node = solution.getIntersectionNode(nodeA0, nodeB0);

    System.out.println(node.val);
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

    public ListNode getIntersectionNode(ListNode nodeHeadA, ListNode nodeHeadB) {
      /*HashSet<ListNode> nodeAHashSet = new HashSet<>();

      ListNode currentNode = nodeHeadA;

      while (currentNode != null) {
        nodeAHashSet.add(currentNode);
        currentNode = currentNode.next;
      }

      currentNode = nodeHeadB;
      while (currentNode != null) {
        if (nodeAHashSet.contains(currentNode)) {
          return currentNode;
        }
        currentNode = currentNode.next;
      }

      return null;*/

      /*ListNode currentANode = nodeHeadA;
      ListNode currentBNode = nodeHeadB;
      int aLen = 0;
      int bLen = 0;

      while (currentANode != null) {
        aLen++;
        currentANode = currentANode.next;
      }

      while (currentBNode != null) {
        bLen++;
        currentBNode = currentBNode.next;
      }

      int diff = Math.abs(aLen - bLen);

      currentANode  = nodeHeadA;
      currentBNode = nodeHeadB;

      if (aLen > bLen) {
        while (diff > 0) {
          currentANode = currentANode.next;
          diff--;
        }
      }
      else if (bLen > aLen) {
        while (diff > 0) {
          currentBNode = currentBNode.next;
          diff--;
        }
      }

      while (currentANode != null && currentBNode != null) {
        if (currentANode == currentBNode) {
          return currentANode;
        }
        currentANode = currentANode.next;
        currentBNode = currentBNode.next;
      }

      return null;*/

      ListNode ptrA = nodeHeadA;
      ListNode ptrB = nodeHeadB;

      while (ptrA != ptrB) {
        ptrA = ptrA == null ? nodeHeadB : ptrA.next;
        ptrB = ptrB == null ? nodeHeadA : ptrB.next;
      }

      return ptrA;
    }
  }
}
