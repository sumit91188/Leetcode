package interview.amazon.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.TreeNode
 * @date 10/8/20
 * @comment:
 */
public class TreeNode {
  public static void main(String[] args) {
    Node left = new Node(12);
    left.children = Arrays.asList(new Node(11), new Node(2), new Node(3));

    Node right = new Node(18);
    right.children = Arrays.asList(new Node(15), new Node(8));

    Node root = new Node(20);
    root.children = Arrays.asList(left, right);

    System.out.println(getMaximumAverage(root));
  }

  private static int getMaximumAverage(Node root) {
    HashMap<Node, List<Node>> nodes = new HashMap<>();
    nodes = getChildren(root, nodes);

    Iterator hmIterator = nodes.entrySet().iterator();
    while (hmIterator.hasNext()) {

    }
    return 0;
  }

  private static HashMap<Node, List<Node>> getChildren(Node root,
      HashMap<Node, List<Node>> nodes) {
    if (null != root.children) {
      nodes.put(root, root.children);
      for (Node child : root.children) {
        getChildren(child, nodes);
        List<Node> list = nodes.getOrDefault(root, Collections.emptyList());
        list = Stream.concat(list.stream(), nodes.getOrDefault(child, Collections.emptyList()).stream())
            .collect(Collectors.toList());
        nodes.put(root, list);
      }
    }
    return nodes;
  }

  static class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) { val = _val; }
    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
