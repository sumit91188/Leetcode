package explore.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package leetcode.binaryTree
 * @date 5/4/21
 * @comment: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
 */
public class SerializeDeserialize {
  public static void main(String[] args) {
    TreeNode rootNode =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(6), new TreeNode(7, new TreeNode(8), null)),
            new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), new TreeNode(0)));

    Codec ser = new Codec();
    Codec des = new Codec();
    /*String test = ser.serialize(rootNode);
    //TreeNode ans = des.deserialize(ser.serialize(rootNode));
    System.out.println(test);*/
    TreeNode node = des.deserialize("5,4,2,6,7,1,0,NULL,NULL,8,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL");
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  private static class Codec {

    public String serialize(TreeNode rootNode) {
      String serializedStr = "";
      if (rootNode != null) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        while (!queue.isEmpty()) {
          int levelSize = queue.size();

          for (int i = 0; i <= levelSize - 1; i++) {
            TreeNode node = queue.poll();

            if (node == null) {
              serializedStr += "NULL,";
            } else {
              serializedStr += node.val + ",";
              if (node.left != null) {
                queue.offer(node.left);
              } else {
                queue.offer(null);
              }

              if (node.right != null) {
                queue.offer(node.right);
              } else {
                queue.offer(null);
              }
            }
          }
        }
      }
      return serializedStr.isEmpty() ? serializedStr : serializedStr.substring(0, serializedStr.length() - 1);
    }

    public TreeNode deserialize(String serializedStr) {
      if (serializedStr.isEmpty()) {
        return null;
      }

      int index = 0;
      String[] nodes = serializedStr.split(",");
      TreeNode rootNode = new TreeNode(Integer.parseInt(nodes[index++]));
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(rootNode);

      while (index <= nodes.length && !queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (! nodes[index].equals("NULL")) {
          node.left = new TreeNode(Integer.parseInt(nodes[index]));
          queue.offer(node.left);
        }
        index++;

        if (! nodes[index].equals("NULL")) {
          node.right = new TreeNode(Integer.parseInt(nodes[index]));
          queue.offer(node.right);
        }
        index++;
      }

      return rootNode;
    }
  }
}
