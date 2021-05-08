package explore.linkedlist;

/**
 * @author sumitdeo
 * @projectName Leetcode
 * @package explore.linkedlist
 * @date 5/8/21
 * @comment: https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
 */
public class DesignLinkedList {

  public static void main(String[] args) {
    MyLinkedList linkedList = new MyLinkedList();
    linkedList.addAtHead(2);
    //linkedList.addAtTail(3);
    linkedList.addAtIndex(0, 1);    // linked list becomes 1->2->3
    System.out.println(linkedList.get(1));              // return 2
    //linkedList.deleteAtIndex(1);    // now the linked list is 1->3
    //System.out.println(linkedList.get(1));              // return 3
  }

  private static class MyLinkedList {

    Node head;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
      size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
      if (index < 0 || index >= size) {
        return -1;
      }
      else if (index == 0) {
        return head.val;
      }

      Node currentNode = head;
      for (int i = 1; i <= index; i++) {
        currentNode = currentNode.nextNode;
      }

      return currentNode.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
      Node previousHead = head;
      head = new Node(val);
      head.nextNode = previousHead;
      size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
      addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
      if (index == 0) {
        addAtHead(val);
        return;
      }
      else if (index < 0 || index > size){
        return;
      }

      Node currentNode = head;
      for (int i = 1; i <= index - 1; i++) {
        currentNode = currentNode.nextNode;
      }

      Node newNode = new Node(val);
      newNode.nextNode = currentNode.nextNode;
      currentNode.nextNode = newNode;
      size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
      if (index < 0 || index >= size) {
        return;
      }
      else if (index == 0) {
        head = head.nextNode;
        size--;
        return;
      }

      Node currentNode = head;
      for (int i = 1; i <= index - 1; i++) {
        currentNode = currentNode.nextNode;
      }

      if (currentNode.nextNode.nextNode == null) {
        currentNode.nextNode = null;
      }
      else {
        currentNode.nextNode = currentNode.nextNode.nextNode;
      }
      size--;
    }

    private class Node {
      int val;
      Node nextNode;

      public Node(int val) {
        this.val = val;
      }

      @Override
      public String toString() {
        return "Node{" +
            "val=" + val +
            '}';
      }
    }
  }
}
