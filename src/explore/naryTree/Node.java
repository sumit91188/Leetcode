package explore.naryTree;

import java.util.List;

/**
 * @author Sumit Deo
 * @Date 7/3/21
 * @Project Leetcode
 * @Comments ref class
 */
public class Node {
    int val;
    List<Node> children;

    public Node() {
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
